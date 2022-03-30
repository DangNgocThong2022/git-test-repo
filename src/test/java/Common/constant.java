package Common;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class constant {
    public static Action action;
    public Actions actions;
    public static Date date;
    public static Random random;
    public static WebDriverWait wait;
    public static Alert alert;
    public static WebDriver driver;
    public static WebElement element;
    public static List<WebElement> list;
    public static Object object;
    public static String url = "https://cqa2.sadlierconnect.com/@assignment";
    public static String driverff = "D:\\Driver\\geckodriver.exe";
    public static String driverchrome = "D:\\Driver\\chromedriver.exe";
    public static String pathDriverFirefox = new File("Driver/geckodriver.exe").getAbsolutePath();
    public static String pathDriverChrome = new File("Driver/chromedriver.exe").getAbsolutePath();
    public static String pathLoginPageJson = new File("src/PageObject/LoginPage.json").getAbsolutePath();
    public static String pathHomePageJson = new File("src/PageObject/HomePage.json").getAbsolutePath();
    public static String browserFireFox = "openFireFox";
    public static String browserChrome = "openChrome";
    public static String idBy = "id";
    public static String xpathBy = "xpath";
    public static String classBy = "class";
    public static String nameBy = "name";
    public static String tagNameBy = "tagName";
    public static String cssBy = "css";
    public static String linkTextBy = "linkText";
    public static String partialLinkTextBy = "partialLinkText";
    public static String passcodeAdminAccount = "R3stricted";
    public static String usernameAdminAccount = "admin";
    public static String passwordAdminAccount = "t1ger1";
}
