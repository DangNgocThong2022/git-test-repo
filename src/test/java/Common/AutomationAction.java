package Common;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAction extends CommonFunction{
    String result;

    public void waitForControlVisible(By control, int seconds) {
        constant.wait = new WebDriverWait(constant.driver, seconds);
        constant.wait.until(ExpectedConditions.visibilityOfElementLocated(control));
    }
    public void waitForControlToBeClickAble(By control, int seconds) {
        constant.wait = new WebDriverWait(constant.driver, seconds);
        constant.wait.until(ExpectedConditions.elementToBeClickable(control));
    }
    public void hoverMouse(By control)
    {
        Actions actions = new Actions(constant.driver);
        actions.moveToElement(constant.driver.findElement(control)).perform();
    }

    public static void sendKeysJavascript(By element, String keysToSend) {
        WebElement el = constant.driver.findElement(element);
        JavascriptExecutor ex = (JavascriptExecutor)constant.driver;
        ex.executeScript("arguments[0].value='"+ keysToSend +"';", el);
    }

    public void swichIframeIndex(int iframe) {
        constant.driver.switchTo().frame(iframe);
    }

    public void switchDefaultFrame() {
        constant.driver.switchTo().defaultContent();
    }

    public void swichIframeName(String iframe) {
        constant.driver.switchTo().frame(iframe);
    }

    public void navigateUrl(String url) {
        constant.driver.navigate().to(url);
    }

    public void click(By control) {
        constant.driver.findElement(control).click();
    }

    public void type(By control, String text) {
        constant.driver.findElement(control).clear();
        constant.driver.findElement(control).sendKeys(text);
    }

    public Boolean isElementSelected(By control) {
        constant.element = constant.driver.findElement(control);
        if (constant.element.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isElementUnselected(By control) {
        constant.element = constant.driver.findElement(control);
        if (constant.element.isSelected()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkString(By control, String text) {
        return constant.driver.findElement(control).getText().equals(text);
    }

    public Boolean checkValue(By control, int value) {
        return constant.driver.findElement(control).getAttribute("value").equals(value);
    }

    public String getTextControl(By control) {
        return constant.driver.findElement(control).getText();
    }

    public String getValueControl(By control) {
        return constant.driver.findElement(control).getAttribute("value");
    }

    public Boolean isControlExist(By control) {
        try {
            constant.driver.findElement(control);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isPopupDisplay() {
        try {
            constant.driver.switchTo().alert();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void comfirmPopup() {
        Alert alert = constant.driver.switchTo().alert();
        alert.accept();
    }

    public void cancelPopup() {
        constant.driver.switchTo().alert().dismiss();
    }

    public WebElement findelement(By control) {
        return constant.driver.findElement(control);
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


}
