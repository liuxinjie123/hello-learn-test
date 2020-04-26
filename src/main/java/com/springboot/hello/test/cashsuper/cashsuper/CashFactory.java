package com.springboot.hello.test.cashsuper;

import com.springboot.hello.test.cashsuper.condition.CashCondition;
import com.springboot.hello.test.cashsuper.condition.CashSubtractCondition;

import java.util.List;

public class CashFactory {
    public static CashSuper createCashAccept(int type, CashCondition condition) {
        CashSuper cs = null;
        switch (type) {
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
