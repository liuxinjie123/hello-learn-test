package com.springboot.hello.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        String url = "https://beta-microsite-cg.myscrm.cn/api/index.php?r=oauth2/token&org_code=yjlkhadmin_cg&reg_from=99";
        if (url.contains("&org_code=") || url.contains("&req_from=")) {
            System.out.println(" contains");
        } else {
            System.out.println(" not");
        }
    }
}
