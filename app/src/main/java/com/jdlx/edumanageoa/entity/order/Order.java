package com.jdlx.edumanageoa.entity.order;


/**
 * 服务单
 */

public class Order {

    private String orderId;  // 服务单id ---唯一
    private String orderNumber;  // 服务单编号
    private String orderStatus;  // 服务单状态
    private String orderDate;  // 服务单创建日期

    private String orderUserPic;  // 客户头像
    private String orderUserName;  // 客户名称
    private String orderUserGender;  // 客户性别
    private String orderUserPhoneNumber;  //  客户联系方式
    private String orderUserStatus;  //  客户是否是会员


    private String orderServiceItemName;  // 最后一项服务名称
    private String orderWaiterName;  // 最后一项服务的服务员名称
    private String orderServiceItemStatus;  // 最后一项服务的服务状态
    private String orderServiceTime;  // 最后一项服务的服务时间--进行中（变化）--已完成（固定）

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderUserPic() {
        return orderUserPic;
    }

    public void setOrderUserPic(String orderUserPic) {
        this.orderUserPic = orderUserPic;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderUserGender() {
        return orderUserGender;
    }

    public void setOrderUserGender(String orderUserGender) {
        this.orderUserGender = orderUserGender;
    }

    public String getOrderUserPhoneNumber() {
        return orderUserPhoneNumber;
    }

    public void setOrderUserPhoneNumber(String orderUserPhoneNumber) {
        this.orderUserPhoneNumber = orderUserPhoneNumber;
    }

    public String getOrderUserStatus() {
        return orderUserStatus;
    }

    public void setOrderUserStatus(String orderUserStatus) {
        this.orderUserStatus = orderUserStatus;
    }

    public String getOrderServiceItemName() {
        return orderServiceItemName;
    }

    public void setOrderServiceItemName(String orderServiceItemName) {
        this.orderServiceItemName = orderServiceItemName;
    }

    public String getOrderWaiterName() {
        return orderWaiterName;
    }

    public void setOrderWaiterName(String orderWaiterName) {
        this.orderWaiterName = orderWaiterName;
    }

    public String getOrderServiceItemStatus() {
        return orderServiceItemStatus;
    }

    public void setOrderServiceItemStatus(String orderServiceItemStatus) {
        this.orderServiceItemStatus = orderServiceItemStatus;
    }

    public String getOrderServiceTime() {
        return orderServiceTime;
    }

    public void setOrderServiceTime(String orderServiceTime) {
        this.orderServiceTime = orderServiceTime;
    }
}
