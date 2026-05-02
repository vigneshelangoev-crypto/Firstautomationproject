package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="LoginData")
    public String [][] xslxData ()throws IOException 
    {
        String path=".\\testData\\logins.xlsx";

        excelUtility xlutil= new excelUtility(path);
        int totalrow= xlutil.getRowCount("Sheet1"); //5
        int totalcell= xlutil.getCellCount("Sheet1", 1); //2

        String logindata[][]=new String[totalrow][totalcell];
        for(int i=1;i<=totalrow;i++) 
        {
            for(int j=0;j<totalcell;j++)
            {
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
            }
        }
        return logindata;
    }
}
