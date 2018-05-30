package com.beaven.daggerstudy.model.net.codes;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:21
 */

public class ApiException extends Exception {

    private int code;
    private String message;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
