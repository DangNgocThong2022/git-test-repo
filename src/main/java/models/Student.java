package models;

public class Student {
    private String action;
    private String userID;
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String grade;
    private String status;
    private String schoolPID;

    public Student(String action, String userId, String userName, String password, String firstName, String middleName, String lastName, String grade, String status, String schoolPID) {
        this.action = action;
        this.userID = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.grade = grade;
        this.status = status;
        this.schoolPID = schoolPID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolPID() {
        return schoolPID;
    }

    public void setSchoolPID(String schoolPID) {
        this.schoolPID = schoolPID;
    }

}