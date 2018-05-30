package com.beaven.daggerstudy.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:10
 */

public class ApiResponse<T> {

    private String reason;
    @SerializedName("error_code")
    private int errorCode;
    private T result;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public int getCode() {
        return errorCode;
    }

    public T getResult() {
        return result;
    }

    public boolean isSuccess() {
        return errorCode == 0;
    }
}
