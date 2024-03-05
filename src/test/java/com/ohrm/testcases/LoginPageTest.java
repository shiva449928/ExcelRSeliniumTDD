package com.ohrm.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;
import com.ohrm.utility.ExcelReader;



public class LoginPageTest {
		
			//WebDriver driver;
			LoginPage lp;
			DashboardPage dp;
			@BeforeMethod
			public void browserSetup() {
				lp = new LoginPage();
				lp.initialization();
			}
			@Test
			public void validateTitle() {
				String ortitle = "OrangeHRM";
				String extitle = lp.getTitle();
				Assert.assertEquals(ortitle, extitle);
			}
			@Test
			public void validateLogin() throws IOException {
				dp = lp.login();
				Assert.assertTrue(dp.getDashboardLabel());
				lp.captureScreenshot("Login_Tc");
			}
			@Test(dataProvider = "getLoginData")
			public void validateMultipleData(String username, String password) {
				dp = lp.login(username, password);
				Assert.assertTrue(dp.getDashboardLabel());
			}
			@DataProvider
			public Object[][] getLoginData() throws IOException {
				String excelPath = "./src/test/resources/LoginDetails.xlsx";
				String sheetName = "login";
				return ExcelReader.getData(excelPath, sheetName);
			}
			@Test
			public void resetPassword() {
				Assert.assertTrue(lp.reset());
			}
			@AfterMethod
			public void closeBrowser() {
				lp.tearDown();
			}
}
