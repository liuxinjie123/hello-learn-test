package com.springboot.hello.test.cashier.strategy;

import com.springboot.hello.test.cashier.strategy.cashsuper.CashSuper;

/**
 * 区别于简单工厂方法，
 * 参数不一样时
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
