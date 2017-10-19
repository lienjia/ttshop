package com.lej.ttshop.service;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.pojo.po.TbItem;

import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 20:13
 * Version:V1.0
 */
public interface ItemService {
    List<TbItem> listItems();
    Result<TbItem> listItems(Page page);
}