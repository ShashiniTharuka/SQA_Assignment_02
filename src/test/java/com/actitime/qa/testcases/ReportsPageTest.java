package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;
import com.actitime.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;

	ReportsPage reportsPage;
	String sheetName = "Users";
	TestUtil testUtil;



	public ReportsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		homePage.clickOnReportsLink();
		reportsPage = new ReportsPage();
	}

	@Test(priority = 1)
	public void reportsPageLogoTest() {
		boolean flag= reportsPage.validateActiTimeLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void reportsPageReportCellTest() {
		boolean flag= reportsPage.validateReportCells();
		Assert.assertTrue(flag);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
