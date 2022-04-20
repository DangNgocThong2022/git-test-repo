package common;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import common.helpers.ExcelHelper;

public class AutomationAction extends CommonFunction {
    public void waitImplicitly(int seconds) {
        Constant.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitForControlVisible(By control, int seconds) {
        Constant.wait = new WebDriverWait(Constant.driver, Duration.ofSeconds(seconds));
        Constant.wait.until(ExpectedConditions.visibilityOfElementLocated(control));
    }

    public void waitForControlInvisible(By control, int seconds) {
        Constant.wait = new WebDriverWait(Constant.driver, Duration.ofSeconds(seconds));
        Constant.wait.until(ExpectedConditions.invisibilityOfElementLocated(control));
    }

    public void waitForControlToBeClickAble(By control, int seconds) {
        Constant.wait = new WebDriverWait(Constant.driver, Duration.ofSeconds(seconds));
        Constant.wait.until(ExpectedConditions.elementToBeClickable(control));
    }

    public void hoverMouse(By control) {
        Actions actions = new Actions(Constant.driver);
        actions.moveToElement(Constant.driver.findElement(control)).perform();
    }

    public void waitForScreen(String filePath, int seconds) throws FindFailed {
        Constant.screen = new Screen();
        Constant.screen.wait(filePath, seconds);
    }

    public void clickScreen(String filePath) throws FindFailed {
        Constant.screen = new Screen();
        Constant.screen.click(filePath);
    }

    public void hoverMouseScreen(String filePath) throws FindFailed {
        Constant.screen = new Screen();
        Constant.screen.hover(filePath);
    }

    public static void sendKeysJavascript(By element, String keysToSend) {
        WebElement el = Constant.driver.findElement(element);
        JavascriptExecutor ex = (JavascriptExecutor) Constant.driver;
        ex.executeScript("arguments[0].value='" + keysToSend + "';", el);
    }

    public static void clickJavascript(By element) {
        WebElement el = Constant.driver.findElement(element);
        JavascriptExecutor ex = (JavascriptExecutor) Constant.driver;
        ex.executeScript("arguments[0].click();", el);
    }

    public static String getTextJavascript(By element) {
        String getText = (String) ((JavascriptExecutor) Constant.driver).executeScript("return arguments[0].value;", Constant.driver.findElement(element));
        return getText;
    }


    public static void backspaceTextbox(By element) {
        String str = getTextJavascript(element);
        int number = str.length();
        for (int i = 0; i <= number; i++) {
            Constant.driver.findElement(element).sendKeys(Keys.BACK_SPACE);
        }

    }

    public static void enterTextbox(By element) {
        Constant.driver.findElement(element).sendKeys(Keys.ENTER);

    }

    public static void clickByActions(By element) {
        Constant.actions.moveToElement(Constant.driver.findElement(element)).build().perform();

    }


    public static void scrollPage(int position) {
        Constant.jse = (JavascriptExecutor) Constant.driver;
        Constant.jse.executeScript("window.scrollBy(0," + position + ")");
    }

    public static void scrollToBottom() {
        Constant.jse = (JavascriptExecutor) Constant.driver;
        Constant.jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop() {
        Constant.jse = (JavascriptExecutor) Constant.driver;
        Constant.jse.executeScript("window.scrollTo(0, 0)");
    }

    public void swichIframeIndex(int iframe) {
        Constant.driver.switchTo().frame(iframe);
    }

    public void switchDefaultFrame() {
        Constant.driver.switchTo().defaultContent();
    }

    public void swichIframeName(String iframe) {
        Constant.driver.switchTo().frame(iframe);
    }

    public void click(By control) {
        Constant.driver.findElement(control).click();
    }

    public void type(By control, String text) {
        Constant.driver.findElement(control).clear();
        Constant.driver.findElement(control).sendKeys(text);
    }

    public Boolean isElementSelected(By control) {
        Constant.element = Constant.driver.findElement(control);
        if (Constant.element.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isElementUnselected(By control) {
        Constant.element = Constant.driver.findElement(control);
        if (Constant.element.isSelected()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkString(By control, String text) {
        return Constant.driver.findElement(control).getText().equals(text);
    }

    public Boolean checkValue(By control, int value) {
        return Constant.driver.findElement(control).getAttribute("value").equals(value);
    }

    public String getTextControl(By control) {
        return Constant.driver.findElement(control).getText();
    }

    public String getValueControl(By control) {
        return Constant.driver.findElement(control).getAttribute("value");
    }

    public Boolean isControlExist(By control) {
        try {
            Constant.driver.findElement(control);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isControlDisplay(By control) {
        if (Constant.driver.findElement(control).isDisplayed() == true) {
            return true;
        } else return false;
    }

    public Boolean isPopupDisplay() {
        try {
            Constant.driver.switchTo().alert();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void comfirmPopup() {
        Alert alert = Constant.driver.switchTo().alert();
        alert.accept();
    }

    public void cancelPopup() {
        Constant.driver.switchTo().alert().dismiss();
    }

    public WebElement findelement(By control) {
        return Constant.driver.findElement(control);
    }

    public By getElementBy(String by, String element, String pathJsonFile) {
        By elementTemporary = null;
        switch (by) {
            case "id":
                elementTemporary = By.id(getStringFromJson(pathJsonFile, element, by));
                break;
            case "xpath":
                elementTemporary = By.xpath(getStringFromJson(pathJsonFile, element, by));
                break;
            case "class":
                elementTemporary = By.className(getStringFromJson(pathJsonFile, element, by));
                break;
            case "name":
                elementTemporary = By.name(getStringFromJson(pathJsonFile, element, by));
                break;
            case "tagName":
                elementTemporary = By.tagName(getStringFromJson(pathJsonFile, element, by));
                break;
            case "css":
                elementTemporary = By.cssSelector(getStringFromJson(pathJsonFile, element, by));
                break;
            case "linkText":
                elementTemporary = By.linkText(getStringFromJson(pathJsonFile, element, by));
                break;
            case "partialLinkText":
                elementTemporary = By.partialLinkText(getStringFromJson(pathJsonFile, element, by));
                break;
            default:
                System.out.println("Không tìm thấy Element");
                break;
        }
        return elementTemporary;
    }

    public void selectDropdownByText(By control, String text) {
        Constant.select = new Select(Constant.driver.findElement(control));
        Constant.select.selectByVisibleText(text);
    }

    public void inputTextToUpload(String path) throws AWTException {
        StringSelection pathLocation = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pathLocation, null);
        Constant.robot = new Robot();
        Constant.robot.keyPress(KeyEvent.VK_CONTROL);
        Constant.robot.keyPress(KeyEvent.VK_V);
        Constant.robot.keyRelease(KeyEvent.VK_V);
        Constant.robot.keyRelease(KeyEvent.VK_CONTROL);
        Constant.robot.keyPress(KeyEvent.VK_ENTER);
        Constant.robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void uploadFileByRobot(String path, String fileName) throws AWTException, InterruptedException {
        inputTextToUpload(path);
        Thread.sleep(1000);
        inputTextToUpload(fileName);
    }

    public By getElementInDictionary(String filePath, String sheetName, String objectName) throws Exception {
        By elementTemporary = null;
        String by = ExcelHelper.getLocatorTypeFromExcel(filePath, sheetName, objectName);
        switch (by) {
            case "id":
                elementTemporary = By.id(ExcelHelper.getLocatorValueFromExcel(filePath, sheetName, objectName));
                break;
            case "xpath":
                elementTemporary = By.xpath(ExcelHelper.getLocatorValueFromExcel(filePath, sheetName, objectName));
                break;
        }
        return elementTemporary;
    }

}
