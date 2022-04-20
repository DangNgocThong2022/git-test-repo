package testcase;
import common.Constant;
import common.helpers.BrowserHelper;
import utils.logs.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobject.LoginPage;

public class BaseTest {

    public LoginPage openLoginPage() throws Exception {
        BrowserHelper.navigateToUrl(Constant.url);
        return new LoginPage();
    }

    @BeforeTest(description = "Start chrome browser",groups = { "admin", "teacher" })
    public void setUp() {
        //Open chrome browser
        Log.info("Tests is starting!");
        Constant.driver = BrowserHelper.openBrowser(BrowserHelper.DriverType.CHROME);

    }

    @AfterTest(description = "Close chrome browser",groups = { "admin", "teacher" })
    public void tearDown() {
        //Exit browser
        Log.info("Tests are ending!");
        BrowserHelper.quitBrowser();
    }
}
