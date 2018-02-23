package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.BeforehandAppoint;

/**
 * @author fupengpeng
 * @description 预约详情响应
 * @data 2018/1/24 0024 13:23
 */

public class LoadBeforehandAppointDetailResponse extends BaseResponse {

    // 订单详情
    private BeforehandAppoint data;

    public BeforehandAppoint getData() {
        return data;
    }

    public void setData(BeforehandAppoint data) {
        this.data = data;
    }

}
