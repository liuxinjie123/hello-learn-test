package com.springboot.hello.test.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MoneyUnitConversion {
    public static void main(String[] args) {
        // 具体的金额（单位元）
        String value = "88000067898";
        BigDecimal bigDecimal = new BigDecimal(value);
        // 转换为万元（除以10000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);

        // 格式化完成之后得出结果
        String formatNum = formater.format(decimal);
        System.out.println(formatNum);

        String res1 = getNumberWan(String.valueOf(value));
        System.out.println(" res1= " + res1);
        String res2 = getNumberWanTwo(String.valueOf(value));
        System.out.println(" res2= " + res2);
    }

    /**元转万元且四舍五入取整*/
    public static String getNumberWan(String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        // 转换为万元（除以10000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);

        // 格式化完成之后得出结果
        String rs = formater.format(decimal);
        return rs;
    }

    /**元转万元且保留两位小数并四舍五入*/
    public static String getNumberWanTwo(String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        // 转换为万元（除以10000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0.00");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);

        // 格式化完成之后得出结果
        String rs = formater.format(decimal);
        return rs;
    }

}
