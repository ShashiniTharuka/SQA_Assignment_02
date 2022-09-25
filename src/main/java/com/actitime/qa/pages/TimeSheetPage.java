package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeSheetPage extends TestBase {


    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;

    @FindBy(xpath = "//td[@class='pagetitle']")
    WebElement approvePageTitle;

    @FindBy(xpath = "//*[contains(text(),'View Time-Track')]")
    WebElement viewTimeTrackButton;

    @FindBy(xpath = "//td[@class='viewTimeTrackTitle pagetitle']")
    WebElement viewTimeTrackPageTitle;

    @FindBy(xpath = "//td[@class='viewTTChartPanel showViewTTChartPanel']")
    WebElement leaveAttendanceChart;

    @FindBy(xpath = "//*[contains(text(),'Approve Time-Track')]")
    WebElement approveTimeTrackButton;

    @FindBy(xpath = "//tr[@class='childRow notReady']/td[@class='selectionCell']/input")
    WebElement approveCheckBox;

    @FindBy(xpath = "//span[@id='approveButton']")
    WebElement approveButton;

    @FindBy(xpath = "//tr[@class='childRow operationWasApplied approved']/td[@class='statusCell']/span")
    WebElement approvalStatus;


    //initialization

    public TimeSheetPage() {
        PageFactory.initElements(driver, this);
    }

    //Methods

    public Boolean validateActiTimeLogo() {
        return actitimeLogo.isDisplayed();
    }

    public Boolean viewTimeSheet() {
        viewTimeTrackButton.click();
        return viewTimeTrackPageTitle.isDisplayed();
    }

    public Boolean validateLeaveAndAttendance(){
        viewTimeTrackButton.click();
        return leaveAttendanceChart.isDisplayed();
    }

    public Boolean validateApproveTimeTrackPage(){
        approveTimeTrackButton.click();
        return approvePageTitle.isDisplayed();
    }

    public Boolean validateTimeSheetApproving(){
        approveTimeTrackButton.click();
        approveCheckBox.click();
        approveButton.click();
        System.out.println("Status Text: " + approvalStatus.getText());
        return approvalStatus.getText() == "Approved";
    }



}
