package com.springboot.hello.test.cashsuper.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class CashReturnCondition extends CashCondition implements Serializable {
    private double moneyCondition = 0;
    private double moneyReturn = 0;

    public CashReturnCondition() {}

    public CashReturnCondition(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    public double getResult(double money) {
        if (money > moneyCondition) {
            money = Math.floor(money -  (int) (money / moneyCondition) * moneyReturn);
        }
        return money;
    }
}
