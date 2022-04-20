package testcase;

import org.testng.Assert;
import pageobject.HomePage;
import pageobject.ManageStudentPage;
import org.sikuli.script.FindFailed;
import org.testng.annotations.*;
import common.CommonFunction;
import common.helpers.DataHelper;
import common.Constant;
import pageobject.LoginPage;

public class TestCaseAddStudent extends BaseTest {
    //Declare object and variable
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ManageStudentPage manageStudentPageObject;
    private String studentID = DataHelper.getRandomPID();
    private String firstName = DataHelper.getRandomFirstName();
    private String middleName = DataHelper.getRandomMiddleName();
    private String lastName = DataHelper.getRandomLastName();
    private String userName = DataHelper.getRandomUserName();
    //private String userNameExpected = CommonFunction.getFirstCharacterFromString(firstName) + CommonFunction.getFirstCharacterFromString(middleName) + lastName + userName;
    private String password = DataHelper.getRandomPassword();
    private String gradeLevel = "Grade 5";
    private String messageAddStudentSuccess = "Student account for " + firstName + " " + lastName + " was successfully added to the system.";
    private String studentAdded = studentID + " " + lastName + " " + firstName + " " + gradeLevel + " " + "Enabled";

    @Test(description = "User can create student success with role teacher", groups = {"teacher"}, priority = 2)
    private void addStudentSuccessWithRoleTeacher() throws Exception {
        //Go to manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student record
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleTeacher(studentID, firstName, lastName, middleName, userName, password, gradeLevel);
        //Verify message create student success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageAddStudentSuccess);
        //Filter student record created
        manageStudentPageObject.filterLastName(lastName);
        //Edit student created
        manageStudentPageObject.editStudentRecord(studentAdded);
        //Verify all information student are correctly
        Assert.assertEquals(manageStudentPageObject.getTextStudentID(), studentID);
        Assert.assertEquals(manageStudentPageObject.getTextFirstName(), firstName);
        Assert.assertEquals(manageStudentPageObject.getTextMiddleName(), middleName);
        Assert.assertEquals(manageStudentPageObject.getTextLastName(), lastName);
        Assert.assertEquals(manageStudentPageObject.getTextUserName(), userName);
        Assert.assertEquals(manageStudentPageObject.getTextPassword(), password);
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), gradeLevel);
    }

    @Test(description = "User can create student success with role admin", groups = {"admin"}, priority = 1)
    private void addStudentSuccessWithRoleAdmin() throws Exception {
        //Go to manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student record
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleAdmin(studentID, firstName, lastName, middleName, userName, password, gradeLevel);
        //Verify message create student success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageAddStudentSuccess);
        //Filter student record created
        manageStudentPageObject.filterLastName(lastName);
        //Edit student created
        manageStudentPageObject.editStudentRecord(studentAdded);
        //Verify all information student are correctly
        Assert.assertEquals(manageStudentPageObject.getTextStudentID(), studentID);
        Assert.assertEquals(manageStudentPageObject.getTextFirstName(), firstName);
        Assert.assertEquals(manageStudentPageObject.getTextMiddleName(), middleName);
        Assert.assertEquals(manageStudentPageObject.getTextLastName(), lastName);
        Assert.assertEquals(manageStudentPageObject.getTextUserName(), userName);
        Assert.assertEquals(manageStudentPageObject.getTextPassword(), password);
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), gradeLevel);
    }

    @BeforeMethod(description = "Precondition: Login success with account teacher", groups = {"teacher"})
    //Precondition: Login success with account teacher
    private void loginSuccessWithRoleTeacher() throws Exception {
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);
    }

    @BeforeMethod(description = "Precondition: Login success with account admin", groups = {"admin"})
    //Precondition: Login success with account admin
    private void loginSuccessWithRoleAdmin() throws Exception {
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameAdminAccount, Constant.passwordAdminAccount);
    }

    @AfterMethod(description = "Post Condition : Delete student created in table", groups = {"admin","teacher"})
    //Post Condition : Delete student created in table
    private void deleteStudent() throws FindFailed, InterruptedException {
        //Close form Edit Student
        manageStudentPageObject.closeForm();
        //Filter student created
        manageStudentPageObject.filterLastName(lastName);
        //Click delete student
        manageStudentPageObject.clickDeleteStudentRecord(studentAdded);
        manageStudentPageObject.clickDeleteInWarningPopup();
    }


}
