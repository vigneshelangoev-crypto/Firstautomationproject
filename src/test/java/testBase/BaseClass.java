package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser","headless"})
    public void setup(String br,String hl) throws IOException
    {
        FileReader file = new FileReader(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        logger=LogManager.getLogger(this.getClass());
        boolean isHeadless= Boolean.parseBoolean(hl);

        if(p.getProperty("execution_evn").equalsIgnoreCase("remote"))
        {
        String huburl="http://13.51.220.79:4444";
        switch(br.toLowerCase())
        {
        case "chrome": 
        ChromeOptions cOptions=new ChromeOptions();
        if (isHeadless)
        {
            cOptions.addArguments("--headless=new");
        }
        cOptions.addArguments("--no-sandbox");
        cOptions.addArguments("--disable-dev-shm-usage");
        driver = new RemoteWebDriver(new URL(huburl), cOptions); break;
        case "edge": EdgeOptions eOptions= new EdgeOptions();
        if (isHeadless)
            {
                eOptions.addArguments("--headless=new");
            } 
        driver = new RemoteWebDriver(new URL(huburl), eOptions); break;
        case  "firefox": FirefoxOptions fOptions=new FirefoxOptions();
        if (isHeadless)
        {
            fOptions.addArguments("--headless");
        }
        driver = new RemoteWebDriver(new URL(huburl), fOptions); break;
        default : System.out.println("Invalid Browser"); return;
        }
        }

        if(p.getProperty("execution_evn").equalsIgnoreCase("local"))
        {
        switch(br.toLowerCase())
        {
        case "chrome": 
        ChromeOptions cOptions=new ChromeOptions();
        if (isHeadless)
        {
            cOptions.addArguments("--headless=new");
        }
        driver= new ChromeDriver(cOptions); break;
        case "edge": EdgeOptions eOptions= new EdgeOptions();
        if (isHeadless)
            {
                eOptions.addArguments("--headless=new");
            } 
        driver= new EdgeDriver(eOptions); break;
        case  "firefox": FirefoxOptions fOptions=new FirefoxOptions();
        if (isHeadless)
        {
            fOptions.addArguments("--headless=new");
        }
        driver= new FirefoxDriver(fOptions); break;
        default : System.out.println("Invalid Browser"); return;
        }
    }

        //driver= new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("URL1"));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920,1080));
    }
    @AfterClass(alwaysRun = true)
        public void tearDown()
        {
            driver.quit();
        }

        public String randomString()
        {
            String generatedString= RandomStringUtils.randomAlphabetic(5);
            return generatedString;
        }
        public String randomNumbers()
        {
            String generatedNumbString= RandomStringUtils.randomNumeric(10);
            return generatedNumbString;
        }
        public String randomAlphanumericString()
        {
            String generatedRandomAlnumString= (randomString()+"$"+randomNumbers());
            return generatedRandomAlnumString;
        }
        public String captureScreen(String tname) throws IOException {

        if(driver == null)
        {
            return "";
        }
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);

            String targetFilePath=System.getProperty("user.dir")+"/screenshots/"+tname+"_"+timestamp+".png";
            File targetFile=new File(targetFilePath);

            sourceFile.renameTo(targetFile);
            return targetFilePath;
            };
}
