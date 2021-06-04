package com.springboot.hello.test.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给一个文本文件A，请将文件A中的内容按以下规则处理后输出至文件AReverse：
 *
 * a.如果A中有换行（不在引号内），要把该行的字符按行内次序反转，
 * b.如果A中有多个换行（不在引号内），要把多个行的内容按行间次序反转，
 * c.如果A中有内容（包括换行）在引号内，那么该部分视为整体不需转换，
 * 如果A中有内容不符合上述条件，该部分不需转换直接输出。
 *
 */
public class ReadText {
    public static void main(String[] args) {
        ReadText read = new ReadText();
        read.read();
    }

    public void read() {
        /** 换行的文本 */
        List<Detail> changeLineList = new ArrayList<>();
        /** 引号内的文本 */
        List<Detail> quotation1List = new ArrayList<>();
        List<Detail> quotation2List = new ArrayList<>();
        /** 其他文本 */
        List<Detail> otherList = new ArrayList<>();

        String encoding = "UTF-8";
        File file = new File("src/main/resources/A.txt");

        readText(file, encoding, changeLineList, quotation1List, quotation2List, otherList);

        sortChangeLineList(changeLineList);

        List<Detail> allList = new ArrayList<>();
        allList.addAll(changeLineList);
        allList.addAll(quotation1List);
        allList.addAll(quotation2List);
        allList.addAll(otherList);

        sortList(allList);

        printAll(allList, file, encoding);
    }

    private void printAll(List<Detail> allList, File file, String encoding) {
        for (Detail detail : allList) {
            String content = getContent(detail, file, encoding);
            System.out.println(content);
        }
    }

    private String getContent(Detail detail, File file, String encoding) {
        String res = "";
        try {

            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            int lineTxt = 0;
            int count = 0;
            while ((lineTxt = bufferedReader.read()) != -1) {
                if (count >= detail.start && count <= detail.end) {
                    res += ((char)lineTxt);
                }
                if (count > detail.end) {
                    return res;
                }
            }
        } catch (Exception e) {

        }
        return res;
    }

    private void sortList(List<Detail> allList) {
        //allList = allList.stream().sorted(Detail::getSequence).collect(Collectors.toList());
    }

    private void sortChangeLineList(List<Detail> changeLineList) {
        if (1 <= changeLineList.size()) {
            return;
        }
        int[] sequenceArr = changeLineList.stream().mapToInt(obj -> obj.sequence).sorted().toArray();
        int length = sequenceArr.length;
        for (int i=0; i<changeLineList.size(); i++) {
            changeLineList.get(i).sequence = sequenceArr[length-1-i];
        }
    }

    public void readText(File file, String encoding, List<Detail> changeLineList, List<Detail> quotation1List,
                                List<Detail> quotation2List, List<Detail> otherList) {
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                int lineTxt = 0;
                int totalNum = 0;
                int startPlace = 1;
                int lineStartPlace = 1;
                int curType = 1;
                int sequence = 1;
                boolean isLine = true;
                while ((lineTxt = bufferedReader.read()) != -1) {
                    totalNum++;
                    if (curType == 1 && ((char)lineTxt) == '\n' && isLine) {
                        Detail changeLine = new Detail();
                        changeLine.type = 1;
                        changeLine.start = lineStartPlace;
                        changeLine.end = totalNum;
                        changeLine.sequence = sequence++;
                        changeLineList.add(changeLine);
                        startPlace = totalNum + 1;
                        lineStartPlace = startPlace;
                    } else if (curType == 2 && ((char)lineTxt) == '\"') {
                        curType = 1;
                        Detail qDetail1 = new Detail();
                        qDetail1.type = 2;
                        qDetail1.start = startPlace;
                        qDetail1.end = totalNum;
                        qDetail1.sequence = sequence++;
                        quotation1List.add(qDetail1);
                        startPlace = totalNum + 1;
                        lineStartPlace = startPlace;
                    } else if (curType == 2 && ((char)lineTxt) == '\n') {
                        isLine = false;
                    } else if (curType == 3 && ((char)lineTxt) == '“') {
                        curType = 1;
                        Detail qDetail2 = new Detail();
                        qDetail2.type = 3;
                        qDetail2.start = startPlace;
                        qDetail2.end = totalNum;
                        qDetail2.sequence = sequence++;
                        quotation2List.add(qDetail2);
                        startPlace = totalNum + 1;
                        lineStartPlace = startPlace;
                    } else if (curType == 3 && ((char)lineTxt) == '\n') {
                        isLine = false;
                    } else if (curType != 2 && ((char)lineTxt) == '\"') {
                        curType = 2;
                        Detail otherDetail = new Detail();
                        otherDetail.type = 4;
                        otherDetail.start = startPlace;
                        otherDetail.end = totalNum;
                        otherDetail.sequence = sequence++;
                        otherList.add(otherDetail);
                        startPlace = totalNum + 1;
                    } else if (curType != 3 && ((char)lineTxt) == '”') {
                        curType = 3;
                        Detail otherDetail = new Detail();
                        otherDetail.type = 4;
                        otherDetail.start = startPlace;
                        otherDetail.end = totalNum;
                        otherDetail.sequence = sequence++;
                        otherList.add(otherDetail);
                        startPlace = totalNum + 1;
                    } else if (curType == 1 && ((char)lineTxt) == '\n' && !isLine) {
                        curType = 1;
                        Detail otherDetail = new Detail();
                        otherDetail.type = 4;
                        otherDetail.start = startPlace;
                        otherDetail.end = totalNum;
                        otherDetail.sequence = sequence++;
                        otherList.add(otherDetail);
                        startPlace = totalNum + 1;
                    }
//                    System.out.print(((char)lineTxt));
                }
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件出错");
        }
    }

    /**
     * 文本参数信息
     */
    class Detail {
        /**
         * 1 - 换行
         * 2 - 英文引号
         * 3 - 汉文引号
         * 4 - 其他
         */
        private int type;

        /**
         * 开始位置
         */
        private int start;

        /**
         * 结束位置
         */
        private int end;

        /**
         * 顺序
         */
        private int sequence;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }
    }
}

