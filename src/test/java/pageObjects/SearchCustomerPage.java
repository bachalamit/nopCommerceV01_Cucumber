/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;
import utlities.WaitHelper;

/**
 * @author AMIT123
 *
 */
public class SearchCustomerPage extends BaseClass{
	
	public WebDriver ldriver;
	WaitHelper 	waithelper; 
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(id="SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement txtFirstName;
	
	@FindBy(id="SearchLastName")
	WebElement txtlastName;
	
	@FindBy(id="SearchCompany")
	WebElement txtCompany;
	
	@FindBy(id="SearchIpAddress")
	WebElement txtSearchIpAddress;
	
	@FindBy(id="search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath = "//tabel[@role='grid']")
	WebElement tblSearchResult;
	
	@FindBy(xpath = "//tabel[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath = "//tabel[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//tabel[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email)
	{
		//waithelper.WaitForElemant(txtEmail, 30);
		txtEmail.click();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtlastName.clear();
		txtlastName.sendKeys(lname);
	}
	public void clickOnSearch() throws InterruptedException
	{
		btnSearch.click();

	}
	
	public int getNoOfRows()
	{
		System.out.println(tableRows.size());
		return(tableRows.size());
	}
	
	public int getNoOfCols()
	{
		System.out.println(tableColumns.size());
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows();i++)
		{
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			//String emailid = table.findElement(By.xpath("//td[normalize-space()='victoria_victoria@nopCommerce.com']")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows();i++)
		{
			String name = table.findElement(By.xpath("//tabel[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			//String name = table.findElement(By.xpath("//td[normalize-space()='Victoria Terces']")).getText();

			String names[]=name.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag=true;
			}
		}
		return flag;
	}
}
