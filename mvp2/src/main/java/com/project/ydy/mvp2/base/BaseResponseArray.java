package com.project.ydy.mvp2.base;

import java.util.List;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class BaseResponseArray<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : [] 数组
     */

    private int errorCode;
    private Object errorMsg;
    private List<T> result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
