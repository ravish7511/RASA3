package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.EnterTimeTrack;

public class Generic_Test {
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public Logger log=Logger.getLogger(Generic_Test.class);

	BrowserFactory bff = new BrowserFactory();
	FileManager fm = new FileManager();

	@BeforeSuite
	public void setUp() {
		htmlreporter = new ExtentHtmlReporter("./Ereports/" + new Date().toString().replace(":", "-") + ".html"); // path
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void openAppn(@Optional("chrome") String browser) {
		System.out.println("browser name is"+browser);
		log.info("browser is launched");
		if (browser.equals("chrome")) {
			driver = bff.getBrowser("chrome");

			driver.get(fm.getApplicationUrl());

		} else {
			driver = bff.getBrowser("firefox");

			driver.get(fm.getApplicationUrl());

		}

		driver.manage().timeouts().implicitlyWait(fm.getImplicityWait(), TimeUnit.SECONDS);
		

	}

	@AfterMethod
	public void closeAppn(ITestResult res) throws IOException {
		String testName = "";
		if (ITestResult.FAILURE == res.getStatus()) {
			testName=res.getName();
			// ScreenShot.getPhoto(driver, testName);

			test.fail("test case failed", MediaEntityBuilder
					.createScreenCaptureFromPath(new ScreenShot().getPhoto(driver, testName)).build());
		}
		
		
		
		test.assignAuthor("ravish");
		test.assignDevice("Laptop");
		test.assignCategory("Gui Automation");
		reports.setSystemInfo("windows", "10");
		
		
		
		driver.quit();
		
		
		
	}

	@AfterSuite
	public void tearDown() {
		reports.flush();
	}

}
