package com.project.ydy.mvp2.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.project.ydy.mvp2.R;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class ProgressDialog {

    private static volatile ProgressDialog instance;
    private MaterialDialog materialDialog;

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    public void show(Context mContext) {
        materialDialog = new MaterialDialog.Builder(mContext)
                .title(R.string.progress_dialog_title)
                .content(R.string.progress_please_wait)
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();

    }

    public void dismiss() {
        materialDialog.dismiss();
    }
}
