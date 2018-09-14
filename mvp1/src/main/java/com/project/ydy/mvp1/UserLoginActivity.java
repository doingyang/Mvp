package com.project.ydy.mvp1;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.ydy.mvp1.mvp.presenter.IUserLoginPresenter;
import com.project.ydy.mvp1.mvp.presenter.UserLoginPresenterImpl;
import com.project.ydy.mvp1.mvp.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {
    //LoginContract.View

    private TextInputEditText mEdtUsername, mEdtPwd;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private IUserLoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initViews();
    }

    private void initViews() {
        mPresenter = new UserLoginPresenterImpl(this);

        mEdtUsername = findViewById(R.id.input_username);
        mEdtPwd = findViewById(R.id.input_password);

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnClear = findViewById(R.id.btn_clear);

        mPbLoading = findViewById(R.id.pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.doLogin();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return mEdtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEdtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEdtPwd.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }
}
