package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//tr[@class='taskRow']")
    WebElement tasksList;


    //methods
    public TasksPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }



	
}
