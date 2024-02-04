package testCases;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups={"sanity", "master"})
	public void verify_login() {
		
		logger.info("******  Staring TC_002_LoginTest ********");
		
		try {
		// Home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link on Home page");
		
		hp.clickLogin();
		logger.info("clicked on login link under MyAccount");
		
		// Login page
		LoginPage lg = new LoginPage(driver);
		
		logger.info("entering username and password");
		lg.setEmail(p.getProperty("email"));
		lg.setPassword(p.getProperty("password"));
		Thread.sleep(3000);
		lg.clickLogin();
		logger.info("clicked login button");
		
		Thread.sleep(3000);

		// MyAccount Page
		
		MyAccountPage mg = new MyAccountPage(driver);
		
		boolean targetPage = mg.isMyAccountPageExists();
		System.out.println("The heading of the page is: "+ mg.captureMyAccountText());
		Assert.assertEquals(targetPage, true, "Login to application failed");
		logger.info("test case passed");
		/*
		 * if(myAccounttext==true) { logger.info("test passed");
		 * Assert.assertTrue(true); } else { logger.info("test failed"); Assert.fail();
		 * }
		 */
		}
		catch(Exception e) {
			logger.info("Login to app failed");
			Assert.fail();
		}
		
		logger.info("****** Fininshed TC_002_LoginTest ********");
		
	}
}
