package com.springboot.hello.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BusinessException extends RuntimeException {
    private String msg;

    public BusinessException() {}

    public BusinessException(String msg) {
        this.msg = msg;
    }

}
