package com.springboot.hello.test.cashier.strategy;

import com.springboot.hello.test.cashier.constant.CashConstants;
import com.springboot.hello.test.cashier.strategy.cashsuper.CashNormal;
import com.springboot.hello.test.cashier.strategy.cashsuper.CashRebate;
import com.springboot.hello.test.cashier.strategy.cashsuper.CashSubtract;

public class CashStrategy {
    public static CashContext createCashAccept(int type) {
        CashContext cc = null;
        switch (type) {
            case CashConstants.CashSuperType.NORMAL:
                cc = new CashContext(new CashNormal());
                break;
            case CashConstants.CashSuperType.REBATE:
                cc = new CashContext(new CashRebate());
                break;
            case CashConstants.CashSuperType.SUBTRACT:
                cc = new CashContext(new CashSubtract());
                break;
            default:
                break;
        }
        return cc;
    }
}
