package com.ohrm.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class DashboardPageTest {
		
	
		DashboardPage dp;
		LoginPage lp;
		@BeforeMethod
		public void browserSetup() {
			lp = new LoginPage();
			lp.initialization();
		}
		@Test
		public void validateTimeWorkSectionTest() {
			dp = lp.login();
			Assert.assertTrue(dp.getTimeWorkSection());
		}
		@Test
		public void validateMyActionsTest() {
			dp = lp.login();
			Assert.assertTrue(dp.getMyActions());
		}
		@Test
		public void validateQuickLaunch() {
			dp = lp.login();
			Assert.assertTrue(dp.getQuickLaunch());
		}
		@Test
		public void validateBuzzLatestPosts() {
			dp = lp.login();
			Assert.assertTrue(dp.getBuzzLatestPosts());
		}
		@Test
		public void validateEmployeesOnLeaveToday() {
			dp = lp.login();
			Assert.assertTrue(dp.getEmployeesOnLeaveToday());
		}
		@Test
		public void validateEmployeeDistributionbySubUnit() {
			dp = lp.login();
			Assert.assertTrue(dp.getEmployeeDistributionbySubUnit());
		}
		@Test
		public void validateEmployeeDistributionbyLocation() {
			dp = lp.login();
			Assert.assertTrue(dp.getEmployeeDistributionbyLocation());
		}
		
		@AfterMethod
		public void closeBrowser() {
			dp.tearDown();
		}
}
