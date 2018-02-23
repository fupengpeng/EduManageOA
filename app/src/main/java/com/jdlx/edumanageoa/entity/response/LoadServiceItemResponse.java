package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.ServiceItem;

import java.util.List;

/**
 * @author fupengpeng
 * @description 服务项列表
 * @data 2018/2/9 0009 9:43
 */

public class LoadServiceItemResponse extends BaseResponse {

    private List<ServiceItem> data;

    public List<ServiceItem> getData() {
        return data;
    }

    public void setData(List<ServiceItem> data) {
        this.data = data;
    }
}
