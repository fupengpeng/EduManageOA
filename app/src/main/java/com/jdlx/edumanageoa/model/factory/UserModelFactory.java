package com.jdlx.edumanageoa.model.factory;


import com.jdlx.edumanageoa.model.impl.UserModel;
import com.jdlx.edumanageoa.model.interf.IUserModel;

/**
 * 用户业务工厂
 */
public class UserModelFactory {

    /**
     * 创建用户业务实例
     *
     * @return 用户业务实例
     */
    public static IUserModel newInstance() {
        return new UserModel();
    }
}
