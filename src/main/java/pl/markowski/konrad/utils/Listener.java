package pl.markowski.konrad.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import pl.markowski.konrad.base.BasePage;

import java.io.IOException;

public class Listener extends BasePage implements ITestListener {
    public Listener() throws IOException {
        super();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            this.takeScreenshot(result.getName());
            System.out.println("take screenshot");
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }
}
