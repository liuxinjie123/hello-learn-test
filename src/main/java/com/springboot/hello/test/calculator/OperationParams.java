package com.springboot.hello.test.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class OperationParams implements Serializable {
    /**
     * 数字1
     */
    public double num1;

    /**
     * 运算符
     */
    public String operator;

    /**
     * 数字2
     */
    public double num2;

    public OperationParams() {}

    public OperationParams(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
