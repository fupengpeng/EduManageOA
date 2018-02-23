package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @author fupengpeng
 * @description 设置时段价格响应数据
 * @data 2018/1/25 0025 13:31
 */

public class LoadSetTimePriceResponseData {

    private String startTime;

    private String endTime;

    private String appointNum;

    private String itemNum;

    private String itemDiscount;

    private List<ServiceItem>  serviceItemList;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAppointNum() {
        return appointNum;
    }

    public void setAppointNum(String appointNum) {
        this.appointNum = appointNum;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public List<ServiceItem> getServiceItemList() {
        return serviceItemList;
    }

    public void setServiceItemList(List<ServiceItem> serviceItemList) {
        this.serviceItemList = serviceItemList;
    }
}
