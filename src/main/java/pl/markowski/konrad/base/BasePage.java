package pl.markowski.konrad.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BasePage {

    protected static WebDriver driver;
    private static Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();

        FileInputStream data = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\main\\resources\\config.properties");
        prop.load(data);
    }


    public static void driverInitialization() {

        if(prop.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "\\src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(prop.getProperty("browser").equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                    "\\src\\main\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") +
                    "\\src\\main\\resources\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));
    }

    public void takeScreenshot(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File desFile = new File(System.getProperty("user.dir") +
                "\\src\\main\\resources\\screenshots\\" + timeStamp() + ".png");

        FileUtils.copyFile(srcFile,desFile);
    }

    public String timeStamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }




    public static boolean waitForElementVisible(By element, int timer){
        WebDriverWait wait = new WebDriverWait(driver,timer);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (TimeoutException e){
            return false;
        }

    }

    public static void waitForElementClickable(By element, int timer){
        WebDriverWait wait = new WebDriverWait(driver,timer);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitForElementInvisible(By element, int timer){
        WebDriverWait wait = new WebDriverWait(driver,timer);
       try{
           wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
           return true;
       } catch (TimeoutException e){
           return false;
       }

    }

}
