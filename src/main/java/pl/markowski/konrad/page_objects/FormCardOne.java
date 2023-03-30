package pl.markowski.konrad.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pl.markowski.konrad.base.BasePage;
import pl.markowski.konrad.utils.RandomUtils;

import java.io.IOException;
import java.util.List;

public class FormCardOne extends BasePage {

    By chosePasswordLocator = By.xpath("//input[@placeholder='Choose Password']");
    By emailPrefixLocator = By.xpath("//input[@placeholder='Your email']");
    By emailDomain = By.xpath("//input[@placeholder='Domain']");
    By emailTopDomainList = By.xpath("//div[@class='dropdown__list']//*");
    By termsAndConditionsCheckbox = By.cssSelector(".checkbox__box");
    By nextBtn = By.xpath("//a[@class='button--secondary']");
    By dropdownButton = By.xpath("//span[contains(@class, 'icon-chevron-down')]");

    public FormCardOne() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public WebElement getChosePasswordLocator(){
        return driver.findElement(chosePasswordLocator);
    }

    public WebElement getEmailPrefixLocator(){
        return driver.findElement(emailPrefixLocator);
    }

    public  WebElement getEmailDomain(){
        return driver.findElement(emailDomain);
    }

    public WebElement getTermsAndConditionsCheckbox(){
        return driver.findElement(termsAndConditionsCheckbox);
    }

    public WebElement getNextBtn(){
        return driver.findElement(nextBtn);
    }

    public WebElement getDropdownButton(){
        return driver.findElement(dropdownButton);
    }

    public List<WebElement> getTopDomainList(){
        return driver.findElements(emailTopDomainList);
    }


    public void fillCardOneFormWithValidData() {
        String emailPrefix = RandomUtils.getRandomEmailPrefix();
        String password = RandomUtils.getValidPassword(emailPrefix);

        waitForElementVisible(emailPrefixLocator,10);
        getEmailPrefixLocator().clear();
        getEmailPrefixLocator().sendKeys(emailPrefix);

        waitForElementVisible(chosePasswordLocator,10);
        getChosePasswordLocator().clear();
        getChosePasswordLocator().sendKeys(password);

        waitForElementVisible(emailDomain,10);
        getEmailDomain().clear();
        getEmailDomain().sendKeys("gmail");

        waitForElementClickable(termsAndConditionsCheckbox,10);
        getTermsAndConditionsCheckbox().click();

        waitForElementClickable(dropdownButton,10);
        getDropdownButton().click();

        waitForElementClickable(emailTopDomainList,10);
        getTopDomainList().get(2).click();

        waitForElementClickable(nextBtn,10);
        getNextBtn().click();

    }

    public void fillCardOneFormWithInvalidData(String emailPrefix, String password, String domain, int topDomainId)  {

        waitForElementVisible(emailPrefixLocator,10);
        getEmailPrefixLocator().clear();
        getEmailPrefixLocator().sendKeys(emailPrefix);

        waitForElementVisible(chosePasswordLocator,10);
        getChosePasswordLocator().clear();
        getChosePasswordLocator().sendKeys(password);

        waitForElementVisible(emailDomain,10);
        getEmailDomain().clear();
        getEmailDomain().sendKeys(domain);

        waitForElementClickable(termsAndConditionsCheckbox,10);
        getTermsAndConditionsCheckbox().click();

        waitForElementClickable(dropdownButton,10);
        getDropdownButton().click();

        waitForElementClickable(emailTopDomainList,10);
        getTopDomainList().get(topDomainId).click();

        waitForElementClickable(nextBtn,10);
        getNextBtn().click();

    }

}
