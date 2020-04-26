package com.springboot.hello.test.cashsuper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class CashReturnCondition implements Serializable {
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
