package PageObject;

import Common.constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage extends GeneralPage{
    private By usernameTxb = By.xpath("//input[@id='username']");
    private By passwordTxb = By.xpath("//input[@id='password']");
    private By loginBtn = By.xpath("//button/span[text()='Log In']");


    public HomePage loginSuccess(String username, String password) throws InterruptedException {
        waitForControlVisible(usernameTxb, 10);
        type(usernameTxb, username);
        type(passwordTxb, password);
        waitForControlToBeClickAble(loginBtn,10);
        hoverMouse(loginBtn);
        click(loginBtn);
        return new HomePage();
    }
}
