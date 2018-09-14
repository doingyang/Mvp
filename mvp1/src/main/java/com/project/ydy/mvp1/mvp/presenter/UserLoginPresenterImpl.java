package com.project.ydy.mvp1.mvp.presenter;

import android.os.Handler;

import com.project.ydy.mvp1.mvp.model.IUserModel;
import com.project.ydy.mvp1.mvp.model.UserModelImpl;
import com.project.ydy.mvp1.mvp.view.IUserLoginView;

/**
 * **************************************************
 * 文件名称 : UserLoginPresenterImpl
 * 作    者 : Created by ydy
 * 创建时间 : 2018/8/24 14:09
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/8/24 1.00 初始版本
 * **************************************************
 */
public class UserLoginPresenterImpl implements IUserLoginPresenter, IUserModel.OnLoginListener {
    //LoginContract.Presenter

    private IUserLoginView mIUserLoginView;
    private IUserModel mIUserModel;

    private Handler mHandler = new Handler();

    public UserLoginPresenterImpl(IUserLoginView IUserLoginView) {
        mIUserLoginView = IUserLoginView;
        mIUserModel = new UserModelImpl(this);
    }

    @Override
    public void doLogin() {
        String username = mIUserLoginView.getUserName();
        String password = mIUserLoginView.getPassword();
        mIUserLoginView.showLoading();
        mIUserModel.login(username,password,this);
    }

    @Override
    public void loginSuccess() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.hideLoading();
                mIUserLoginView.toMainActivity();
            }
        });
    }

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.hideLoading();
                mIUserLoginView.showFailedError();
            }
        });
    }

    @Override
    public void clear() {
        mIUserLoginView.clearUserName();
        mIUserLoginView.clearPassword();
    }
}
