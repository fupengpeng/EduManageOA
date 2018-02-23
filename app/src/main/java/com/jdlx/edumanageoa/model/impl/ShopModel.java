package com.jdlx.edumanageoa.model.impl;

import com.alibaba.fastjson.JSON;
import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.common.ListCallBack;
import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.LoadUserShopInfoResponseData;
import com.jdlx.edumanageoa.entity.ShopAssistantCategory;
import com.jdlx.edumanageoa.entity.ShopOrgan;
import com.jdlx.edumanageoa.entity.ShopStatisticalData;
import com.jdlx.edumanageoa.entity.response.LoadOrderCountResponse;
import com.jdlx.edumanageoa.entity.response.LoadShopAssistantListResponse;
import com.jdlx.edumanageoa.entity.response.LoadShopOrganResponse;
import com.jdlx.edumanageoa.entity.response.LoadUserShopInfoResponse;
import com.jdlx.edumanageoa.model.interf.IShopModel;
import com.jdlx.edumanageoa.util.DateUtils;
import com.jdlx.edumanageoa.util.LogUtils;
import com.jdlx.edumanageoa.util.MD5Util;
import com.jdlx.edumanageoa.util.SPUtils;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

/**
 * 门店业务
 */
public class ShopModel implements IShopModel {
    /**
     * 请求队列
     */
    private static RequestQueue requestQueue = NoHttp.newRequestQueue(3);

    /**
     * 加载门店店员列表
     *
     * @param callBack 门店店员列表
     * @param notIds   不显示的店员id,以","分割
     */
    @Override
    public void loadShopAssistantList(String notIds, final ListCallBack<ShopAssistantCategory> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "getuserlist";
        request.add("a", a);
        request.add("not", notIds);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadShopAssistantListResponse loadShopAssistantListResponse
                        = JSON.parseObject(result, LoadShopAssistantListResponse.class);
                // 判断是否成功
                if (loadShopAssistantListResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadShopAssistantListResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadShopAssistantListResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载门店属性配置
     *
     * @param callBack 门店属性配置列表
     */
    @Override
    public void loadShopOrgan(String type, final ListCallBack<ShopOrgan> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "shoporgan";
        request.add("a", a);
        request.add("type", type);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadShopOrganResponse loadShopOrganResponse
                        = JSON.parseObject(result, LoadShopOrganResponse.class);
                // 判断是否成功
                if (loadShopOrganResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadShopOrganResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadShopOrganResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载当前门店及个人信息
     *
     * @param shopId    门店ID
     * @param userId    用户ID
     * @param sessionId 用户登录后的验证ID
     * @param callBack  当前门店及个人信息
     */
    @Override
    public void loadUserShopInfo(String shopId, String userId, String sessionId,
                                 final ObjectCallBack<LoadUserShopInfoResponseData> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "UserShopInfo";
        request.add("a", a);
        request.add("shopId", shopId);
        request.add("userId", userId);
        request.add("sessionId", sessionId);
        request.add("token", MD5Util.getMD5(sessionId + shopId + userId + a
                + "<*?hello.Kaiyuan.com//" + DateUtils.getCurrDate()));


        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                LogUtils.e("店铺信息 = " + result);
                // 解析
                LoadUserShopInfoResponse loadUserShopInfoResponse = JSON.parseObject(result, LoadUserShopInfoResponse.class);
                // 判断是否成功
                if (loadUserShopInfoResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadUserShopInfoResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadUserShopInfoResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载当前门店的统计数据
     *
     * @param shopId    门店ID
     * @param userId    用户ID
     * @param sessionId 用户登录后的验证ID
     * @param callBack  当前门店的统计数据
     */
    @Override
    public void loadOrderCount(String shopId, String userId, String sessionId,
                               final ObjectCallBack<ShopStatisticalData> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "OrderCount";
        request.add("a", a);
        request.add("shopId", shopId);
        request.add("userId", userId);
        request.add("sessionId", sessionId);
        request.add("token", MD5Util.getMD5(sessionId + shopId + userId + a
                + "<*?hello.Kaiyuan.com//" + DateUtils.getCurrDate()));

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadOrderCountResponse loadOrderCountResponse = JSON.parseObject(result, LoadOrderCountResponse.class);
                // 判断是否成功
                if (loadOrderCountResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadOrderCountResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadOrderCountResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 请求的公共参数
     *
     * @param a       操作
     * @param request 请求
     */
    private void requestCommonPerm(String a, Request<String> request) {
        // 获取公共数据
        String userId = MyApplication.getInstance().getUser().getId();
        String sessionId = (String) SPUtils.get(MyApplication.getInstance(), Consts.SESSION, "x");
        String shopId = MyApplication.getInstance().getCurrShop().getId();

        request.add("shopId", shopId);
        request.add("userId", userId);
        request.add("sessionId", sessionId);
        request.add("token", MD5Util.getMD5(sessionId + shopId + userId + a
                + "<*?hello.Kaiyuan.com//" + DateUtils.getCurrDate()));
    }
}
