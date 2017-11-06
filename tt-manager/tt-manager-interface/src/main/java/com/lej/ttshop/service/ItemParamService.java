package com.lej.ttshop.service;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.pojo.po.TbItemParam;
import com.lej.ttshop.pojo.vo.TbItemParamCustom;

/**
 * User: lienjiaa
 * Date: 2017/11/2
 * Time: 16:44
 * Version:V1.0
 */
public interface ItemParamService {
    Result<TbItemParamCustom> listItemParams(Page page);

    int saveItemParam(Long cid, String paramData);

    TbItemParam getItemParamByCid(Long cid);
}
