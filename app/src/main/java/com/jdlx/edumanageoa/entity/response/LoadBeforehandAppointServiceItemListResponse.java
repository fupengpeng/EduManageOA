package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.ServiceItem;

import java.util.List;

/**
 * @author fupengpeng
 * @description 预约服务项列表响应
 * @data 2018/1/23 0023 18:01
 */

public class LoadBeforehandAppointServiceItemListResponse extends BaseResponse {

    private List<ServiceItem> data ;

    public List<ServiceItem> getData() {
        return data;
    }

    public void setData(List<ServiceItem> data) {
        this.data = data;
    }
}
