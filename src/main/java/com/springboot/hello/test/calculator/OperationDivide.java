package com.springboot.hello.test.calculator;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OperationDivide extends Operation implements Serializable {
    private final String NOT_0_ERROR = "除数不能为0";
    @Override
    public String getResult() {
        if (0 == num2) {
            return NOT_0_ERROR;
        }
        return String.valueOf(num1 / num2);
    }
}
