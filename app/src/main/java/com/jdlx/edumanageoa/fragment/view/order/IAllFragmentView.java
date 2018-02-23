package com.jdlx.edumanageoa.fragment.view.order;


import com.jdlx.edumanageoa.entity.LoadOrderListResponseData;

/**
 * @description  全部
 * @author  fupengpeng
 * @date  2017/12/20 0020 20:02
 */

public interface IAllFragmentView {

    /**
     * 当加载订单列表成功
     *
     * @param state 状态：1.待结单，2.服务中，8.已完成,9.已取消
     * @param data  响应数据
     */
    void onLoadOrderListSuccess(int state, LoadOrderListResponseData data);

    /**
     * 当加载数据失败
     *
     * @param e 失败信息
     */
    void onLoadDataFail(Exception e);

}
