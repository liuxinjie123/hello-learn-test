package com.springboot.hello.exception;

public class BusinessException extends RuntimeException {
    private String msg;

    public BusinessException() {}

    public BusinessException(String msg) {
        this.msg = msg;
    }

}
