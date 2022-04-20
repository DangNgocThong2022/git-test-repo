package pageobject;

import common.Constant;
import common.helpers.DataHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;
import common.helpers.ExcelHelper;

import java.io.IOException;

public class LoginPage extends GeneralPage{

    //Declare element for page
    private By passcodeTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"LoginPage","passcodeTxb");
    private By usernameTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"LoginPage","usernameTxb");
    private By passwordTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"LoginPage","passwordTxb");
    private By loginBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"LoginPage","loginBtn");
    private By loginTitle = getElementInDictionary(Constant.pathDataDictionaryFile,"LoginPage","loginTitle");
    public LoginPage() throws Exception {
    }


    //Declare method for page
    public HomePage loginSuccess(String passcode,String username, String password) throws Exception {
        if(isControlExist(passcodeTxb)==true){
            type(passcodeTxb,passcode);
        }
        waitForControlVisible(usernameTxb, 10);
        type(usernameTxb, username);
        type(passwordTxb, password);
        waitForControlToBeClickAble(loginBtn,10);
        hoverMouse(loginBtn);
        click(loginBtn);
        return new HomePage();
    }
    public Boolean isLoginBtnExist() {
        waitForControlVisible(loginBtn, 10);
        return isControlExist(loginBtn);
    }
    public Boolean isUsernameTxbExist() {
        waitForControlVisible(usernameTxb, 10);
        return isControlExist(usernameTxb);
    }
    public Boolean isPasswordTxbExist() {
        waitForControlVisible(passwordTxb, 10);
        return isControlExist(passwordTxb);
    }
    public Boolean isTitleLoginExist() {
        waitForControlVisible(loginTitle, 10);
        return isControlExist(loginTitle);
    }
}
