package pl.markowski.konrad;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.markowski.konrad.base.BaseTest;
import pl.markowski.konrad.page_objects.*;
import pl.markowski.konrad.utils.Listener;

import java.io.IOException;


@Listeners(Listener.class)
public class UserInterfaceTests extends BaseTest {
    public UserInterfaceTests() throws IOException {
        super();
    }

    @Test
    public void helpForm() throws IOException {
        Homepage homepage = new Homepage();
        Assert.assertTrue(homepage.isOpen(), "Homepage is not open");

        homepage.clickHereBtn();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game Page is not open");

        HelpForm helpForm = new HelpForm();
        helpForm.clickHelpBtn();

        Assert.assertTrue(helpForm.isHelpResponseVisible(), "Help response is not visible");
    }

    @Test
    public void timer() throws IOException {
        Homepage homepage = new Homepage();
        Assert.assertTrue(homepage.isOpen(), "Homepage is not open");

        homepage.clickHereBtn();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game Page is not open");
        Assert.assertEquals(gamePage.getTimerValue(), "00:00:00");

    }

    @Test
    public void validPassword() throws IOException {
        Homepage homepage = new Homepage();
        Assert.assertTrue(homepage.isOpen(), "Homepage is not open");

        homepage.clickHereBtn();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game Page is not open");

        FormCardOne formCardOne = new FormCardOne();
        formCardOne.fillCardOneFormWithValidData();

        FormCardTwo formCardTwo = new FormCardTwo();
        Assert.assertTrue(formCardTwo.isOpen(), "Second card is not open");


    }


    @Test(dataProvider = "cardOneFormData")
    public void invalidPassword(String emailPrefix, String password, String domain, int topDomainId) throws IOException {
        Homepage homepage = new Homepage();
        Assert.assertTrue(homepage.isOpen(), "Homepage is not open");

        homepage.clickHereBtn();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isOpen(), "Game Page is not open");

        FormCardOne cardOne = new FormCardOne();
        cardOne.fillCardOneFormWithInvalidData(emailPrefix, password, domain, topDomainId);

        FormCardTwo formCardTwo = new FormCardTwo();
        Assert.assertTrue(formCardTwo.isOpen(), "Second card is not open");
    }


    @Test
    public void cookieTest() throws IOException {
        Homepage homepage = new Homepage();
        homepage.clickHereBtn();

        GamePage gamePage = new GamePage();
        gamePage.disableCookies();
        Assert.assertFalse(gamePage.isCookieBtnPresent(), "Cokies are not close");
    }

    @Test
    public void closeModalBox() throws IOException {
        Homepage homepage = new Homepage();
        homepage.clickHereBtn();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isModalBoxWindowPresent(), "Modal box is not open");
        gamePage.closeModalBox();

        Assert.assertFalse(gamePage.isModalBoxClosed(), "Modal box is open");

    }


    @Test
    public void hideHelpForm() throws IOException, InterruptedException {
        Homepage homepage = new Homepage();
        homepage.clickHereBtn();

        HelpForm helpForm = new HelpForm();
        Assert.assertTrue(helpForm.isVisible(), "Help form is not visible");
        Thread.sleep(3000);

        helpForm.clickSendToBottomButton();
        Thread.sleep(3000);
        Assert.assertTrue(helpForm.isHelpFormHidden(), "Help form is not hidden");
    }

}
