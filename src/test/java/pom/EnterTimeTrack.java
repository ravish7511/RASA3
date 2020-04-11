package pom;

import generic.Base_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class EnterTimeTrack extends Base_Page {

	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;
	
	@FindBy(xpath="//a[.='About actiTIME']")
	private WebElement abtActitime;
	
	@FindBy(xpath="//span[contains(@class,'productVersion')]")
	private WebElement version;
	
	@FindBy(xpath="//td[contains(@class,'close-button')]//img")
	private WebElement close;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	public EnterTimeTrack(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickHelp()
	{
		verifyElement(5, help);
		help.click();
	}
	
	public void clickActitime()
	{
		verifyElement(5, abtActitime);
		abtActitime.click();
	}
	
	public void verifyVersion(String eversion)
	{
		String aversion = version.getText();
		Assert.assertEquals(aversion, eversion);
	}
	
	public void clickClose()
	{
		close.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
	
	
	
	
	
}
