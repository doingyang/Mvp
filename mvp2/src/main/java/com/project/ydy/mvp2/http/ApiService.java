package com.project.ydy.mvp2.http;


import com.project.ydy.mvp2.base.BaseResponse;
import com.project.ydy.mvp2.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author ydy
 * @date 2018/8/24
 */
public interface ApiService {

    /**
     * 登陆
     * @param username 账号
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseResponse<LoginBean>> login(@Field("username") String username, @Field("password") String password);
}
