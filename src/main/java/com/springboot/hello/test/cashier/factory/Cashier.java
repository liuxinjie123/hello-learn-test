package com.springboot.hello.test.cashier.factory;

import com.springboot.hello.test.cashier.factory.cashsuper.CashNormal;
import com.springboot.hello.test.cashier.factory.condition.CashCondition;
import com.springboot.hello.test.cashier.factory.condition.CashRebateCondition;
import com.springboot.hello.test.cashier.factory.condition.CashSubtractCondition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cashier {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.test(1000);
    }

    private void test(double money) {
        List<CashCondition> conditionList = new ArrayList<>();

        // 满减优化
        CashCondition condition = new CashSubtractCondition();
        conditionList.add(condition);

        // 打折
        condition = new CashRebateCondition();
        conditionList.add(condition);

        // 按优先级排序
        conditionList.sort(Comparator.comparingInt(CashCondition::getPriority));

        for (CashCondition condition1 : conditionList) {
            money = createCashAccept(condition1).acceptCash(money);
        }

        System.out.println(" result money: " + money);
    }

    public static CashNormal createCashAccept(CashCondition condition) {
        return new CashNormal(condition);
    }
}
