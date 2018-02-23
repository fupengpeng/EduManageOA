package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.ServiceCategory;

import java.util.List;

/**
 * 加载服务项目列表的响应
 */
public class LoadServiceItemListResponse extends BaseResponse {
    // 服务分类列表（服务分类中包含服务项目列表）
    private List<ServiceCategory> data;

    public List<ServiceCategory> getData() {
        return data;
    }

    public void setData(List<ServiceCategory> data) {
        this.data = data;
    }
}
