package com.project.ydy.mvp2;

import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

import com.project.ydy.mvp2.base.BaseMvpActivity;
import com.project.ydy.mvp2.base.BaseResponse;
import com.project.ydy.mvp2.contract.MainContract;
import com.project.ydy.mvp2.presenter.MainPresenter;
import com.project.ydy.mvp2.util.ProgressDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.et_username)
    TextInputEditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseResponse bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @OnClick(R.id.btn_signin)
    public void onViewClicked() {
        if (getUsername().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.login(getUsername(), getPassword());
    }
}
