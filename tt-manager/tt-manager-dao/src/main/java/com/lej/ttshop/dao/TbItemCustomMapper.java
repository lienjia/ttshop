package com.lej.ttshop.dao;

import com.lej.ttshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    long countItems(Map<String,Object> map);
    List<TbItemCustom> listItemsByPage(Map<String,Object> map);
}