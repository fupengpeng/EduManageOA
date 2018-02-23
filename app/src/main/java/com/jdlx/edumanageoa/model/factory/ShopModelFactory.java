package com.jdlx.edumanageoa.model.factory;

import com.jdlx.edumanageoa.model.impl.ShopModel;
import com.jdlx.edumanageoa.model.interf.IShopModel;

/**
 * 门店业务工厂
 */
public class ShopModelFactory {

    /**
     * 创建门店业务实例
     *
     * @return 门店业务实例
     */
    public static IShopModel newInstance() {
        return new ShopModel();
    }
}
