package com.springboot.hello.test.cashier.factory.condition;

import com.springboot.hello.test.cashier.constant.CashConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CashRebateCondition extends CashCondition {
    private double moneyRebate;

    public CashRebateCondition() {
        priority = CashConstants.CashConditionPriority.REBATE;
    }

    public CashRebateCondition(double money, double moneyRebate) {
        super.money = money;
        this.moneyRebate = moneyRebate;
        priority = CashConstants.CashConditionPriority.REBATE;
        type = CashConstants.CashSuperType.REBATE;
    }

    @Override
    public double getResult(double money) {
        return money * moneyRebate;
    }
}
