package pageobject;

import common.Constant;
import org.openqa.selenium.By;

public class MyAccountPage extends GeneralPage {
    //Declare element for page
    private By usernameTxb = getElementInDictionary(Constant.pathDataDictionaryFile, "MyAccountPage", "usernameTxb");

    public MyAccountPage() throws Exception {
    }


    //Declare method for page
    public String getUserName() {
        waitForControlVisible(usernameTxb, 10);
        return getTextJavascript(usernameTxb);
    }
}
