package testcase;

import org.sikuli.script.FindFailed;
import pageobject.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import common.Constant;
import pageobject.LoginPage;
import pageobject.MyAccountPage;

import java.io.File;

public class TestCaseLogin extends BaseTest {
    //Declare object and variable
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private MyAccountPage myAccountPageObject;

    @Test(description = "User can login success with role teacher",groups = {"teacher"},priority = 2)
    private void loginSuccessWithRoleTeacher() throws Exception {
        //Login success
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);
        //Go to My Account page
        myAccountPageObject = homePageObject.goToMyAccountPage();
        //Verify username is correctly
        Assert.assertEquals(myAccountPageObject.getUserName(), Constant.usernameTeacherAccount);
    }

    @Test(description = "User can login success with role admin",groups = {"admin"},priority = 1)
    private void loginSuccessWithRoleAdmin() throws Exception {
        //Login success
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameAdminAccount, Constant.passwordAdminAccount);
        //Go to My Account page
        myAccountPageObject = homePageObject.goToMyAccountPage();
        //Verify username is correctly
        Assert.assertEquals(myAccountPageObject.getUserName(), Constant.usernameAdminAccount);
    }

    @AfterMethod(description = "Post condition: Logout success",groups = {"admin","teacher"})
    private void logoutSuccess() throws Exception {
        //Logout
        loginPageObject = homePageObject.logout();
        //Verify logout success
        Assert.assertTrue(loginPageObject.isTitleLoginExist());
        Assert.assertTrue(loginPageObject.isLoginBtnExist());
        Assert.assertTrue(loginPageObject.isUsernameTxbExist());
        Assert.assertTrue(loginPageObject.isPasswordTxbExist());
    }
}
