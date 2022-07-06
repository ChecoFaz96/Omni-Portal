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

public class HeaderPage {
	
	public WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By homeTab = By.xpath("//span[@class=\"text-header\" and contains(text(),'Home')]");
	By myCasesTab = By.xpath("//span[@class=\"text-header\" and contains(text(),'My Cases')]");
	By userOptions = By.xpath("//span[@class='ap-icon ap-arrow-down']");
	By signOut = By.xpath("//span[contains(text(),'Sign out')]");
	By searchBox = By.xpath("//div[@id='search-box']/input");
	By currentPassword = By.xpath("//input[@name='CurrentPassword']");
	By newPassword = By.xpath("//input[@name='NewPassword']");
	By saveBtn = By.xpath("//dx-button[@text='SAVE']");
	By cancelBtn = By.xpath("//span[contains(text(),'CANCEL')]");
	By myAccount = By.xpath("//span[contains(text(),'My account')]");
	By screen = By.xpath(" //div[@ id='form-container']");
	
	
	public WebElement getUserOptions() {
		return driver.findElement(userOptions);
	}
	
	public WebElement getMyCases() {
		return driver.findElement(myCasesTab);
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(myAccount);
	}
	
	public WebElement getHomeTab() {
		return driver.findElement(homeTab);
	}
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	
	public WebElement getCurrentPassword() {
		return driver.findElement(currentPassword);
	}
	
	public WebElement getNewPassword() {
		return driver.findElement(newPassword);
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	
	public WebElement getCancelBtn() {
		return driver.findElement(cancelBtn);
	}
	
	
	public WebElement getFormContainer() {
		return driver.findElement(screen);
	}
	
	public  void clickOnMyAccount() {
		HeaderPage hpage = new HeaderPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-arrow-down']")));
		hpage.getUserOptions().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My account')]")));
		hpage.getMyAccount().click();
	}
	
	public void logoutMethod() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Loading...')]")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ap-icon ap-arrow-down']")));
		driver.findElement(userOptions).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sign out')]")));
		driver.findElement(signOut).click();
	}
	
	public void changePassword() throws InterruptedException, IOException {
		HeaderPage hpage = new HeaderPage(driver);
		LoginPage lpage = new LoginPage(driver);
		lpage.loginAttorneyMethod();
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		WebDriverWait wait = new WebDriverWait(driver,20);
		hpage.clickOnMyAccount();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CurrentPassword']")));
		hpage.getCurrentPassword().click();
		hpage.getCurrentPassword().sendKeys(prop.getProperty("attorneyPassword"));
		hpage.getNewPassword().click();
		hpage.getNewPassword().sendKeys("iTexico1+");
		hpage.getFormContainer().click();
		hpage.getSaveBtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Success! Data updated successfully.')]")));
		hpage.getCancelBtn().click();
		hpage.logoutMethod();
		lpage.loginAttorneyMethodNewPassword();
		hpage.returnPassword();
		lpage.loginAttorneyMethod();
	}
	
	public void returnPassword() throws IOException, InterruptedException {
		HeaderPage hpage = new HeaderPage(driver);
		Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		WebDriverWait wait = new WebDriverWait(driver,20);
		hpage.clickOnMyAccount();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CurrentPassword']")));
		hpage.getCurrentPassword().click();
		hpage.getCurrentPassword().sendKeys("iTexico1+");
		hpage.getNewPassword().click();
		hpage.getNewPassword().sendKeys(prop.getProperty("attorneyPassword"));
		hpage.getFormContainer().click();
		hpage.getSaveBtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Success! Data updated successfully.')]")));
		hpage.getCancelBtn().click();
		hpage.logoutMethod();
	}
	

}
