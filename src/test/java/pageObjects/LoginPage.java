package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement btnLogout;
	
	public void setUsername(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	public void clickOnLogout()
	{
		btnLogout.click();
	}
}
