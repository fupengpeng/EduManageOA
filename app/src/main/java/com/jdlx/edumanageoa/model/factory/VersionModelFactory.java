package com.jdlx.edumanageoa.model.factory;


import com.jdlx.edumanageoa.model.impl.VersionModel;
import com.jdlx.edumanageoa.model.interf.IVersionModel;

/**
 * 版本业务工厂
 */
public class VersionModelFactory {

    /**
     * 创建版本业务实例
     *
     * @return 版本业务实例
     */
    public static IVersionModel newInstance() {
        return new VersionModel();
    }
}
