package com.springboot.hello.test.cashier.strategy;

import com.springboot.hello.test.cashier.constant.CashConstants;

public class Cashier {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.test(1000);
    }

    private void test(double money) {
        // 满减优化
        CashContext context = CashStrategy.createCashAccept(CashConstants.CashSuperType.SUBTRACT);
        money = context.getResult(money);

        // 打折
        context = CashStrategy.createCashAccept(CashConstants.CashSuperType.REBATE);
        money = context.getResult(money);

        System.out.println(" result money: " + money);
    }
}
