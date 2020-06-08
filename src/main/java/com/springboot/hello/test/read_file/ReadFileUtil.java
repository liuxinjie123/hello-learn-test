package com.springboot.hello.test.read_file;

import org.apache.commons.io.FileUtils;

import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.NumberFormat;

/**
 * 读取文件内容工具类
 * 支持   Word，Word2007，
 *       Excel，Excel2007，
 *       PPT，PPT2007
 *       PDF, TXT
 */
public class ReadFileUtil {
    private static Logger logger = LoggerFactory.getLogger(ReadFileUtil.class);

    private static final String PDF_F = ".pdf";
    private static final String DOC_F = ".doc";
    private static final String DOCX_F = ".docx";
    private static final String TXT_F = ".txt";
    private static final String XLS_F = ".xls";
    private static final String XLSX_F = ".xlsx";
    private static final String PPT_F = ".ppt";
    private static final String PPTX_F = ".pptx";

    public static void main(String[] args) {
        String s = "";
// s = getFileContent("E:/信用宝.txt");
        s = getFileContent("E:/LoanAgreement.pdf");
// s = getFileContent("E:/技术中心 1月打卡指纹记录 (2).xls");
// s = getFileContent("E:/技术中心 1月打卡指纹记录 (2).xlsx");
// s = getFileContent("E:/好屋中国财务报销制度好屋发字[2018]第31号.doc");
// s = getFileContent("E:/好屋中国财务报销制度好屋发字[2018]第31号.docx");
// s = getFileContent("E:/1好屋印象0609.ppt");
// s = getFileContent("E:/1好屋印象0609.pptx");
        System.out.println(s);
    }

    /**
     * 获取文件中文本内容
     * @param fileUrl       文件url
     */
    public static String getFileContent(String fileUrl) {
        int place = fileUrl.lastIndexOf(".");
        if (place == -1) {
            return "";
        }
        String fileType = fileUrl.substring(place);
        try {
            if (PDF_F.equalsIgnoreCase(fileType)) {
                return getTextFromPDF(fileUrl);
            } else if (DOC_F.equalsIgnoreCase(fileType)) {
                return readWORD(fileUrl);
            } else if (DOCX_F.equalsIgnoreCase(fileType)) {
                return readWORD2007(fileUrl);
            } else if (TXT_F.equalsIgnoreCase(fileType)) {
                return readTXT(fileUrl);
            } else if (PPT_F.equalsIgnoreCase(fileType)) {
                return readPPT(fileUrl);
            } else if (PPTX_F.equalsIgnoreCase(fileType)) {
                return readPPT2007(fileUrl);
            } else if (XLS_F.equalsIgnoreCase(fileType)) {
                return readEXCEL(fileUrl);
            } else if (XLSX_F.equalsIgnoreCase(fileType)) {
                return readEXCEL2007(fileUrl);
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * PDF
     */
    public static String getTextFromPDF(String pdfFilePath) {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            RandomAccessRead randomAccessRead = new RandomAccessBufferedFileInputStream(pdfFilePath);
            PDFParser parser = new PDFParser(randomAccessRead);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } catch (FileNotFoundException e) {
            logger.error(" file not found exception", e);
        } catch (IOException e) {
            logger.error(" io exception", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error(" io exception", e);
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    logger.error(" io exception", e);
                }
            }
        }
        return result;
    }


    /**
     * Word - doc
     */
    public static String readWORD(String file) {
        String returnStr = "";
        try {
            WordExtractor wordExtractor = new WordExtractor(new FileInputStream(new File(file)));
            returnStr = wordExtractor.getText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    /**
     * Word - docx
     * @param file
     * @return
     * @throws Exception
     */
    public static String readWORD2007(String file) throws Exception {
        return new XWPFWordExtractor(POIXMLDocument.openPackage(file)).getText();
    }

    /**
     * TXT
     */
    public static String readTXT(String file) throws IOException {
        String encoding = get_charset(new File(file));
        if (encoding.equalsIgnoreCase("GBK")) {
            return FileUtils.readFileToString(new File(file), "gbk");
        } else {
            return FileUtils.readFileToString(new File(file), "utf8");
        }
    }

    /**
     * PPT
     */
    public static String readPPT(String file) throws IOException {
        StringBuilder sb = new StringBuilder();
        SlideShow ppt = new SlideShow(new HSLFSlideShow(file));
        Slide[] slides = ppt.getSlides();
        //提取文本信息
        for (Slide each : slides) {
            TextRun[] textRuns = each.getTextRuns();
            for (int i=0 ;i< textRuns.length; i++ ) {
                for (int j = 0; j < textRuns.length; j++) {
                    sb.append(textRuns[j].getText());
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * PPTX
     */
    public static String readPPT2007(String file) throws IOException, XmlException, OpenXML4JException {
        return new XSLFPowerPointExtractor(POIXMLDocument.openPackage(file)).getText();
    }

    /**
     * Excel - xls
     */
    public static String readEXCEL(String file) throws IOException {
        StringBuilder content = new StringBuilder();
        // 创建对Excel工作簿文件的引用
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (null != workbook.getSheetAt(numSheets)) {
                // 获得一个sheet
                HSSFSheet aSheet = workbook.getSheetAt(numSheets);
                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        // 获得一行
                        HSSFRow aRow = aSheet.getRow(rowNumOfSheet);
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                // 获得列值
                                HSSFCell aCell = aRow.getCell(cellNumOfRow);
                                if (convertCell(aCell).length() > 0) {
                                    content.append(convertCell(aCell));
                                }
                            }
                            content.append("\n");
                        }
                    }
                }
            }
        }
        return content.toString();
    }


    /**
     * Excel - xlsx
     */
    public static String readEXCEL2007(String file) throws IOException {
        StringBuilder content = new StringBuilder();
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (null != workbook.getSheetAt(numSheets)) {
                // 获得一个sheet
                XSSFSheet aSheet = workbook.getSheetAt(numSheets);
                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        // 获得一个行
                        XSSFRow aRow = aSheet.getRow(rowNumOfSheet);
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                // 获得列值
                                XSSFCell aCell = aRow.getCell(cellNumOfRow);
                                if (convertCell(aCell).length() > 0) {
                                    content.append(convertCell(aCell));
                                }
                            }
                            content.append("\n");
                        }
                    }
                }
            }
        }
        return content.toString();
    }

    private static String convertCell(Cell cell) {
        NumberFormat formater = NumberFormat.getInstance();
        formater.setGroupingUsed(false);
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = formater.format(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = Boolean.valueOf(cell.getBooleanCellValue()).toString();
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                cellValue = "";
        }
        return cellValue.trim();
    }

    private static String get_charset(File file) throws IOException {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        BufferedInputStream bis = null;
        try {
            boolean checked = false;
            bis = new BufferedInputStream(new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
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
            bis.reset();
            if (!checked) {
                int loc = 0;

                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0) {
                        break;
                    }
                    if (0x80 <= read && read <= 0xBF) {
                        // 单独出现BF以下的，也算是GBK
                        break;
                    }
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            // 双字节 (0xC0 - 0xDF)
                            // (0x80 // - 0xBF),也可能在GB编码内
                            continue;
                        } else {
                            break;
                        }
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
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
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
        }
        return charset;
    }

}
