package com.project.ydy.mvp2.base;

/**
 * @author ydy
 * @date 2018/8/24
 */
public class BaseResponse<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : {} 对象
     */

    private int status;
    private String msg;
    private T result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
