package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.HeaderPage;
import page_objects.LoginPage;
import resources.Base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Login.class.getName());
	LoginPage lpage;
	HeaderPage hpage;
	
	@BeforeMethod
	public void initialize() throws IOException  {
		driver = initializeDriver();
		driver.get(prop.getProperty("urlCaseMasterPortal"));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void TC01_login_Attorney_Validation() throws IOException {
		lpage = new LoginPage(driver);
		lpage.loginAttorneyMethod();
		Assert.assertTrue(driver.findElements(By.xpath("//span[@class='text-header-bold']")).size()>0);
		log.info("Successfully login");
	}
	
	@Test(priority=2)
	public void TC06_logout_Validation() throws InterruptedException, IOException {
		
		lpage = new LoginPage(driver);
		hpage = new HeaderPage(driver);
		lpage.loginAttorneyMethod();
		hpage.logoutMethod();
		Assert.assertTrue(lpage.getSignIn().isDisplayed());
		log.info("Successfully logout");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
