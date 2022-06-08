/**
 * 
 */
package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

/**
 * @author AMIT123
 *
 */
public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage cp;
	public SearchCustomerPage searchCustomer;
	public static Logger logger;
	public Properties prop;

	
	public static String randomestring()
	{
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		return (genratedString);
	}

}
