package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//table[@class='userNameContainer']")
    WebElement userRow;

    @FindBy(xpath = "//div[@id='editUserPanel']")
    WebElement individualUserProfile;

    @FindBy(xpath = "//a[@class='content tt']")
    WebElement timeTrackLink;

    //methods
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }

    public Boolean validateUserTable(){
        return userRow.isDisplayed();
    }

    public Boolean validateIndividualUser(){
        userRow.click();
        return individualUserProfile.isDisplayed();

    }

    public TimeSheetPage clickOnTimeTrackLink() {
        timeTrackLink.click();
        return new TimeSheetPage();
    }
}
