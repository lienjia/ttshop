package com.lej.ttshop.service.impl;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.dao.TbItemCustomMapper;
import com.lej.ttshop.dao.TbItemMapper;
import com.lej.ttshop.pojo.po.TbItem;
import com.lej.ttshop.pojo.po.TbItemExample;
import com.lej.ttshop.pojo.vo.TbItemCustom;
import com.lej.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 20:15
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper mapper;
    @Autowired
    private TbItemCustomMapper itemCustomMapper;
    @Override
    public List<TbItem> listItems() {
        return mapper.selectByExample(null);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page) {
        long total = itemCustomMapper.countItems();
        List<TbItemCustom> rows = itemCustomMapper.listItemsByPage(page);
        Result<TbItemCustom> rs = new Result<>();
        rs.setRows(rows);
        rs.setTotal(total);
        return rs;
    }

    @Override
    public int updateItemByIds(List<Long> ids) {
        //创建商品的空对象
        TbItem item = new TbItem();
        item.setStatus((byte)3);
        //准备查询的条件
       TbItemExample example = new TbItemExample();
       TbItemExample.Criteria criteria = example.createCriteria();
       criteria.andIdIn(ids);
       //真正的执行查询
        return mapper.updateByExampleSelective(item,example);
    }
}
