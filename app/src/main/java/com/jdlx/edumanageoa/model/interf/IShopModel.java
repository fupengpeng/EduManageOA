package com.jdlx.edumanageoa.model.interf;

import com.jdlx.edumanageoa.common.ListCallBack;
import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.LoadUserShopInfoResponseData;
import com.jdlx.edumanageoa.entity.ShopAssistantCategory;
import com.jdlx.edumanageoa.entity.ShopOrgan;
import com.jdlx.edumanageoa.entity.ShopStatisticalData;

/**
 * 门店业务
 */
public interface IShopModel {
    /**
     * 加载门店店员列表
     *
     * @param callBack 门店店员列表
     * @param notIds   不显示的店员id,以","分割
     */
    void loadShopAssistantList(String notIds, final ListCallBack<ShopAssistantCategory> callBack);

    /**
     * 加载门店属性配置
     *
     * @param callBack 门店属性配置列表
     */
    void loadShopOrgan(String type, final ListCallBack<ShopOrgan> callBack);

    /**
     * 加载当前门店及个人信息
     *
     * @param shopId    门店ID
     * @param userId    用户ID
     * @param sessionId 用户登录后的验证ID
     * @param callBack  当前门店及个人信息
     */
    void loadUserShopInfo(String shopId, String userId, String sessionId,
                          final ObjectCallBack<LoadUserShopInfoResponseData> callBack);

    /**
     * 加载当前门店的统计数据
     *
     * @param shopId    门店ID
     * @param userId    用户ID
     * @param sessionId 用户登录后的验证ID
     * @param callBack  当前门店的统计数据
     */
    void loadOrderCount(String shopId, String userId, String sessionId,
                        final ObjectCallBack<ShopStatisticalData> callBack);
}
