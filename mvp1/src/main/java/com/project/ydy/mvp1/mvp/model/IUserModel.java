package com.project.ydy.mvp1.mvp.model;

/**
 * **************************************************
 * 文件名称 : IUserModel
 * 作    者 : Created by ydy
 * 创建时间 : 2018/8/24 13:59
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/8/24 1.00 初始版本
 * **************************************************
 */
public interface IUserModel {

    void login(String username, String password, OnLoginListener listener);

    /**
     * 回调接口，放到IUserModel中，或者放到presenter的接口中，也可以单独抽离出来
     */
    interface OnLoginListener {

        void loginSuccess();

        void loginFailed();
    }
}
