package pl.markowski.konrad.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pl.markowski.konrad.base.BasePage;

import java.io.IOException;
import java.util.logging.Logger;

public class GamePage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(GamePage.class.getName());

    By timerWhite = By.xpath("//div[contains(@class, 'timer--white timer--center')]");
    By cookiesDisableBtn = By.xpath("//button[contains(text(), 'Not really, no')]");
    By closeModalBoxBtn = By.xpath("//span[@class='modal__close-copyright']");
    By modalBoxWindow = By.xpath("//div[@class='modal__box']");



    public GamePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public WebElement getTimer(){
        return driver.findElement(timerWhite);
    }

    public WebElement getCookiesDisableBtn(){
        return driver.findElement(cookiesDisableBtn);
    }

    public WebElement getCloseModalBoxButton(){
        return driver.findElement(closeModalBoxBtn);
    }

    public WebElement getModalBoxWindow(){
        return driver.findElement(modalBoxWindow);
    }

    public Boolean isOpen(){
        LOGGER.info("Check if game page is open");
       return waitForElementVisible(timerWhite,10);

    }

    public String getTimerValue(){
        LOGGER.info("get timer value");
        waitForElementVisible(timerWhite,10);
        return getTimer().getText();
    }


    public void disableCookies(){
        LOGGER.info("click cookies btn ");
        waitForElementClickable(cookiesDisableBtn,5);
        getCookiesDisableBtn().click();
    }

    public boolean isCookieBtnPresent(){
        try {
            waitForElementInvisible(cookiesDisableBtn,5);
            getCookiesDisableBtn();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeModalBox(){
        LOGGER.info("Closing modal box window");
        waitForElementVisible(closeModalBoxBtn,65);
        try {
            getCloseModalBoxButton().click();
        } catch (NoSuchElementException e){

        }
    }

    public boolean isModalBoxWindowPresent(){
        LOGGER.info("check if modal box is open after 60 second");
        waitForElementVisible(modalBoxWindow,65);
        try{
            getModalBoxWindow();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isModalBoxClosed(){
        LOGGER.info("check if modal box is closed");
        waitForElementInvisible(modalBoxWindow,10);
        try {
            getModalBoxWindow();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
