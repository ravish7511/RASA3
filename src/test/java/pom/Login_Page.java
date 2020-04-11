package pom;

import generic.Base_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login_Page extends Base_Page {

	@FindBy(id="username")
	private WebElement unamtxtbox;
	
	@FindBy(name="pwd")
	private WebElement pwdtxtbox;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement login;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errmsg;
	
	
	public Login_Page(WebDriver driver)
	{
		super(driver);
	}
	
	public void setUsername(String uname)
	{
		unamtxtbox.sendKeys(uname);
	}
	
	public void setPassword(String pword)
	{
		pwdtxtbox.sendKeys(pword);
	}
	
	public void verifyErrmsg()
	{
		verifyElement(5, errmsg);
	}
	
	public void clickLogin()
	{
		login.click();
	}
}
