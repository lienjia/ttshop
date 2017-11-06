package com.lej.ttshop.service.impl;

import com.lej.common.dto.Order;
import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.common.util.IDUtils;
import com.lej.ttshop.dao.TbItemCustomMapper;
import com.lej.ttshop.dao.TbItemDescMapper;
import com.lej.ttshop.dao.TbItemMapper;
import com.lej.ttshop.pojo.po.TbItem;
import com.lej.ttshop.pojo.po.TbItemDesc;
import com.lej.ttshop.pojo.po.TbItemExample;
import com.lej.ttshop.pojo.vo.TbItemCustom;
import com.lej.ttshop.pojo.vo.TbItemQuery;
import com.lej.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public List<TbItem> listItems() {
        return mapper.selectByExample(null);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("order", order);
        map.put("query",query);
        long total = itemCustomMapper.countItems(map);
        List<TbItemCustom> rows = itemCustomMapper.listItemsByPage(map);
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

    @Override
    public int upItemsByIds(List<Long> ids) {
        //创建商品的空对象
        TbItem item = new TbItem();
        item.setStatus((byte)1);
        //准备查询的条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return mapper.updateByExampleSelective(item,example);
    }

    @Override
    public int saveItem(TbItem tbItem, String desc) {
        Long itemId = IDUtils.getItemId();
        tbItem.setId(itemId);
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        int count = mapper.insert(tbItem);
        //存商品描述表
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        count +=itemDescMapper.insert(tbItemDesc);
        return count;
    }
}
