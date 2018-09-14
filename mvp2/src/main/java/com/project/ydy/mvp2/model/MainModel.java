package com.project.ydy.mvp2.model;

import com.project.ydy.mvp2.base.BaseResponse;
import com.project.ydy.mvp2.bean.LoginBean;
import com.project.ydy.mvp2.contract.MainContract;
import com.project.ydy.mvp2.http.ApiRetrofit;

import io.reactivex.Flowable;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class MainModel implements MainContract.Model {

    @Override
    public Flowable<BaseResponse<LoginBean>> login(String username, String password) {
        return ApiRetrofit.getInstance().getApi().login(username, password);
    }

}
