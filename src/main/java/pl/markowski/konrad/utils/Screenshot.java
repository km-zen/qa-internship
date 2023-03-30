package pl.markowski.konrad.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public void takeScreenshot(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File desFile = new File(System.getProperty("user.dir") +
                "\\src\\main\\resources\\screenshots\\" + timeStamp() + ".png");

        FileUtils.copyFile(srcFile,desFile);
    }

    public String timeStamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
