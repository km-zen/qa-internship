package pl.markowski.konrad.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pl.markowski.konrad.utils.RandomUtils;

import java.io.IOException;

public class BaseTest extends BasePage {
    public BaseTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driverInitialization();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] cardOneFormData() {
        Object[][] data = new Object[3][4];

        data[0][0] = RandomUtils.getRandomEmailPrefix();
        data[0][1] = RandomUtils.getInvalidPassword();
        data[0][2] = "gmail";
        data[0][3] = 1;

        data[1][0] = RandomUtils.getRandomEmailPrefix();
        data[1][1] = RandomUtils.getInvalidPassword();
        data[1][2] = "yahoo";
        data[1][3] = 2;

        data[2][0] = RandomUtils.getRandomEmailPrefix();
        data[2][1] = RandomUtils.getInvalidPassword();
        data[2][2] = "outlook";
        data[2][3] = 3;

        return data;
    }
}
