package com.springboot.hello.test.cashier.strategy.cashsuper;

import lombok.NoArgsConstructor;

/**
 * 正常收费，原价返回
 */
@NoArgsConstructor
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
