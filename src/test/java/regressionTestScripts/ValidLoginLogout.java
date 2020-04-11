package regressionTestScripts;

import java.util.List;

import generic.Excel;
import generic.Generic_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom.EnterTimeTrack;
import pom.Login_Page;

public class ValidLoginLogout extends Generic_Test {

	@Test
	public void validloginlogout() {
		log.info("validLoginLogout test script");
		String username = Excel.readData("regression", 1, 1);
		String password = Excel.readData("regression", 1, 2);
		String eTitle = Excel.readData("regression", 1, 3);
		
		test=reports.createTest("validloginlogout", "user tried to login with valid credentails");

		Login_Page lp = new Login_Page(driver);
		test.info("test started");

		lp.setUsername(username);
		test.pass("username entered successfully");

		lp.setPassword(password);
		test.pass("password entered successfully");

		lp.clickLogin();
		test.pass("user clicked on login successfully");

		EnterTimeTrack ep = new EnterTimeTrack(driver);
		ep.verifyTitle(10, "Enter");
		Assert.assertEquals(driver.getTitle(), eTitle);
		test.pass("titlte has been verified");

		ep.clickLogout();
		test.pass("user clicked on logout");

		lp.verifyTitle(5, "Login");
		test.pass("title verified");
		test.info("test ended");

	}

}
