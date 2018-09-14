package com.project.ydy.mvp1.mvp.view;

/**
 * **************************************************
 * 文件名称 : IUserLoginView
 * 作    者 : Created by ydy
 * 创建时间 : 2018/8/24 14:07
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/8/24 1.00 初始版本
 * **************************************************
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity();

    void showFailedError();
}
