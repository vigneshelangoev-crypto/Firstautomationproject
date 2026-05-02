package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook wb;
    public XSSFSheet ws;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle style;

    String path;

    public excelUtility(String pa)
    {
        this.path=pa;
    
    }

    public int getRowCount (String xsheet) throws IOException
    {
    fi =new FileInputStream(path);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    int rowcount= ws.getLastRowNum();
    wb.close();
    fi.close();
    return rowcount;
    }
    public int getCellCount (String xsheet, int rownum) throws IOException
    {
    fi =new FileInputStream(path);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    row= ws.getRow(rownum);
    int cellcount= row.getLastCellNum();
    wb.close();
    fi.close();
    return cellcount;
    }
    public String getCellData (String xsheet, int rownum, int colnum) throws IOException
    {
    fi =new FileInputStream(path);
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
    public void setCellData(String xsheet, int rownum, int colnum, String cellvalue) throws IOException
    {
    fi =new FileInputStream(path);
    wb =new XSSFWorkbook(fi);
    ws =wb.getSheet(xsheet);
    row= ws.getRow(rownum);
    cell= row.createCell(colnum);
    cell.setCellValue(cellvalue);
    fo = new FileOutputStream(path);
    wb.write(fo);
    wb.close();
    fi.close();
    fo.close();
    }
    
    
}


