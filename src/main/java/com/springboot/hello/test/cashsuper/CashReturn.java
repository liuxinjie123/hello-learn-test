package com.springboot.hello.test.cashsuper;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 满减
 *
 * 例： 每满 300 减 100
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CashReturn extends CashSuper {
    private CashReturnCondition condition;

    public CashReturn() {}

    public CashReturn(CashReturnCondition condition) {
        this.condition = condition;
    }

    @Override
    public double acceptCash(double money) {
        return condition.getResult(money);
    }
}
