package testcase;

import common.CommonFunction;
import common.Constant;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ManageStudentPage;

import java.io.File;


public class TestCaseDownloadStudentRosterImportTemplate extends BaseTest {
    //Declare object and variable
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ManageStudentPage manageStudentPageObject;
    private String fileImportStudent = "StudentImportTemplate.csv";
    private String pathDownloadFile=new File("file-download/StudentImportTemplate.csv").getAbsolutePath();

    @Test(description = "User can download student import template success with role teacher",groups = {"teacher"})
    private void downloadRosterStudentTemplateSuccessWithRoleTeacher() throws Exception {
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Click Import Roster
        manageStudentPageObject.clickImportRoster();
        //Click Download Student Roster Import Template
        manageStudentPageObject.clickDownloadStudentRosterImportTemplate();
        //Verify download file success
        Assert.assertTrue(CommonFunction.isFileExist(Constant.pathDownloadFile, fileImportStudent));
    }

    @Test(description = "User can download student import template success with role admin",groups = {"admin"})
    private void downloadRosterStudentTemplateSuccessWithRoleAdmin() throws Exception {
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Click Import Roster
        manageStudentPageObject.clickImportRoster();
        //Click Download Student Roster Import Template
        manageStudentPageObject.clickDownloadStudentRosterImportTemplate();
        //Verify download file success
        Assert.assertTrue(CommonFunction.isFileExist(Constant.pathDownloadFile, fileImportStudent));
    }

    @BeforeMethod(description = "Precondition: Delete StudentImportTemplate.csv in file-download folder",groups = {"admin"})
    //Precondition: Delete StudentImportTemplate.csv in file-download folder
    private void loginSuccessWithAccountAdmin() throws Exception {
        CommonFunction.deleteFileInFolder(pathDownloadFile);
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameAdminAccount, Constant.passwordAdminAccount);

    }
    @BeforeMethod(description = "Precondition: Delete StudentImportTemplate.csv in file-download folder",groups = {"teacher"})
    //Precondition: Delete StudentImportTemplate.csv in file-download folder
    private void loginSuccessWithAccountTeacher() throws Exception {
        CommonFunction.deleteFileInFolder(pathDownloadFile);
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);

    }


    @AfterMethod(description = "Precondition: Delete StudentImportTemplate.csv in file-download folder",groups = {"admin","teacher"})
    //Post Condition : Delete StudentImportTemplate.csv in file-download folder
    private void postcondition() {
        CommonFunction.deleteFileInFolder(pathDownloadFile);
    }

}
