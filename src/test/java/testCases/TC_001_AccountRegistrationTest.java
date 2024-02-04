package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"regression", "master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("********** starting test TC_001_AccountRegistrationTest *******");
		
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Registration link");

		logger.info("Entering customer details..");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on Continue");

		
		Thread.sleep(3000);
		String confmsg=regpage.getConfirmationMsg();
		System.out.println(confmsg);
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.debug("test failed");
			Assert.fail();
		}
		
				}
		catch(Exception e){
			logger.error("test failed..");
			Assert.fail();
		}
		logger.info("******** Finished TC_001_AccountRegistrationTest execution");

	}
	
	
}

