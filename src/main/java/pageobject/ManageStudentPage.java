package pageobject;


import common.Constant;
import common.helpers.DataHelper;
import common.helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import java.awt.*;
import java.io.File;

public class ManageStudentPage extends GeneralPage {
    //Declare element for page
    private By addStudentBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","addStudentBtn");
    private By importRosterPageBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","importRosterPageBtn");
    private By chooseFileBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","chooseFileBtn");
    private By continueBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","continueBtn");
    private By importRosterBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","importRosterBtn");
    private By downloadStudentRosterImportTemplate = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","downloadStudentRosterImportTemplate");
    private By selectFileTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","selectFileTxb");
    private By studentIDTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","studentIDTxb");
    private By firstNameTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","firstNameTxb");
    private By middleNameTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","middleNameTxb");
    private By lastNameTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","lastNameTxb");
    private By userNameTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","userNameTxb");
    private By passwordTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","passwordTxb");
    private By gradeLevelAddCbx = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","gradeLevelAddCbx");
    private By gradeLevelTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","gradeLevelTxb");
    private By gradeLevelEditCbx = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","gradeLevelEditCbx");
    private By saveBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","saveBtn");
    private By closeBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","closeBtn");
    private By messageAlert = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","messageAlert");
    private By lastnameFilterTxb = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","lastnameFilterTxb");
    private By applyFilterBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","applyFilterBtn");
    private By hidePasswordIc = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","hidePasswordIc");
    private By messageDeleteAlert = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","messageDeleteAlert");
    private By deleteStudentBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","deleteStudentBtn");
    private By addLicenseCbx = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","addLicenseCbx");
    private By licenseTable = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","licenseTable");
    private By warningTitle = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","warningTitle");
    private By importRosterSummary = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","importRosterSummary");
    private By returnToManageStudentsBtn = getElementInDictionary(Constant.pathDataDictionaryFile,"ManageStudentPage","returnToManageStudentsBtn");

    public ManageStudentPage() throws Exception {
    }

    //Declare method for page
    public void clickAddLicense() throws InterruptedException {
        waitForControlVisible(addLicenseCbx, 10);
        click(addLicenseCbx);
    }

    public void clickAddStudent() throws InterruptedException {
        waitForControlVisible(addStudentBtn, 10);
        click(addStudentBtn);
    }

    public void clickImportRoster() {
        waitForControlVisible(importRosterPageBtn, 10);
        click(importRosterPageBtn);
    }

    public void clickChooseFile() {
        waitForControlVisible(chooseFileBtn, 10);
        click(chooseFileBtn);
    }

    public void uploadFile(String pathLocation, String fileName) throws InterruptedException, AWTException {
        Thread.sleep(1000);
        uploadFileByRobot(pathLocation, fileName);
        Thread.sleep(1000);
    }

    public void clickContinueImportRoster() {
        waitForControlVisible(continueBtn, 10);
        click(continueBtn);
    }

    public void clickImportRosterInPopup() {
        waitForControlVisible(importRosterBtn, 10);
        click(importRosterBtn);
    }

    public void clickDownloadStudentRosterImportTemplate() throws InterruptedException {
        waitForControlVisible(downloadStudentRosterImportTemplate, 10);
        click(downloadStudentRosterImportTemplate);
        Thread.sleep(5000);
    }

    public void addInforStudentForRoleTeacher(String studentID, String firstName, String lastName, String middleName, String userName, String password, String grade) throws InterruptedException {
        waitForControlVisible(saveBtn, 10);
        type(studentIDTxb, studentID);
        type(firstNameTxb, firstName);
        type(middleNameTxb, middleName);
        type(lastNameTxb, lastName);
        type(userNameTxb, userName);
        type(passwordTxb, password);
        click(gradeLevelAddCbx);
        Thread.sleep(1000);
        type(gradeLevelTxb, grade);
        Thread.sleep(1000);
        enterTextbox(gradeLevelTxb);
        click(saveBtn);
    }

