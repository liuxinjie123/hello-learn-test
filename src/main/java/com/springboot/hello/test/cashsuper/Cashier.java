package com.springboot.hello.test.cashsuper;

public class Cashier {
    public static void main(String[] args) {
        CashReturnCondition condition = new CashReturnCondition(300, 100);
        CashSuper cashSuper = CashFactory.createCashAccept(CashConstants.CashSuperType.RETURN, condition);
        double result = cashSuper.acceptCash(1000);
        System.out.println(" result money: " + result);
    }
}
