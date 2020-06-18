package android.utils;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;

public class AndroidConfig implements WebDriverProvider {

    private final static String apkName = PropertiesReader.config().getProperty("apk.name");

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.APP, FileSystems.getDefault().getPath("src/main/resources/apk/" + apkName).normalize().toAbsolutePath().toString());
        try {
            return new AndroidDriver(new URL(PropertiesReader.config().getProperty("appium.server.url")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
