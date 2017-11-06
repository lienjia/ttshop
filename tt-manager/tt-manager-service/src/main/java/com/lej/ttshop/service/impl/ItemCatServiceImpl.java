package com.lej.ttshop.service.impl;

import com.lej.common.dto.TreeNode;
import com.lej.ttshop.dao.TbItemCatMapper;
import com.lej.ttshop.pojo.po.TbItemCat;
import com.lej.ttshop.pojo.po.TbItemCatExample;
import com.lej.ttshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/24
 * Time: 18:49
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        //创建查询模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<TreeNode> resultList = new ArrayList<>();
        //遍历原有集合
        for (int i=0;i<list.size();i++){
            TreeNode node = new TreeNode();
            node.setId(list.get(i).getId());
            node.setText(list.get(i).getName());
            node.setState(list.get(i).getIsParent() ? "closed" : "open");
            resultList.add(node);
        }
        return resultList;
    }
}
