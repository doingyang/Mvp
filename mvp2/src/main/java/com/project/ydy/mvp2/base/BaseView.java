package com.project.ydy.mvp2.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * @author ydy
 * @date 2018/8/24
 */
public interface BaseView {

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 数据获取失败
     * @param throwable throwable
     */
    void onError(Throwable throwable);

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();
}
