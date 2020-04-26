package com.springboot.hello.test.cashier.factory.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class CashCondition implements Serializable {
    public int priority = 0;
    public int type;
    public double money;

    public double getResult(double money) {
        return money;
    }
}
