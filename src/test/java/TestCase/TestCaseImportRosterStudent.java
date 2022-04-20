package testcase;

import common.CommonFunction;
import common.Constant;
import common.helpers.DataHelper;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ManageStudentPage;

import java.awt.*;

public class TestCaseImportRosterStudent extends BaseTest {
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
    private String gradeLevel = "9";
    private String studentAdded = studentID + " " + lastName + " " + firstName + " " + "Grade " +gradeLevel+ " " + "Enabled";
    private String fileImportStudent = "importStudent.csv";
    private String filePath = "file-import/importStudent.csv";
    private String[] headerFile = {"Action (A/U) (Required)", "Unique User ID (Optional)", "Username (Required)", "Password (Required)", "First Name (Required)", "Middle Name (Optional)", "Last Name (Required)", "Grade (Optional)", "Status Active/Inactive (Optional)", "School PID (Optional - District Only)"};
    private String[][] contentFile = {{"A", studentID, userName, password, firstName, middleName, lastName, gradeLevel, "Active", ""}};
    private String importRosterSummary = "Number of records in Import file: 1\n" +
            "Number of student account created: 1\n" +
            "Number of records not added due to errors: 0";


    @Test(description = "User can import roster student success with role teacher", groups = {"teacher"})
    private void importRosterStudentSuccessWithRoleTeacher() throws Exception {
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Click Import Roster
        manageStudentPageObject.clickImportRoster();
        //Choose file from computer
        manageStudentPageObject.clickChooseFile();
        manageStudentPageObject.uploadFile(Constant.pathFileImport, fileImportStudent);
        //Click Continue
        manageStudentPageObject.clickContinueImportRoster();
        manageStudentPageObject.clickImportRosterInPopup();
        //Verify import roster summary
        Assert.assertEquals(manageStudentPageObject.getImportRosterSummary(), importRosterSummary);
        //Click return the manager student
        manageStudentPageObject.clickReturnToManageStudentsBtn();
        //Filter last name student import
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
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), "Grade " +gradeLevel);

    }

    @Test(description = "User can import roster student success with role admin", groups = {"admin"})
    private void importRosterStudentSuccessWithRoleAdmin() throws Exception {
        //Go to Manage student page
        manageStudentPageObject = homePageObject.goToManageStudentPage();
        //Click Import Roster
        manageStudentPageObject.clickImportRoster();
        //Choose file from computer
        manageStudentPageObject.clickChooseFile();
        manageStudentPageObject.uploadFile(Constant.pathFileImport, fileImportStudent);
        //Click Continue
        manageStudentPageObject.clickContinueImportRoster();
        //Click Import Roster
        manageStudentPageObject.clickImportRosterInPopup();
        //Verify import roster summary
        Assert.assertEquals(manageStudentPageObject.getImportRosterSummary(), importRosterSummary);
        //Click return the manager student
        manageStudentPageObject.clickReturnToManageStudentsBtn();
        //Filter last name student import
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
        Assert.assertEquals(manageStudentPageObject.getTextGradeLevel(), "Grade " +gradeLevel);

    }

    @BeforeMethod(description = "Precondition: Create file data test and login success with account teacher", groups = {"teacher"})
    //Precondition: Create data test and login success with account teacher
    private void prerequisiteForRoleTeacher() throws Exception {
        //Create file csv for import student success
        DataHelper.generateDataCSV(filePath, headerFile, contentFile);
        //Login success with teacher account
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount, Constant.usernameTeacherAccount, Constant.passwordTeacherAccount);
    }

    @BeforeMethod(description = "Precondition: Create file data test and login success with account admin", groups = {"admin"})
    //Precondition: Create data test and login success with account admin
    private void prerequisiteForRoleAdmin() throws Exception {
        //Create file csv for import student success
        DataHelper.generateDataCSV(filePath, headerFile, contentFile);
        //Login success with admin account
        loginPageObject = openLoginPage();
        homePageObject = loginPageObject.loginSuccess(Constant.passcodeAccount, Constant.usernameAdminAccount, Constant.passwordAdminAccount);
    }

    @AfterMethod(description = "Precondition: Delete StudentImportTemplate.csv in file-download folder", groups = {"admin", "teacher"})
    //Post Condition : Delete StudentImport.csv in file-import folder
    private void postcondition() throws InterruptedException, FindFailed {
        //Delete StudentImport.csv in file-import folder
        CommonFunction.deleteFileInFolder(filePath);
        //Close form Edit Student
        manageStudentPageObject.closeForm();
        //Filter student created
        manageStudentPageObject.filterLastName(lastName);
        //Click delete student
        manageStudentPageObject.clickDeleteStudentRecord(studentAdded);
        manageStudentPageObject.clickDeleteInWarningPopup();
    }


}
