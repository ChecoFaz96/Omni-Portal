package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.HeaderPage;
import page_objects.LoginPage;
import resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Header extends Base{
	
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
	public void TC_changePassword_Validation() throws IOException, InterruptedException {
		hpage = new HeaderPage(driver);
		hpage.changePassword();
		Assert.assertTrue(driver.findElements(By.xpath("//span[@class='text-header-bold']")).size()>0);
		log.info("Successfully login");
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
