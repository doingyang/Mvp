package com.project.ydy.mvp1.mvp.model;

import com.project.ydy.mvp1.bean.User;
import com.project.ydy.mvp1.mvp.presenter.IUserLoginPresenter;

/**
 * **************************************************
 * 文件名称 : UserModelImpl
 * 作    者 : Created by ydy
 * 创建时间 : 2018/8/24 14:05
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/8/24 1.00 初始版本
 * **************************************************
 */
public class UserModelImpl implements IUserModel {

    private IUserLoginPresenter mIUserLoginPresenter;

    public UserModelImpl(IUserLoginPresenter IUserLoginPresenter) {
        mIUserLoginPresenter = IUserLoginPresenter;
    }

    @Override
    public void login(final String username, final String password, final IUserModel.OnLoginListener listener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("ydy".equals(username) && "666666".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    listener.loginSuccess();
                } else {
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
