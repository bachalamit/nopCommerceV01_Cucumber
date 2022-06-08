package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	@Before
	public void setup() throws IOException
	{
		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		prop = new Properties();
		FileInputStream configpropfile = new FileInputStream("config.properties");
		prop.load(configpropfile);
		
		
		String br = prop.getProperty("browser");
		
		if(br.equals("chrome"))
		{		
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath") );
			driver = new ChromeDriver();
		}else if(br.equals("firefox"))
		{		
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxpath") );
			driver = new FirefoxDriver();
		}else if(br.equals("edge"))
		{		
			System.setProperty("webdriver.edge.driver",prop.getProperty("edgepath") );
			driver = new EdgeDriver();
		}
		
		logger.info("*****Launching Browser********");
		
	}
	
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("*****Opening URL********");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters the credentials email is {string} and password is {string}")
	public void user_enters_the_credentials_email_is_and_password_is(String email, String password) {
		logger.info("Providing Login Details");
		lp.setUsername(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("Started Login Process");
		lp.clickOnLogin();
		Thread.sleep(4000);
	
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		Thread.sleep(4000);
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("*****Login Passed********");
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		logger.info("*****Login Failed********");
	}

	@When("User Click on Logout")
	public void user_click_on_logout() throws InterruptedException {
		Thread.sleep(8000);
		lp.clickOnLogout();
		

	}

	@Then("Close Browser")
	public void close_browser() {
		logger.info("*****Closing Browser********");
		driver.quit();
	}
	
	//Customer Features
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("*****Dashboard********");
		cp=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", cp.getTitleofPage()); 
	}

	@When("Customer click on Customers menu")
	public void customer_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		cp.clicOnCutomerMenu();
		logger.info("*****Menu Item Is Displayed********");
	}

	@When("User click on customer menu item")
	public void user_click_on_customer_menu_item() {
	    cp.clicOnCutomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		cp.clicOnAddNew();
		Thread.sleep(3000);
	    
	}

	@Then("Customer can view add new customer page")
	public void customer_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", cp.getTitleofPage()); 
	   
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		logger.info("*****Adding New Customer********");
		logger.info("*****Providing Customer Details********");
		String email = randomestring()+"@gmail.com";
		cp.setEmail(email);
		cp.setPassword("Admin123");
		
		cp.setFirstName("Amit");
		cp.setLastName("Bachal");
		cp.setGender("Male");
		cp.setDOB("2/10/1998");
		cp.setCompanyName("AffinityX");
		cp.setIsTaxExempt();
		cp.setCustomerRole("Vendors");
		Thread.sleep(3000);
		
	//	cp.setNewsLetter("Test store 2");
		//cp.setmanagerofvendor("Vendor 1");
		cp.setActive();
		cp.setAdminComment("This for testing.........");
		
		Thread.sleep(3000);
	    
	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("*****Saving Customer Data********");
	 cp.clickOnSave();   
	 Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		logger.info("*****Successfully Added********");
	}

	// Searching customer by EmailID
	
	@When("Enter Customer Email")
	public void enter_customer_email() {
		logger.info("*****Serching by Email ID********");

		searchCustomer =new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	   
	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
		
		searchCustomer.clickOnSearch();
		Thread.sleep(3000);
	
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	
		boolean result = searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals("victoria_victoria@nopCommerce.com", result);
		logger.info("*****Customer is found by Email Id********");
	}
	
	@When("Enter Customer Fist Name")
	public void enter_customer_fist_name() {
		logger.info("*****Serching by Email ID********");
		searchCustomer =new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
	}

	@When("Enter Customer Last Name")
	public void enter_customer_last_name() {
		searchCustomer.setLastName("Terces");
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean result = searchCustomer.searchCustomerByName("Victoria Terces");
		Assert.assertEquals("Victoria Terces", result);
		logger.info("*****Customer is found by Name********");
	}

	
}
