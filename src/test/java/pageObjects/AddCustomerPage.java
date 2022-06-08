/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author AMIT123
 *
 */
public class AddCustomerPage {
	
	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	By lnkCutomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCutomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddNew = By.xpath("//a[normalize-space()='Add new']");
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	By rdGender_Male = By.id("Gender_Male");
	By rdGender_Female = By.id("Gender_Female");
	By txtCompany = By.id("Company");
	
	By dateofBirth = By.xpath("//input[@id='DateOfBirth']");
	
	By checkIsTaxExempt = By.id("IsTaxExempt");
	
	By NewsLetter = By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
	By companyRole = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	
	By listItemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By listItemForumModerators = By.xpath("//li[contains(text(), 'Forum Moderators')]");
	By listItemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By listItemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By listItemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	
	By managerofvendor = By.xpath("//select[@id='VendorId']");
	
	By checkActive = By.id("Active");
	By txtAdminComment = By.id("AdminComment");
	
	By btnSave = By.xpath("//button[@name='save']");
	
	
	//Action Methods
	
	public String getTitleofPage()
	{
		return ldriver.getTitle();
	}
	
	public void clicOnCutomerMenu()
	{
		ldriver.findElement(lnkCutomers_menu).click();
	}
	
	public void clicOnCutomerMenuItem()
	{
		ldriver.findElement(lnkCutomers_menuItem).click();
	}
	
	public void clicOnAddNew()
	{
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setCustomerRole(String role) throws InterruptedException
	{
		ldriver.findElement(companyRole).click();
			
		WebElement listItems = null;
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			listItems=ldriver.findElement(listItemAdministrators);
			
		}
		else if(role.equals("Forum Moderators"))
		{
			listItems=ldriver.findElement(listItemForumModerators);
		}
		else if(role.equals("Guests"))
		{
			listItems=ldriver.findElement(listItemGuests);
		}
		else if(role.equals("Registered"))
		{
			listItems=ldriver.findElement(listItemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listItems=ldriver.findElement(listItemVendors);
		}
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver; 
		js.executeScript("arguments[0].click();", listItems);
}
		
	/*public void setNewsLetter(String newsLetter)
	{
		Select drop = new Select(ldriver.findElement(NewsLetter));
		drop.selectByVisibleText(newsLetter);
	}
*/	public void setmanagerofvendor(String value)
	{
		Select drop = new Select(ldriver.findElement(managerofvendor));
		drop.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdGender_Male).click();;
		}
		else if(gender.equals("FeMale"))
		{
			ldriver.findElement(rdGender_Female).click();;
		}
		else
		{
			ldriver.findElement(rdGender_Male).click();;
		}
	}
	
	public void setDOB(String dob)
	{
		ldriver.findElement(dateofBirth).sendKeys(dob);
	}
	
	public void setCompanyName(String companyName)
	{
		ldriver.findElement(txtCompany).sendKeys(companyName);
	}
	
	public void setAdminComment(String adminComment)
	{
		ldriver.findElement(txtAdminComment).sendKeys(adminComment);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	public void setIsTaxExempt()
	{
		ldriver.findElement(checkIsTaxExempt).click();
	}
	public void setActive()
	{
		ldriver.findElement(checkActive).click();
	}
		
}
