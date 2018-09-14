package com.project.ydy.mvp2.presenter;

import com.project.ydy.mvp2.base.BasePresenter;
import com.project.ydy.mvp2.base.BaseResponse;
import com.project.ydy.mvp2.bean.LoginBean;
import com.project.ydy.mvp2.contract.MainContract;
import com.project.ydy.mvp2.http.RxScheduler;
import com.project.ydy.mvp2.model.MainModel;

import io.reactivex.functions.Consumer;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void login(String username, String password) {
        //View如果没有绑定，则不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseResponse<LoginBean>>floTransformer())
                .as(mView.<BaseResponse<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseResponse<LoginBean>>() {
                    @Override
                    public void accept(BaseResponse<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
