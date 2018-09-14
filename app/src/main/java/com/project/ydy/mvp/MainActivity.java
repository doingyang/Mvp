package com.project.ydy.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnMvpPrimary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mvp_primary:
                //
                break;
            default:
                break;
        }
    }

    private void setListener() {
        mBtnMvpPrimary.setOnClickListener(this);
    }

    private void initView() {
        mBtnMvpPrimary = (Button) findViewById(R.id.btn_mvp_primary);
    }
}
