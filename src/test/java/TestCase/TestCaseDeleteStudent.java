package testcase;

import common.CommonFunction;
import common.helpers.DataHelper;
import common.Constant;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ManageStudentPage;

public class TestCaseDeleteStudent extends BaseTest {
    //Declare object and variable
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ManageStudentPage manageStudentPageObject;
    private String studentID = DataHelper.getRandomPID();
    private String firstName = DataHelper.getRandomFirstName();
    private String middleName = DataHelper.getRandomMiddleName();
    private String lastName = DataHelper.getRandomLastName();
    private String userName = DataHelper.getRandomUserName();
    private String password = DataHelper.getRandomPassword();
    private String gradeLevel = "Grade 5";
    private String studentAdded = studentID + " " + lastName + " " + firstName + " " + gradeLevel + " " + "Enabled";
    private String messageDeleteWarning = "You are about to delete "+firstName+" "+ lastName+"'s student account from the system.\n" +
            "\n" +
            "If you proceed with deleting this account all information will be permanently deleted and you will not be able to restore the information later.\n" +
            "\n" +
            "This includes the student account, their assignments, and results for completed assignments.\n" +
            "\n" +
            "If you do not want to delete the account select the Cancel button or select Delete Student to delete the account.";

    private String messageDeleteStudentSuccess = "The user account for " + firstName + " " + lastName + " has been deleted.";

    @Test(description = "User can delete student success with role admin", priority = 1, groups = {"admin"})
    private void deleteStudentSuccessWithRoleAdmin() throws InterruptedException, FindFailed {
        //Filter student created
        manageStudentPageObject.filterLastName(lastName);
        //Click delete student
        manageStudentPageObject.clickDeleteStudentRecord(studentAdded);
        manageStudentPageObject.getMessageDeleteWarning();
        //Verify content warning message
        System.out.println(manageStudentPageObject.getMessageDeleteWarning());
        //Click Delete in warning popup
        manageStudentPageObject.clickDeleteInWarningPopup();
        //Verify message delete success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageDeleteStudentSuccess);
        //Filter student deleted
        manageStudentPageObject.filterLastName(lastName);
        //Verify not found student deleted in table
        Assert.assertFalse(manageStudentPageObject.isStudentRecordFound(studentAdded));
    }

    @Test(description = "User can delete student success with role teacher", priority = 1, groups = {"teacher"})
    private void deleteStudentSuccessWithRoleTeacher() throws InterruptedException, FindFailed {
        //Filter student created
        manageStudentPageObject.filterLastName(lastName);
        //Click delete student
        manageStudentPageObject.clickDeleteStudentRecord(studentAdded);
        manageStudentPageObject.getMessageDeleteWarning();
        //Verify content warning message
        Assert.assertEquals(manageStudentPageObject.getMessageDeleteWarning(), messageDeleteWarning);
        //Click Delete in warning popup
        manageStudentPageObject.clickDeleteInWarningPopup();
        //Verify message delete success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageDeleteStudentSuccess);
        //Filter student deleted
        manageStudentPageObject.filterLastName(lastName);
        //Verify not found student deleted in table
        Assert.assertFalse(manageStudentPageObject.isStudentRecordFound(studentAdded));
    }

    @BeforeMethod(description = "Precondition: Exist a student record", groups = {"teacher"})
    private void createStudentWithRoleTeacher() throws Exception {
        //Login success
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleTeacher(studentID, firstName, lastName, middleName, userName, password, gradeLevel);
    }

    @BeforeMethod(description = "Precondition: Exist a student record", groups = {"admin"})
    //Precondition: Exist a student record
    private void createStudentWithRoleAdmin() throws Exception {
        //Login success
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameAdminAccount, Constant.passwordAdminAccount);
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleAdmin(studentID, firstName, lastName, middleName, userName, password, gradeLevel);
    }

}
