package com.springboot.hello.test.cashsuper;

/**
 * 打折收费，初始化时，必须输入折扣率
 *
 * 如8折，就是0.8
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate() {}

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
