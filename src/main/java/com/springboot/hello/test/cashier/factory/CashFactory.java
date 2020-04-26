package com.springboot.hello.test.cashier.factory;

import com.springboot.hello.test.cashier.constant.CashConstants;
import com.springboot.hello.test.cashier.factory.cashsuper.CashNormal;
import com.springboot.hello.test.cashier.factory.condition.CashCondition;

public class CashFactory {
    public static CashNormal createCashAccept(CashCondition condition) {
        return new CashNormal(condition);
    }
}
