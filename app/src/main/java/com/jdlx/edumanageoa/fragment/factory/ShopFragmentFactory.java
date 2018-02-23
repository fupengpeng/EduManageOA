package com.jdlx.edumanageoa.fragment.factory;


import com.jdlx.edumanageoa.fragment.impl.shop.ShopFragment;
import com.jdlx.edumanageoa.fragment.view.shop.IShopView;

/**
 * 门店Fragment工厂
 */
public class ShopFragmentFactory {
    public static IShopView newInstance(){
        return new ShopFragment();
    }
}
