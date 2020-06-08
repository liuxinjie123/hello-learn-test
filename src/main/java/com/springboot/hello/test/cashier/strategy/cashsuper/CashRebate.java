package com.springboot.hello.test.cashier.strategy.cashsuper;

import lombok.NoArgsConstructor;

/**
 * 打折收费，初始化时，必须输入折扣率
 *
 * 如8折，就是0.8
 */
@NoArgsConstructor
public class CashRebate extends CashSuper {
    private double moneyRebate = 0.8;

    @Override
    public double acceptCash(double money) {
        return Math.floor(money * moneyRebate);
    }
}
