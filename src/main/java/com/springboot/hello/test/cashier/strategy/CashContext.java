package com.springboot.hello.test.cashier.strategy;

import com.springboot.hello.test.cashier.strategy.cashsuper.CashSuper;

public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
