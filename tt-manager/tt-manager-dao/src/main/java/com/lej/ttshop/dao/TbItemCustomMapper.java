package com.lej.ttshop.dao;

import com.lej.common.dto.Page;
import com.lej.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {
    long countItems();
    List<TbItemCustom> listItemsByPage(Page page);
}