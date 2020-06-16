package com.springboot.hello.test.util;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 读取文件内容工具类
 * 支持   Word，Word2007，
 *       Excel，Excel2007，
 *       PPT，PPT2007
 *       PDF, TXT
 */
public class ReadFileUtil {
    private static final String TXT_F = "txt";

    public static void main(String[] args) throws IOException {
//        String filePath = "http://172.16.10.109/uploads/2020_6/1592198366877.txt";
        String filePath = "http://sit2.haowu.com/tupian/uploads/2020_6/1592204582510.txt";
        String s = "";
        s = readTXT(filePath);
        System.out.println(JSON.toJSONString(s));
    }

    /**
     * TXT
     */
    public static String readTXT(String filePath) throws IOException {
        String encoding = get_charset_new(filePath);
        String content = "";
        int b;
        try {
            URL url = new URL(filePath);
            InputStream is = url.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            while((b=is.read()) != -1) {
                content = content + (char)b;
            }
            is.close();
            bis.close();
            content = new String(content.getBytes("ISO-8859-1"), encoding);
//            System.out.println (content);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return content;
    }

    private static String get_charset_new(String filePath) throws IOException {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        URL url = new URL(filePath);
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            boolean checked = false;
            bufferedInputStream.mark(0);
            int read = bufferedInputStream.read(first3Bytes, 0, 3);
            if (read == -1) {
                return charset;
            }
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bufferedInputStream.reset();
            if (!checked) {
                int loc = 0;

                while ((read = bufferedInputStream.read()) != -1) {
                    loc++;
                    if (read >= 0xF0) {
                        break;
                    }
                    if (0x80 <= read && read <= 0xBF) {
                        // 单独出现BF以下的，也算是GBK
                        break;
                    }
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bufferedInputStream.read();
                        if (0x80 <= read && read <= 0xBF) {
                            // 双字节 (0xC0 - 0xDF)
                            // (0x80 // - 0xBF),也可能在GB编码内
                            continue;
                        } else {
                            break;
                        }
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bufferedInputStream.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bufferedInputStream.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
        return charset;
    }

}
