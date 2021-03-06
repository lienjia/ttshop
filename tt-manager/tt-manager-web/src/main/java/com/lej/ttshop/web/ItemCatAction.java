package com.lej.ttshop.web;

import com.lej.common.dto.TreeNode;
import com.lej.ttshop.service.ItemCatService;
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
 * Date: 2017/10/24
 * Time: 18:58
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemCatAction {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/itemCats",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> listItemCats(@RequestParam("parentId") Long parentId){
        return itemCatService.listItemCats(parentId);
    }
}
