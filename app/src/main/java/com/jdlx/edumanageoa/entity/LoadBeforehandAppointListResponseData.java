package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @description  加载预约列表的响应数据
 * @author  fupengpeng
 * @date  2018/1/15 0015 8:50
 */
public class LoadBeforehandAppointListResponseData {
    // 数据总量
    private int datanum;
    // 调取数量
    private int count;
    // 所在分页
    private int page;
    // 下一页,-1则为最后一页
    private int nextpage;
    // 订单列表
    private List<BeforehandAppoint> list;

    public int getDatanum() {
        return datanum;
    }

    public void setDatanum(int datanum) {
        this.datanum = datanum;
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

    public List<BeforehandAppoint> getList() {
        return list;
    }

    public void setList(List<BeforehandAppoint> list) {
        this.list = list;
    }
}