    public void addInforStudentForRoleAdmin(String studentID, String firstName, String lastName, String middleName, String userName, String password, String grade) throws InterruptedException {
        waitForControlVisible(saveBtn, 10);
        type(studentIDTxb, studentID);
        type(firstNameTxb, firstName);
        type(middleNameTxb, middleName);
        type(lastNameTxb, lastName);
        type(userNameTxb, userName);
        type(passwordTxb, password);
        click(gradeLevelAddCbx);
        Thread.sleep(1000);
        type(gradeLevelTxb, grade);
        Thread.sleep(1000);
        enterTextbox(gradeLevelTxb);
        clickAddLicense();
        waitForControlVisible(licenseTable, 10);
        scrollToBottom();
        Thread.sleep(1000);
        click(saveBtn);
    }

    public void editInforStudentForRoleAdmin(String studentID, String firstName, String lastName, String middleName, String userName, String password, String grade) throws InterruptedException {
        waitForControlVisible(saveBtn, 10);
        backspaceTextbox(studentIDTxb);
        backspaceTextbox(firstNameTxb);
        backspaceTextbox(middleNameTxb);
        backspaceTextbox(lastNameTxb);
        backspaceTextbox(userNameTxb);
        backspaceTextbox(passwordTxb);
        type(studentIDTxb, studentID);
        type(firstNameTxb, firstName);
        type(middleNameTxb, middleName);
        type(lastNameTxb, lastName);
        type(userNameTxb, userName);
        type(passwordTxb, password);
        click(gradeLevelEditCbx);
        Thread.sleep(1000);
        type(gradeLevelTxb, grade);
        Thread.sleep(1000);
        enterTextbox(gradeLevelTxb);
        clickAddLicense();
        waitForControlVisible(licenseTable, 10);
        scrollToBottom();
        Thread.sleep(1000);
        click(saveBtn);
    }

    public void editInforStudentForRoleTeacher(String studentID, String firstName, String lastName, String middleName, String userName, String password, String grade) throws InterruptedException {
        waitForControlVisible(saveBtn, 10);
        backspaceTextbox(studentIDTxb);
        backspaceTextbox(firstNameTxb);
        backspaceTextbox(middleNameTxb);
        backspaceTextbox(lastNameTxb);
        backspaceTextbox(userNameTxb);
        backspaceTextbox(passwordTxb);
        type(studentIDTxb, studentID);
        type(firstNameTxb, firstName);
        type(middleNameTxb, middleName);
        type(lastNameTxb, lastName);
        type(userNameTxb, userName);
        type(passwordTxb, password);
        click(gradeLevelEditCbx);
        Thread.sleep(1000);
        type(gradeLevelTxb, grade);
        Thread.sleep(1000);
        enterTextbox(gradeLevelTxb);
        click(saveBtn);
    }

    public void closeForm() {
        clickJavascript(closeBtn);

    }

    public String getTextMessageAlert() throws InterruptedException {
        Thread.sleep(3000);
        waitImplicitly(10);
        scrollToTop();
        waitForControlVisible(messageAlert, 10);
        return getTextControl(messageAlert);
    }

    public String getTextStudentID() {
        waitForControlVisible(studentIDTxb, 10);
        return getTextJavascript(studentIDTxb);
    }

    public String getTextFirstName() {
        waitForControlVisible(firstNameTxb, 10);
        return getTextJavascript(firstNameTxb);
    }

    public String getTextMiddleName() {
        waitForControlVisible(middleNameTxb, 10);
        return getTextJavascript(middleNameTxb);
    }

    public String getTextLastName() {
        waitForControlVisible(lastNameTxb, 10);
        return getTextJavascript(lastNameTxb);
    }

    public String getTextUserName() {
        waitForControlVisible(userNameTxb, 10);
        return getTextJavascript(userNameTxb);
    }

    public String getTextPassword() {
        waitForControlVisible(passwordTxb, 10);
        click(hidePasswordIc);
        return getTextJavascript(passwordTxb);
    }

