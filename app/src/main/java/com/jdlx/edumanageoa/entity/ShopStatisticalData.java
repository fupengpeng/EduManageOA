package com.jdlx.edumanageoa.entity;

/**
 * 门店统计数据
 */
public class ShopStatisticalData {
    // 订单总数
    private String all;
    // 进行中
    private String start;
    // 未开始
    private String prep;
    // 来客数量
    private String mnum;
    // 新增会员量
    private String nmnum;
    // 营业额
    private String income;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getMnum() {
        return mnum;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }

    public String getNmnum() {
        return nmnum;
    }

    public void setNmnum(String nmnum) {
        this.nmnum = nmnum;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
