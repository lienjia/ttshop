package com.lej.ttshop.service;

import com.lej.common.dto.Order;
import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.pojo.po.TbItem;
import com.lej.ttshop.pojo.vo.TbItemCustom;
import com.lej.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 20:13
 * Version:V1.0
 */
public interface ItemService {
    List<TbItem> listItems();
    Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query);

    int updateItemByIds(List<Long> ids);

    int upItemsByIds(List<Long> ids);
    int saveItem(TbItem tbItem,String desc);
}
