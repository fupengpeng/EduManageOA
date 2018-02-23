package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * 加载订单列表的响应数据
 */
public class LoadOrderListResponseData {
    // 数据总量
    private int ordernum;
    // 调取数量
    private int count;
    // 所在分页
    private int page;
    // 下一页,-1则为最后一页
    private int nextpage;
    // 订单列表
    private List<OrderItem> list;

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNextpage() {
        return nextpage;
    }

    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
