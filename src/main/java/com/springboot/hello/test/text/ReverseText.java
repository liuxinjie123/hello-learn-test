package com.springboot.hello.test.text;

import io.micrometer.core.instrument.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给一个文本文件 A，请将文件A中的内容按以下规则处理后输出至文件 AReverse：
 *
 * a.如果A中有换行（不在引号内），要把该行的字符按行内次序反转，
 * b.如果A中有多个换行（不在引号内），要把多个行的内容按行间次序反转，
 * c.如果A中有内容（包括换行）在引号内，那么该部分视为整体不需转换，
 * 如果A中有内容不符合上述条件，该部分不需转换直接输出。
 *
 */
public class ReverseText {
    public static void main(String[] args) {
        Stack<StrObj> tarStack = new Stack<>();
        List<StrObj> tarList = new ArrayList<>();
        List<Sequence> seqList = new ArrayList<>();

        String oldFilePath = "src/main/resources/A.txt";
        String newFilePath = "src/main/resources/AReverse.txt";
        readTxt(oldFilePath, tarStack, tarList, seqList);
        File newFile = new File(newFilePath);
        if (newFile.exists()) {
            newFile.delete();
        }
        writeTxt(newFilePath, tarStack, tarList, seqList);
    }

    /**
     * 传入txt路径读取txt文件
     */
    public static void readTxt(String filePath, Stack<StrObj> tarStack, List<StrObj> tarList, List<Sequence> seqList) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String text = null;
                int count = 0;
                int stackCount = 0;
                int listCount = 0;
                boolean inQuotation = false;
                while ((text = bufferedReader.readLine()) != null) {
                    if (inQuotation) {
                        if (getStringIndexCount(text, "\"") % 2 == 1) {
                            StrObj obj = new StrObj();
                            encapuStrObj(obj, text, 2);
                            tarList.add(obj);
                            seqList.add(new Sequence(count, 2, listCount, inQuotation));
                            listCount++;
                            inQuotation = false;
                        } else {
                            StrObj obj = new StrObj();
                            obj.content = text;
                            tarList.add(obj);
                            seqList.add(new Sequence(count, 2, listCount, inQuotation));
                            listCount++;
                            inQuotation = true;
                        }
                    } else {
                        if (getStringIndexCount(text, "\"") % 2 == 1) {
                            StrObj obj = new StrObj();
                            obj.content = text;
                            tarList.add(obj);
                            seqList.add(new Sequence(count, 2, listCount, false));
                            listCount++;
                            inQuotation = true;
                        } else {
                            StrObj obj = new StrObj();
                            encapuStrObj(obj, text, 1);
                            tarStack.add(obj);
                            seqList.add(new Sequence(count, 1, stackCount, false));
                            stackCount++;
                            inQuotation = false;
                        }
                        count++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void encapuStrObj(StrObj obj, String text, int type) {
        String[] arr = text.split("\"");
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        List<Detail> detailList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            Detail detail = new Detail();
            if (type == 1) {
                if (i % 2 == 1) {
                    list.add("\"" + arr[i] + "\"");
                    detail.type = 2;
                } else {
                    detail.type = 1;
                    int length = 0;
                    for (char ch : arr[i].toCharArray()) {
                        stack.add(ch);
                        length++;
                    }
                    detail.length = length;
                }
            } else {
                if (i % 2 == 0) {
                    if (i != 0) {
                        list.add("\"" + arr[i] + "\"");
                    } else {
                        list.add(arr[i] + "\"");
                    }
                    detail.type = 2;
                } else {
                    detail.type = 1;
                    int length = 0;
                    for (char ch : arr[i].toCharArray()) {
                        stack.add(ch);
                        length++;
                    }
                    detail.length = length;
                }
            }
            detailList.add(detail);
        }
        obj.stack = stack;
        obj.list = list;
        obj.detailList = detailList;
    }

    /**
     * 写入文件
     */
    private static void writeTxt(String newFilePath, Stack<StrObj> tarStack, List<StrObj> tarList, List<Sequence> seqList) {
        int listC=0;
        for (int i=0; i<seqList.size(); i++) {
            Sequence seq = seqList.get(i);
            String content = "";
            if (seq.type == 1) {
                StrObj obj = tarStack.pop();
                if (StringUtils.isNotBlank(obj.content)) {
                    content = obj.content;
                } else if (null == obj.detailList) {
                    content = "";
                } else {
                    int listCount = 0;
                    for (Detail detail : obj.detailList) {
                        if (detail.type == 1) {
                            StringBuilder strBuilder = new StringBuilder();
                            int count = 0;
                            Stack<Character> sonStack = obj.stack;
                            while (!sonStack.isEmpty() && count < detail.length) {
                                strBuilder.append(sonStack.pop());
                                count++;
                            }
                            content += strBuilder.toString();
                        } else if (detail.type == 2) {
                            content += obj.list.get(listCount);
                            listCount++;
                        }
                    }
                }
                write(newFilePath, content);
                write(newFilePath, "\n");
            } else if (seq.type == 2) {
                StrObj obj = tarList.get(listC);
                listC++;
                if (StringUtils.isNotBlank(obj.content)) {
                    content = obj.content;
                } else if (null == obj.detailList) {
                    content = "";
                } else {
                    int listCount = 0;
                    for (Detail detail : obj.detailList) {
                        if (detail.type == 1) {
                            StringBuilder strBuilder = new StringBuilder();
                            int count = 0;
                            Stack<Character> sonStack = obj.stack;
                            while (!sonStack.isEmpty() && count <= detail.length) {
                                strBuilder.append(sonStack.pop());
                            }
                            content += strBuilder.toString();
                        } else if (detail.type == 2) {
                            content += obj.list.get(listCount);
                            listCount++;
                        }
                    }
                }
                write(newFilePath, content);
                write(newFilePath, "\n");
            }
        }
    }

//    private static Strign dealStr(String content, int type) {
//
//    }

    private static String dealStackStr(String content, int type) {
        if (content.indexOf("\"") == -1) {
            return content;
        }
        StringBuilder res = new StringBuilder();
        String[] str = content.split("\"");
        for (int i=0; i<str.length; i++) {
            if (type == 1) {
                if (i%2 == 1) {
                    String temp = reverseStr(str[i]);
                    res.append(temp);
                } else {
                    res.append(str[i]);
                }
            } else {
                if (i%2 == 0) {
                    String temp = reverseStr(str[i]);
                    res.append(temp);
                } else {
                    res.append(str[i]);
                }
            }
            if (i != str.length-1) {
                res.append("\"");
            }
        }
        return res.toString();
    }

    private static String reverseStr(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.add(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static int getStringIndexCount(String str, String key) {
        if(str == null || key == null || "".equals(str.trim()) || "".equals(key.trim())){
            return 0;
        }
        int count = 0;
        int index = 0;
        while((index=str.indexOf(key, index))!=-1){
            index = index+key.length();
            count++;
        }
        return count;
    }

    public static void write(String filePath, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));// true,进行追加写。
            out.write(conent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class StrObj {
        String content;
        Stack<Character> stack;
        List<String> list;
        List<Detail> detailList;
    }

    static class Detail {
        /**
         * 0 - string
         * 1 - stack
         * 2 - list
         */
        public int type;

        public int length;
    }

    static class Sequence {
        /**
         * 顺序，
         * 1，2，3
         */
        public int sequence;

        /**
         * 类型
         * 1-stack
         * 2-list
         */
        public int type;

        /**
         * 是栈 或 队列中的 第几个元素
         */
        public int num;

        /**
         * 是否在引号内
         */
        public boolean inQuotation;

        public Sequence() {}

        public Sequence(int sequence, int type, int num, boolean inQuotation) {
            this.sequence = sequence;
            this.type = type;
            this.num = num;
            this.inQuotation = inQuotation;
        }
    }
}
