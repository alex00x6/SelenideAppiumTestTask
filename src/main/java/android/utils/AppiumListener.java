package android.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class AppiumListener implements ITestListener {
    AppiumDriverLocalService appium = null;

    @Override
    public void onTestStart(ITestResult result) {
        Selenide.open();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Selenide.closeWebDriver();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Selenide.closeWebDriver();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Selenide.closeWebDriver();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Selenide.closeWebDriver();

    }

    @Override
    public void onStart(ITestContext context) {
        if (!Boolean.parseBoolean(PropertiesReader.config().getProperty("manual.launch"))) {
            startAvd();
            appium = AppiumDriverLocalService.buildDefaultService();
            appium.start();
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false));
        Configuration.timeout = 30000;
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.savePageSource = false;
        Configuration.browser = AndroidConfig.class.getName();
    }

    @Override
    public void onFinish(ITestContext context) {
        if (!Boolean.parseBoolean(PropertiesReader.config().getProperty("manual.launch"))) {
            appium.stop();
            stopAvd();
        }
    }

    private void startAvd() {
        try {
            Runtime.getRuntime().exec(PropertiesReader.config().getProperty("avd.emulator.path") + " -avd " + PropertiesReader.config().getProperty("avd.device.name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Selenide.sleep(30000);
    }

    private void stopAvd() {
        try {
            Runtime.getRuntime().exec("adb emu kill");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
