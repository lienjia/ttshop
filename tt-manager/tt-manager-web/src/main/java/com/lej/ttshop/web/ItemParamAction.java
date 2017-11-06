package com.lej.ttshop.web;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.pojo.po.TbItemParam;
import com.lej.ttshop.pojo.vo.TbItemParamCustom;
import com.lej.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: lienjiaa
 * Date: 2017/11/2
 * Time: 16:39
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemParamAction {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/itemParams")
    @ResponseBody
    public Result<TbItemParamCustom> listItemParams(Page page){
        Result<TbItemParamCustom> rs = itemParamService.listItemParams(page);
        return rs;
    }

    @RequestMapping("itemParam/{cid}")
    @ResponseBody
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData") String paramData){
        int count = itemParamService.saveItemParam(cid, paramData);
        return count;
    }

    @RequestMapping(value = "itemParam/query/{cid}",method = RequestMethod.GET)
    @ResponseBody
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid){
        return itemParamService.getItemParamByCid(cid);
    }
}
