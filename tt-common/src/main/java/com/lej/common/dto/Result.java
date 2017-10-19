package com.lej.common.dto;

import java.util.List;

/**
 * 专门用于easyui的datagrid通用分页类(响应参数)
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 21:47
 * Version:V1.0
 */
public class Result<T> {
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
