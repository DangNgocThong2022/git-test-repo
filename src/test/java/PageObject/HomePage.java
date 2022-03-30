package PageObject;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends GeneralPage{
    private By userAvatarIc = By.xpath("//span[@class='user-avatar']");
    private By logoutIc = By.xpath("//span[@class='ant-dropdown-menu-title-content']/a[text()='Logout']");

    public void verifyLoginSuccess() {
        Assert.assertTrue(isControlExist(userAvatarIc));

    }
    public LoginPage logout() throws InterruptedException {
        Thread.sleep(8000);
        waitForControlToBeClickAble(userAvatarIc,10);
        click(userAvatarIc);
        waitForControlToBeClickAble(logoutIc, 10);
        click(logoutIc);
        return new LoginPage();
    }
}
