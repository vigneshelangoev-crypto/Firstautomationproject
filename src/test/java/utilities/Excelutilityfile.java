package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilityfile {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle style;

    public static int getRowCount (String xfile, String xsheet) throws IOException
    {
    fi =new FileInputStream(xfile);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    int rowcount= ws.getLastRowNum();
    wb.close();
    fi.close();
    return rowcount;
    }
    public static int getCellCount (String xfile, String xsheet, int rownum) throws IOException
    {
    fi =new FileInputStream(xfile);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    row= ws.getRow(rownum);
    int cellcount= row.getLastCellNum();
    wb.close();
    fi.close();
    return cellcount;
    }
    public static String getCellData (String xfile, String xsheet, int rownum, int colnum) throws IOException
    {
    fi =new FileInputStream(xfile);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    row= ws.getRow(rownum);
    cell= row.getCell(colnum);
    String celldata;
    try
    {
        //data=cell.toString();
        DataFormatter formatter= new DataFormatter();
        celldata = formatter.formatCellValue(cell);
    }
    catch(Exception e)
    {
        celldata="";
    }
    wb.close();
    fi.close();
    return celldata;
    }
    public static void setCellData(String xfile, String xsheet, int rownum, int colnum, String cellvalue) throws IOException
    {
    fi =new FileInputStream(xfile);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    row= ws.getRow(rownum);
    cell= row.createCell(colnum);
    cell.setCellValue(cellvalue);
    fo = new FileOutputStream(xfile);
    wb.write(fo);
    wb.close();
    fi.close();
    fo.close();
    }
    public static void fillGreenColor(String xfile, String xsheet, int rownum, int colnum) throws IOException
    {
        fi = new FileInputStream(xfile);
        wb =new XSSFWorkbook(fi);
        ws =wb.getSheet(xsheet);
        row= ws.getRow(rownum);
        cell= row.getCell(colnum);
        style= wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(xfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();

    }
    public static void fillRedColor(String xfile, String xsheet, int rownum, int colnum) throws IOException
    {
        fi = new FileInputStream(xfile);
        wb =new XSSFWorkbook(fi);
        ws =wb.getSheet(xsheet);
        row= ws.getRow(rownum);
        cell= row.getCell(colnum);
        style= wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        fo = new FileOutputStream(xfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();

    }
}
