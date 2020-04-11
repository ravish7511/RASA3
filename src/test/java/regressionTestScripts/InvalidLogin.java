package regressionTestScripts;

import generic.Excel;
import generic.Generic_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.Login_Page;

public class InvalidLogin extends Generic_Test {

	@Test
	public void invalidLogin() {
		String username = Excel.readData("regression", 2, 1);
		String password = Excel.readData("regression", 2, 2);
		String eTitle = Excel.readData("regression", 2, 3);
		
		test=reports.createTest("invalidlogin", "user enters invalid credentials in order to login");
		
		test.info("invalidlogin test has started");
		Login_Page lp = new Login_Page(driver);
		lp.setUsername(username);
		test.pass("successfully username entered");
		lp.setPassword(password);
		test.pass("successfully entered password");
		lp.clickLogin();
		test.pass("successfully clicked on login");
		lp.verifyErrmsg();
		test.pass("error message displayed");
		lp.verifyTitle(5, "abcd");
		Assert.assertEquals(driver.getTitle(), eTitle);
		test.pass("title verified successfully");
		test.info("test ended");

	}

}
