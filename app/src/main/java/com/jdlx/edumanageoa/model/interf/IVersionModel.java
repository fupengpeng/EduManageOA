package com.jdlx.edumanageoa.model.interf;


import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.response.NewVersionResponse;

/**
 * 版本业务
 */
public interface IVersionModel {
    /**
     * 获取最新版本信息
     *
     * @param callBack 回调
     */
    void getNewVersionInfo(final ObjectCallBack<NewVersionResponse> callBack);


    /**
     * 下载APK文件
     *
     * @param what 版本更新Service启动标识
     */
    void downloadAPK(int what);
}
