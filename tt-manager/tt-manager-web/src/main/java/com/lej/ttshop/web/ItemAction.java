package com.lej.ttshop.web;

import com.lej.common.dto.Order;
import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.pojo.po.TbItem;
import com.lej.ttshop.pojo.vo.TbItemCustom;
import com.lej.ttshop.pojo.vo.TbItemQuery;
import com.lej.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 20:11
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
   private ItemService itemService;
//    @ResponseBody
//    @RequestMapping("/items")
//    public List<TbItem> listItems(){
//        return itemService.listItems();
//    }
    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query){

        return itemService.listItems(page,order,query);
    }
    @ResponseBody
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    public int updateItemsByIds(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateItemByIds(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
    public int upItemsByIds(@RequestParam("ids[]") List<Long> ids){
        return itemService.upItemsByIds(ids);
    }
     @ResponseBody
     @RequestMapping(value = "/item",method = RequestMethod.POST)
    public int saveItem(TbItem tbItem,String desc){
        return itemService.saveItem(tbItem,desc);
     }
}
