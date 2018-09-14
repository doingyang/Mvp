package com.project.ydy.mvp2.contract;

import com.project.ydy.mvp2.base.BaseResponse;
import com.project.ydy.mvp2.base.BaseView;
import com.project.ydy.mvp2.bean.LoginBean;

import io.reactivex.Flowable;

/**
 * @author ydy
 * @date 2018/8/24
 */
public interface MainContract {

    interface Model {
        Flowable<BaseResponse<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseResponse<LoginBean> bean);
    }

    interface Presenter {
        /**
         * 登陆
         * @param username username
         * @param password password
         */
        void login(String username, String password);
    }
}
