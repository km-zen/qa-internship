package pl.markowski.konrad.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pl.markowski.konrad.base.BasePage;

import java.io.IOException;
import java.util.logging.Logger;

public class Homepage extends BasePage{

    private static final Logger LOGGER = Logger.getLogger(Homepage.class.getName());

    By startBtn = By.xpath("//button[@class='start__button']");
    By hereBtn = By.xpath("//a[@class='start__link']");

    public Homepage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public WebElement getStartBtn(){
        return driver.findElement(startBtn);
    }

    public WebElement getHereBtn(){
        return driver.findElement(hereBtn);
    }

    public Boolean isOpen(){
       return waitForElementVisible(startBtn,10);
    }

    public void clickHereBtn() {
        LOGGER.info("Click here button");
        waitForElementClickable(startBtn,10);
        getHereBtn().click();
    }


}
