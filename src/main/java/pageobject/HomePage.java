package pageobject;

import common.Constant;
import org.openqa.selenium.By;

import java.io.File;

public class HomePage extends GeneralPage {
    //Declare element for page
    private By userAvatarIc = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "userAvatarIc");
    private By myAccountLnk = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "myAccountLnk");
    private By logoutIc = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "logoutIc");
    private By manageStudentLnk = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "manageStudentLnk");
    private By settingIc = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "settingIc");
    private By loadingBar = getElementInDictionary(Constant.pathDataDictionaryFile, "HomePage", "loadingBar");

    public HomePage() throws Exception {
    }

    //Declare method for page
    public LoginPage logout() throws Exception {
        waitForControlInvisible(loadingBar, 5);
        hoverMouse(userAvatarIc);
        click(userAvatarIc);
        waitForControlToBeClickAble(logoutIc, 10);
        click(logoutIc);
        return new LoginPage();
    }

    public MyAccountPage goToMyAccountPage() throws Exception {
        waitForControlInvisible(loadingBar, 5);
        hoverMouse(userAvatarIc);
        click(userAvatarIc);
        Thread.sleep(2000);
        waitForControlVisible(myAccountLnk, 10);
        hoverMouse(myAccountLnk);
        click(myAccountLnk);
        return new MyAccountPage();
    }

    public ManageStudentPage goToManageStudentPage() throws Exception {
        waitForControlInvisible(loadingBar, 5);
        hoverMouse(settingIc);
        click(settingIc);
        waitForControlVisible(manageStudentLnk, 10);
        hoverMouse(manageStudentLnk);
        click(manageStudentLnk);
        return new ManageStudentPage();
    }
}
