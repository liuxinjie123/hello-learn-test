package com.springboot.hello.test.cashier.factory.condition;

import com.springboot.hello.test.cashier.constant.CashConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CashSubtractCondition extends CashCondition implements Serializable {
    private double moneyCondition = 0;
    private double moneyReturn = 0;

    public CashSubtractCondition() {
        priority = CashConstants.CashConditionPriority.SUBTRACT;
    }

    public CashSubtractCondition(double money, double moneyCondition, double moneyReturn) {
        super.money = money;
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
        priority = CashConstants.CashConditionPriority.SUBTRACT;
        type = CashConstants.CashSuperType.SUBTRACT;
    }

    @Override
    public double getResult(double money) {
        if (money > moneyCondition) {
            money = Math.floor(money -  (int) (money / moneyCondition) * moneyReturn);
        }
        return money;
    }
}
