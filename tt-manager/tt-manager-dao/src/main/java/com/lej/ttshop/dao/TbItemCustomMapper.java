package com.lej.ttshop.dao;

import com.lej.common.dto.Page;
import com.lej.ttshop.pojo.po.TbItem;

import java.util.List;

public interface TbItemCustomMapper {
    long countItems();
    List<TbItem> listItemsByPage(Page page);
}