package com.springboot.hello.test.cashier.factory;

import com.springboot.hello.test.cashier.constant.CashConstants;
import com.springboot.hello.test.cashier.factory.cashsuper.CashNormal;
import com.springboot.hello.test.cashier.factory.cashsuper.CashRebate;
import com.springboot.hello.test.cashier.factory.cashsuper.CashSubtract;
import com.springboot.hello.test.cashier.factory.cashsuper.CashSuper;
import com.springboot.hello.test.cashier.factory.condition.CashCondition;

public class CashFactory {
    public static CashSuper createCashAccept(CashCondition condition) {
        CashSuper cs = null;
        switch (condition.type) {
            case CashConstants.CashSuperType.NORMAL:
                cs = new CashNormal();
                break;
            case CashConstants.CashSuperType.REBATE:
                cs = new CashRebate(condition);
                break;
            case CashConstants.CashSuperType.SUBTRACT:
                cs = new CashSubtract(condition);
                break;
            default:
                break;
        }
        return cs;
    }
}
