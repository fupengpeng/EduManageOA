package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.LoadSetTimePriceResponseData;

/**
 * @author fupengpeng
 * @description 设置时段价格响应
 * @data 2018/1/25 0025 13:35
 */

public class LoadSetTimePriceResponse extends BaseResponse {

    LoadSetTimePriceResponseData data ;

    public LoadSetTimePriceResponseData getData() {
        return data;
    }

    public void setData(LoadSetTimePriceResponseData data) {
        this.data = data;
    }
}
