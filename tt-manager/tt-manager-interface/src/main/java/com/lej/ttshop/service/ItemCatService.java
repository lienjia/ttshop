package com.lej.ttshop.service;

import com.lej.common.dto.TreeNode;

import java.util.List;

/**
 * User: lienjiaa
 * Date: 2017/10/24
 * Time: 18:45
 * Version:V1.0
 */
public interface ItemCatService {
    List<TreeNode> listItemCats(Long parentId);
}
