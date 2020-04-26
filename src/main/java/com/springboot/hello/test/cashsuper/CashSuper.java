package com.springboot.hello.test.cashsuper;

/**
 * 现金收取超类的抽象方法，
 *
 * 收取现金，参数为原价，返回为当前价
 */
abstract class CashSuper {
    public abstract double acceptCash(double money);
}
