package com.lej.ttshop.service.impl;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.dao.TbItemCustomMapper;
import com.lej.ttshop.dao.TbItemMapper;
import com.lej.ttshop.pojo.po.TbItem;
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
    public Result<TbItem> listItems(Page page) {
        long total = itemCustomMapper.countItems();
        List<TbItem> rows = itemCustomMapper.listItemsByPage(page);
        Result<TbItem> rs = new Result<>();
        rs.setRows(rows);
        rs.setTotal(total);
        return rs;
    }
}
