package com.jdlx.edumanageoa.presenter.factory;


import com.jdlx.edumanageoa.activity.view.IMainView;
import com.jdlx.edumanageoa.presenter.impl.MainViewPresenter;
import com.jdlx.edumanageoa.presenter.interf.IMainViewPresenter;

/**
 * @author fupengpeng
 * @description 主界面主导器工厂
 * @data 2018/1/17 0017 18:19
 */

public class MainViewPresenterFactory {

    /**
     * 创建主界面主导器对象
     *
     * @param mainView 主界面
     * @return 主界面主导器对象
     */
    public static IMainViewPresenter newInstance(IMainView mainView) {
        return new MainViewPresenter(mainView);
    }


}
