package com.springboot.hello.test.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation implements Serializable {
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

    public String getResult() {
        return null;
    }

}
