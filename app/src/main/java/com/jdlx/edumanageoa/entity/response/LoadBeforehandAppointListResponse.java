package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.LoadBeforehandAppointListResponseData;

/**
 * @description  加载预约列表的响应
 * @author  fupengpeng
 * @date  2018/1/15 0015 8:51
 */
public class LoadBeforehandAppointListResponse extends BaseResponse {
    // 加载订单列表的响应数据
    private LoadBeforehandAppointListResponseData data;

    public LoadBeforehandAppointListResponseData getData() {
        return data;
    }

    public void setData(LoadBeforehandAppointListResponseData data) {
        this.data = data;
    }
}
