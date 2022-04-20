package common;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constant {
    public static JavascriptExecutor jse;
    public static Robot robot;
    public static Select select;
    public static Screen screen;
    public static Action action;
    public static Actions actions;
    public static Date date;
    public static Random random;
    public static WebDriverWait wait;
    public static Alert alert;
    public static WebDriver driver;
    public static WebElement element;
    public static List<WebElement> list;
    public static Object object;
    public static String url = "https://qa.sadlierconnect.com/@qa-auto";
    public static String pathFileImport = new File("file-import/").getAbsolutePath();
    public static String pathDownloadFile = new File("file-download").getAbsolutePath();
    public static String pathDataDictionaryFile = "data/data-dictionary/DataDictionary.xlsx";
    public static String passcodeAccount = "R3stricted";
    public static String usernameAdminAccount = "dtran";
    public static String passwordAdminAccount = "t1ger1";
    public static String usernameTeacherAccount = "tch2";
    public static String passwordTeacherAccount = "123456";
}
