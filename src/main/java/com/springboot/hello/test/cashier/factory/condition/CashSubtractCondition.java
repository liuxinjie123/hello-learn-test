package com.springboot.hello.test.cashier.factory.condition;

import com.springboot.hello.test.cashier.constant.CashConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CashSubtractCondition extends CashCondition implements Serializable {
    private double moneyCondition = 300;
    private double moneyReturn = 100;

    public CashSubtractCondition() {
        priority = CashConstants.CashConditionPriority.SUBTRACT;
    }

    @Override
    public double getResult(double money) {
        if (money > moneyCondition) {
            money = Math.floor(money -  (int) (money / moneyCondition) * moneyReturn);
        }
        return money;
    }
}