    public String getTextGradeLevel() {
        waitForControlVisible(gradeLevelEditCbx, 10);
        return getTextControl(gradeLevelEditCbx);
    }

    public void filterLastName(String lastname) throws InterruptedException, FindFailed {
        waitImplicitly(10);
        waitForControlVisible(addStudentBtn, 10);
        waitForControlVisible(lastnameFilterTxb, 10);
        backspaceTextbox(lastnameFilterTxb);
        type(lastnameFilterTxb, lastname);
        waitForControlVisible(applyFilterBtn, 10);
        hoverMouse(applyFilterBtn);
        click(applyFilterBtn);
        Thread.sleep(2000);
        scrollToBottom();

    }

    public void editStudentRecord(String value) throws InterruptedException {
        Thread.sleep(1000);
        try {
            for (int i = 1; i <= 100; i++) {
                String sValue = getTextControl(By.xpath("//tbody/tr[" + i + "]"));
                if (sValue.equalsIgnoreCase(value)) {
                    // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                    By actionsIc = By.xpath("//table//tbody/tr[" + i + "]/td[6]" + ExcelHelper.getLocatorValueFromExcel(Constant.pathDataDictionaryFile,"ManageStudentPage","actionIc"));
                    waitForControlVisible(actionsIc, 10);
                    hoverMouse(actionsIc);
                    click(actionsIc);
                    By editAccountLink = By.xpath("//table//tbody/tr[" + i + "]/td[6]" + ExcelHelper.getLocatorValueFromExcel(Constant.pathDataDictionaryFile,"ManageStudentPage","editAccountlnk"));
                    waitForControlVisible(editAccountLink, 5);
                    click(editAccountLink);
                }
            }
        } catch (Exception e) {
        }
    }

    public void clickDeleteStudentRecord(String value) throws InterruptedException {
        Thread.sleep(1000);
        try {
            for (int i = 1; i <= 100; i++) {
                String sValue = getTextControl(By.xpath("//tbody/tr[" + i + "]"));
                if (sValue.equalsIgnoreCase(value)) {
                    // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                    By actionsIc = By.xpath("//table//tbody/tr[" + i + "]/td[6]" + ExcelHelper.getLocatorValueFromExcel(Constant.pathDataDictionaryFile,"ManageStudentPage","actionIc"));
                    waitForControlVisible(actionsIc, 10);
                    hoverMouse(actionsIc);
                    click(actionsIc);
                    By deleteAccountLink = By.xpath("//table//tbody/tr[" + i + "]/td[6]" + ExcelHelper.getLocatorValueFromExcel(Constant.pathDataDictionaryFile,"ManageStudentPage","deleteAccountlnk"));
                    waitForControlVisible(deleteAccountLink, 5);
                    click(deleteAccountLink);
                }
            }
        } catch (Exception e) {
        }
    }

    public Boolean isStudentRecordFound(String value) throws InterruptedException {
        Thread.sleep(1000);
        Boolean isExist = null;
        try {
            for (int i = 1; i <= 100; i++) {
                String sValue = getTextControl(By.xpath("//tbody/tr[" + i + "]"));

                if (sValue.equalsIgnoreCase(value)) {
                    // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                    isExist = true;
                } else isExist = false;
            }
        } catch (Exception e) {
        }
        return isExist;

    }

    public String getMessageDeleteWarning() {
        waitForControlVisible(messageDeleteAlert, 10);
        return getTextControl(messageDeleteAlert);
    }

    public void clickDeleteInWarningPopup() throws InterruptedException {
        clickJavascript(deleteStudentBtn);
        Thread.sleep(12000);
    }

    public String getImportRosterSummary() {
        waitForControlVisible(importRosterSummary, 5);
        return getTextControl(importRosterSummary);
    }
    public void clickReturnToManageStudentsBtn() {
        waitForControlVisible(returnToManageStudentsBtn, 5);
        click(returnToManageStudentsBtn);
    }
}
