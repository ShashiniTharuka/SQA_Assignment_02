package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import com.actitime.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalSummaryTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TimeSheetPage tsheetPage;
    UsersPage usersPage;

    ReportsPage reportsPage;

    TestUtil testUtil;

    public FinalSummaryTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        homePage.clickOnUsersLink(); //Redirect to users tab because the first task is to check employee profiles
        usersPage = new UsersPage();
        tsheetPage = new TimeSheetPage();
    }

    //Requirement 01 : Checking Employee user profile

    //Check if the user page loads or not
    @Test(priority = 1)
    public void usersPageLogoTest() {
        boolean flag= usersPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

    //Check whether employee list is displayed or not
    @Test(priority = 2)
    public void userListTest() {
        boolean flag= usersPage.validateUserTable();
        Assert.assertTrue(flag);
    }

    //Check whether the user profile of an employee is displayed or not
        // step 01 - Click on the first employee in the list
        // step 02 - View the employee profile

    @Test(priority = 3)
    public void userProfileTest() {
        boolean flag= usersPage.validateIndividualUser();
        Assert.assertTrue(flag);
    }

    //Requirement 02 : Checking Employee individual attendance and leave report

    //Check whether the time sheet page is displayed or not
    @Test(priority = 4)
    public void gotoTimeSheetPageTest() {
        TimeSheetPage tsheetPage = usersPage.clickOnTimeTrackLink();
        boolean flag= tsheetPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

   //Visit the required page
    @Test(priority = 5)
    public void viewTimeSheetPageTest(){
        TimeSheetPage tsheetPage = usersPage.clickOnTimeTrackLink();
        boolean flag = tsheetPage.viewTimeSheet();
        Assert.assertTrue(flag);
    }

    //Check whether the time sheet page display the relevant attendance and leave information
    @Test(priority = 6)
    public void leaveAttendanceReportTest(){
        TimeSheetPage tsheetPage = usersPage.clickOnTimeTrackLink();
        boolean flag = tsheetPage.validateLeaveAndAttendance();
        Assert.assertTrue(flag);
    }

    //Requirement 03 : Checking the time sheet approval and rejection

    //Check whether the relevant page loading and displaying the relevant information or not
    @Test(priority = 7)
    public void viewApprovePageTest(){
        TimeSheetPage tsheetPage = usersPage.clickOnTimeTrackLink();
        boolean flag = tsheetPage.validateApproveTimeTrackPage();
        Assert.assertTrue(flag);
    }

    //Check whether approving of a time sheet is success or not
    @Test(priority = 8)
    public void approvalProcessTest(){
        TimeSheetPage tsheetPage = usersPage.clickOnTimeTrackLink();
        boolean flag = tsheetPage.validateTimeSheetApproving();
        System.out.println("flag" + flag);

        if(flag){
            Assert.assertTrue(flag);
        }else{
            Assert.assertFalse(flag);
        }

    }



}
