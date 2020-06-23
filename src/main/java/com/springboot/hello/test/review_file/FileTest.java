package com.springboot.hello.test.review_file;

import java.io.*;
import java.net.*;


class FileTest {
    public static void main(String s[]) {
        int b;
        try {
            String str="";
            URL url = new URL("http://172.16.10.109/uploads/2020_6/1592198366877.txt");
            InputStream is = url.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            while((b=is.read()) != -1) {
                str = str+(char)b;
            }
            is.close();
            bis.close();
            str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
            System.out.println (str);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
