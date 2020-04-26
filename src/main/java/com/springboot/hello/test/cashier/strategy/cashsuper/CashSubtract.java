package com.springboot.hello.test.cashier.strategy.cashsuper;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 满减
 *
 * 例： 每满 300 减 100
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CashSubtract extends CashSuper {
    private final double MONEY_CONDITION = 300;
    private final double MONEY_SUBTRACT = 100;

    @Override
    public double acceptCash(double money) {
        return money - (int) (money / MONEY_CONDITION) * MONEY_SUBTRACT;
    }
}
