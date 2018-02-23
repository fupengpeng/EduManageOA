package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.OrderItem;

/**
 * 加载订单详情的响应
 */
public class LoadOrderDetailResponse extends  BaseResponse{
    // 订单详情
    private OrderItem data;

    public OrderItem getData() {
        return data;
    }

    public void setData(OrderItem data) {
        this.data = data;
    }
}
