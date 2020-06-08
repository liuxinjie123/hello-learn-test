package com.springboot.hello.test.cashier.factory.cashsuper;

import com.springboot.hello.test.cashier.factory.condition.CashCondition;

import java.io.Serializable;

/**
 * 正常收费，原价返回
 */
public class CashNormal implements Serializable {
    private CashCondition condition;
    public CashNormal() {}

    public CashNormal(CashCondition condition) {
        this.condition = condition;
    }

    public double acceptCash(double money) {
        if (null == condition) {
            return money;
        } else {
            return condition.getResult(money);
        }
    }
}
