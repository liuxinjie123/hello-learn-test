package com.springboot.hello.test.cashsuper.cashsuper;

import com.springboot.hello.test.cashsuper.CashConstants;
import com.springboot.hello.test.cashsuper.condition.CashCondition;
import com.springboot.hello.test.cashsuper.condition.CashRebateCondition;
import com.springboot.hello.test.cashsuper.condition.CashSubtractCondition;

public class Cashier {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.test(1000);
    }

    private void test(double money) {
        // 满减优化
        CashCondition condition = new CashSubtractCondition(money, 300, 100);
        money = CashFactory.createCashAccept(CashConstants.CashSuperType.SUBTRACT, condition).acceptCash(money);


        // 打折
        condition = new CashRebateCondition(money,0.8);
        money = CashFactory.createCashAccept(CashConstants.CashSuperType.REBATE, condition).acceptCash(money);

        System.out.println(" result money: " + money);
    }
}
