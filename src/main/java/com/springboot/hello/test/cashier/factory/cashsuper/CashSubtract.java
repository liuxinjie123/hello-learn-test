package com.springboot.hello.test.cashier.factory.cashsuper;

import com.springboot.hello.test.cashier.factory.condition.CashCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 满减
 *
 * 例： 每满 300 减 100
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CashSubtract extends CashSuper {
    private CashCondition condition;

    public CashSubtract() {}

    public CashSubtract(CashCondition condition) {
        this.condition = condition;
    }

    @Override
    public double acceptCash(double money) {
        return condition.getResult(money);
    }
}
