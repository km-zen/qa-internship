package pl.markowski.konrad.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pl.markowski.konrad.base.BasePage;

import java.io.IOException;
import java.util.logging.Logger;

public class HelpForm extends BasePage {
    private final Logger LOGGER = Logger.getLogger(HelpForm.class.getName());

    By helpFormFrame = By.xpath("//div[@class='help-form']");
    By helpBtn = By.xpath("//a[@class='help-form__help-button']");
    By helpResponse = By.xpath("//div[@class='help-form__response']");
    By hiddenHelpForm = By.xpath("//div[@class='help-form is-hidden']");
    By sendToBottomBtn = By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]");

    public HelpForm() throws IOException {
        PageFactory.initElements(driver,this);
    }


    public WebElement getHelpBtn(){
        return driver.findElement(helpBtn);
    }

    public WebElement getSendToBottomButton(){
        return driver.findElement(sendToBottomBtn);
    }

    public void clickHelpBtn(){
        LOGGER.info("click help button");
        waitForElementClickable(helpBtn,10);
        getHelpBtn().click();
    }

    public boolean isVisible(){
        LOGGER.info("helpForm is open");
       return waitForElementVisible(helpFormFrame,10);
    }

    public boolean isHelpResponseVisible(){
        LOGGER.info("check visibility of help response");
       return waitForElementVisible(helpResponse,10);
    }

    public void clickSendToBottomButton(){
        LOGGER.info("click send to bottom button");
        waitForElementClickable(sendToBottomBtn,10);
        getSendToBottomButton().click();
    }

    public boolean isHelpFormHidden(){
        LOGGER.info("check if help form is hidden after clicking Send To Bottom button");
        try {
            waitForElementVisible(hiddenHelpForm,10);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }



}
