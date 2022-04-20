package testcase;

import common.CommonFunction;
import common.helpers.DataHelper;
import common.Constant;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ManageStudentPage;

public class TestCaseEditStudent extends BaseTest {
    //Declare object and variable
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ManageStudentPage manageStudentPageObject;
    private String studentIDAdded = DataHelper.getRandomPID();
    private String firstNameAdded = DataHelper.getRandomFirstName();
    private String middleNameAdded = DataHelper.getRandomMiddleName();
    private String lastNameAdded = DataHelper.getRandomLastName();
    private String userNameAdded = DataHelper.getRandomUserName();
    private String passwordAdded = DataHelper.getRandomPassword();
    private String gradeLevelAdded = "Grade 5";
    private String studentIDEdited = DataHelper.getRandomPID();
    private String firstNameEdited = DataHelper.getRandomFirstName();
    private String middleNameEdited = DataHelper.getRandomMiddleName();
    private String lastNameEdited = DataHelper.getRandomLastName();
    private String userNameEdited = DataHelper.getRandomUserName();
    //private String userNameEditedExpected = CommonFunction.getFirstCharacterFromString(firstNameEdited) + CommonFunction.getFirstCharacterFromString(middleNameEdited) + lastNameEdited + userNameEdited;
    ;
    private String passwordEdited = DataHelper.getRandomPassword();
    private String gradeLevelEdited = "Pre-K";
    private String messageEditStudentSuccess = "Student account for " + firstNameEdited + " " + lastNameEdited + " was successfully updated to the system.";
    private String studentAdded = studentIDAdded + " " + lastNameAdded + " " + firstNameAdded + " " + gradeLevelAdded + " " + "Enabled";
    private String studentEdited = studentIDEdited + " " + lastNameEdited + " " + firstNameEdited + " " + gradeLevelEdited + " " + "Enabled";

    @Test(description = "User can edit student success with role teacher", groups = {"teacher"})
    private void editStudentSuccessWithRoleTeacher() throws InterruptedException, FindFailed {
        //Filter student record created
        manageStudentPageObject.filterLastName(lastNameAdded);
        //Edit student
        manageStudentPageObject.editStudentRecord(studentAdded);
        manageStudentPageObject.editInforStudentForRoleTeacher(studentIDEdited, firstNameEdited, lastNameEdited, middleNameEdited, userNameEdited, passwordEdited, gradeLevelEdited);
        //Verify edit student success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageEditStudentSuccess);
        //Filter student edited
        manageStudentPageObject.filterLastName(lastNameEdited);
        //Open student edited
        manageStudentPageObject.editStudentRecord(studentEdited);
        //Verify all information student edited are correctly
        Assert.assertEquals(manageStudentPageObject.getTextStudentID(), studentIDEdited);
        Assert.assertEquals(manageStudentPageObject.getTextFirstName(), firstNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextMiddleName(), middleNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextLastName(), lastNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextUserName(), userNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextPassword(), passwordEdited);
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), gradeLevelEdited);
    }

    @Test(description = "User can edit student success with role admin", groups = {"admin"})
    private void editStudentSuccessWithRoleAdmin() throws InterruptedException, FindFailed {
        //Filter student record created
        manageStudentPageObject.filterLastName(lastNameAdded);
        //Edit student
        manageStudentPageObject.editStudentRecord(studentAdded);
        manageStudentPageObject.editInforStudentForRoleAdmin(studentIDEdited, firstNameEdited, lastNameEdited, middleNameEdited, userNameEdited, passwordEdited, gradeLevelEdited);
        //Verify edit student success
        Assert.assertEquals(manageStudentPageObject.getTextMessageAlert(), messageEditStudentSuccess);
        //Filter student edited
        manageStudentPageObject.filterLastName(lastNameEdited);
        //Open student edited
        manageStudentPageObject.editStudentRecord(studentEdited);
        //Verify all information student edited are correctly
        Assert.assertEquals(manageStudentPageObject.getTextStudentID(), studentIDEdited);
        Assert.assertEquals(manageStudentPageObject.getTextFirstName(), firstNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextMiddleName(), middleNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextLastName(), lastNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextUserName(), userNameEdited);
        Assert.assertEquals(manageStudentPageObject.getTextPassword(), passwordEdited);
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), gradeLevelEdited);
    }

    @BeforeMethod(description = "Precondition: Exist a student record", groups = {"teacher"})
    //Precondition: Exist a student record
    private void loginWithTeacherAccount() throws Exception {
        //Login success with teacher account
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);
        //Go to manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student record
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleTeacher(studentIDAdded, firstNameAdded, lastNameAdded, middleNameAdded, userNameAdded, passwordAdded, gradeLevelAdded);
    }

    @BeforeMethod(description = "Precondition: Exist a student record", groups = {"admin"})
    //Precondition: Exist a student record
    private void loginWithAdminAccount() throws Exception {
        //Login success with admin account
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount,Constant.usernameAdminAccount, Constant.passwordAdminAccount);
        //Go to manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Create student record
        manageStudentPageObject.clickAddStudent();
        manageStudentPageObject.addInforStudentForRoleAdmin(studentIDAdded, firstNameAdded, lastNameAdded, middleNameAdded, userNameAdded, passwordAdded, gradeLevelAdded);
    }

    @AfterMethod(description = "Post Condition : Delete student record in table", groups = {"teacher", "admin"})
    //Post Condition : Delete student created in table
    private void postcondition() throws FindFailed, InterruptedException {
        //Close form Edit Student
        manageStudentPageObject.closeForm();
        //Filter student created
        manageStudentPageObject.filterLastName(lastNameEdited);
        //Click delete student
        manageStudentPageObject.clickDeleteStudentRecord(studentEdited);
        manageStudentPageObject.clickDeleteInWarningPopup();
    }

}
