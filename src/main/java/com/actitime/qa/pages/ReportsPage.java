package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase  {

	
	// Web Element Xpath 

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//td[@class='configsTableRowCell']")
    WebElement reportTableCells;

	

	// Methods
    public ReportsPage() {
        PageFactory.initElements(driver, this);
    }


    // Method
    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }

    public Boolean validateReportCells(){
        return reportTableCells.isDisplayed();
    }


}
