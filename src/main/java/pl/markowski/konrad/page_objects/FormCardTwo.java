package pl.markowski.konrad.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.markowski.konrad.base.BasePage;

import java.io.IOException;
import java.util.logging.Logger;

public class FormCardTwo extends BasePage {
    private final Logger LOGGER = Logger.getLogger(FormCardTwo.class.getName());

    By avatarTitle = By.xpath("//h2[contains(text(),'This is me')]");
    By uploadBtn = By.xpath("//a[contains(text(),'upload')]");
    By avatarImage = By.xpath("//div[@class='avatar-and-interests__avatar-image']");


    public FormCardTwo() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public WebElement getAvatarTitle(){
        return driver.findElement(avatarTitle);
    }

    public WebElement getUploadBtn(){
        return driver.findElement(uploadBtn);
    }
    public WebElement getAvatarImage(){
        return driver.findElement(avatarImage);
    }


    public boolean isOpen(){
        LOGGER.info("check if Card Two is open");
       return waitForElementVisible(avatarTitle,10);
    }



}
