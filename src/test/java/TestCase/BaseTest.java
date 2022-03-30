package TestCase;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import Common.constant;
import PageObject.LoginPage;

public class BaseTest {
    public WebDriver openBrowser(String browser) {
        switch (browser) {

            case "openFireFox":
                System.setProperty("webdriver.gecko.driver", constant.pathDriverFirefox);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                constant.driver = new FirefoxDriver(firefoxOptions);
                constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                break;

            case "openChrome":
                System.setProperty("webdriver.chrome.driver", constant.pathDriverChrome);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                constant.driver = new ChromeDriver(chromeOptions);
                constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                break;

            default:
                System.out.println("Không tìm thấy browser");
                break;
        }
        return constant.driver;
    }

    public LoginPage openLoginPage() {
        constant.driver.navigate().to(constant.url);
        return new LoginPage();
    }
}
