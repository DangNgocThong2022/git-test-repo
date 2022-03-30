package TestCase;

import PageObject.HomePage;
import org.testng.annotations.*;

import Common.constant;
import PageObject.LoginPage;

public class TestCaseLogin extends BaseTest{
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    @Test(priority = 0)
    private void loginSuccess() throws InterruptedException {
        homePageObject = loginPageObject.loginSuccess(constant.usernameAdminAccount, constant.passwordAdminAccount);
        homePageObject.verifyLoginSuccess();
        loginPageObject=homePageObject.logout();
    }
    @BeforeTest
    private void setUp() {
        constant.driver = openBrowser(constant.browserChrome);
        loginPageObject=openLoginPage();

    }

    @AfterTest
    private void tearDown() {
        constant.driver.quit();
    }
}
