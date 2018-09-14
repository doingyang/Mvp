package com.project.ydy.mvp1.mvp.contract;

/**
 * **************************************************
 * 文件名称 : LoginContract
 * 作    者 : Created by ydy
 * 创建时间 : 2018/8/24 14:12
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/8/24 1.00 初始版本
 * **************************************************
 */
public interface LoginContract {

    interface View {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity();

        void showFailedError();
    }

    interface Presenter {

        void login();

        void clear();
    }
}
