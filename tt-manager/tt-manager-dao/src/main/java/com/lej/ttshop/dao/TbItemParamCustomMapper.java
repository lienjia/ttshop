package com.lej.ttshop.dao;

import com.lej.ttshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);

    long countItemParams(Map<String, Object> map);
}