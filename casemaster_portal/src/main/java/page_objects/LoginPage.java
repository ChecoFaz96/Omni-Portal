package page_objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By signInBtn = By.xpath("//button[contains(text(),'SIGN IN')]");
	By emailAlert = By.xpath("//span[contains(text(),'Email is invalid or empty')]");
	By passwordAlert = By.xpath("//span[contains(text(),'Password must have at least 8 characters')]");
	By alert = By.xpath("//span[contains(text(),'You entered an incorrect email, password, or both.')]");
	By adminLoginBtn = By.xpath("//span[@class=\"forgot-password\" and contains(text(),'Omni team members login here')]");
	By adminEmail = By.xpath("//input[@name='loginfmt']");
	By adminPassword = By.xpath("//input[@name='passwd']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSignIn() {
		return driver.findElement(signInBtn);
	}
	
	public WebElement getEmailAlert() {
		return driver.findElement(emailAlert);
	}
	
	public WebElement getPasswordAlert() {
		return driver.findElement(passwordAlert);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
	
	public WebElement getAdminLoginBtn() {
		return driver.findElement(adminLoginBtn);
	}
	
	public WebElement getAdminEmail() {
		return driver.findElement(adminEmail);
	}
	
	public WebElement getAdminPassword() {
		return driver.findElement(adminPassword);
	}
	
	public void loginAttorneyMethod() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getEmail().sendKeys(prop.getProperty("attorneyEmail"));
		lpage.getPassword().click();
		lpage.getPassword().sendKeys(prop.getProperty("attorneyPassword"));
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")));
	}
	
	public void loginEmptyEmail() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getPassword().click();
		lpage.getPassword().sendKeys(prop.getProperty("attorneyPassword"));
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-wrong-icon']")));
	}
	
	public void loginEmptyPassword() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getEmail().sendKeys(prop.getProperty("attorneyEmail"));
		lpage.getPassword().click();
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-wrong-icon']")));
	}
	
	public void loginIncorrectEmail() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getEmail().sendKeys(prop.getProperty("incorrectAttorneyEmail"));
		lpage.getPassword().click();
		lpage.getPassword().sendKeys(prop.getProperty("attorneyPassword"));
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-wrong-icon']")));
	}
	
	public void loginIncorrectPassword() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getEmail().sendKeys(prop.getProperty("attorneyEmail"));
		lpage.getPassword().click();
		lpage.getPassword().sendKeys(prop.getProperty("incorrectAttorneyPassword"));
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-wrong-icon']")));
	}
	
	
	public void loginAttorneyMethodNewPassword() throws IOException {
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		LoginPage lpage = new LoginPage(driver);
		lpage.getEmail().click();
		lpage.getEmail().sendKeys(prop.getProperty("attorneyEmail"));
		lpage.getPassword().click();
		lpage.getPassword().sendKeys("iTexico1+");
		lpage.getSignIn().click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")));
	}

}
