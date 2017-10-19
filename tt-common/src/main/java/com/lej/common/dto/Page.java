package com.lej.common.dto;

/**
 * 专门用于easyui的datagrid通用分页类(请求参数)
 * User: lienjiaa
 * Date: 2017/10/18
 * Time: 21:37
 * Version:V1.0
 */
public class Page {
    private int page;
    private int rows;
    //private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }


}
