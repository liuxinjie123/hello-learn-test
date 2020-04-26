package com.springboot.hello.test.cashsuper;

public class CashFactory {
    public static CashSuper createCashAccept(int type, CashReturnCondition condition) {
        CashSuper cs = null;
        switch (type) {
            case CashConstants.CashSuperType.NORMAL:
                cs = new CashNormal();
                break;
            case CashConstants.CashSuperType.REBATE:
                cs = new CashRebate(CashConstants.CashSuperRebate.EIGHT);
                break;
            case CashConstants.CashSuperType.RETURN:
                cs = new CashReturn(condition);
                break;
            default:
                break;
        }
        return cs;
    }
}
