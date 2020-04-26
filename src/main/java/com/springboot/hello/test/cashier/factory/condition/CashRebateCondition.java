package com.springboot.hello.test.cashier.factory.condition;

import com.springboot.hello.test.cashier.constant.CashConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CashRebateCondition extends CashCondition {
    private double moneyRebate;

    public CashRebateCondition() {}

    public CashRebateCondition(double moneyRebate) {
        this.moneyRebate = moneyRebate;
        priority = CashConstants.CashConditionPriority.REBATE;
    }

    @Override
    public double getResult(double money) {
        return money * moneyRebate;
    }
}
