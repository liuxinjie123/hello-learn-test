package com.springboot.hello.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    public String code;
    public String msg;
    public Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private static final String CODE_SUCCESS = "0";
    private static final String MSG_SUCCESS = "请求成功";

    private static final String CODE_ERROR = "1";
    private static final String MSG_ERROR = "请求异常";

    public static Result success() {
        return new Result(CODE_SUCCESS, MSG_SUCCESS);
    }

    public static Result success(String msg) {
        return new Result(CODE_SUCCESS, msg);
    }

    public static Result error() {
        return new Result(CODE_ERROR, MSG_ERROR);
    }

    public static Result error(String msg) {
        return new Result(CODE_ERROR, msg);
    }

    public static Result success2(Object data) {
        return new Result(CODE_SUCCESS, MSG_SUCCESS, data);
    }
}
