package com.springboot.hello.test.cashier.factory.cashsuper;

/**
 * 正常收费，原价返回
 */
public class CashNormal extends CashSuper {
    public CashNormal() {}

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
