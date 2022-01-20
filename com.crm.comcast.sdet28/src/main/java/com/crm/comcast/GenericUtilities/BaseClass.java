package com.crm.comcast.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * This Base class contains all the configure annotations
 * @author Premananda K
 *
 */

public class BaseClass {
	//object creation
	public WebDriver driver;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	
@BeforeSuite ()
	public void configBs() {
	//connection to the DB
	System.out.println("==== connection to database===");
	}
@Parameters("browser")
@BeforeClass ()
	//lanuch the browser
	public void configBc(String browser) throws Throwable {
	String browserName = fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	if(browser.equals("chrome")) {
		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
		driver=new ChromeDriver();
		}
	else if (browser.equals("firefox")) {
		System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
		driver=new FirefoxDriver();
		} 
		else{
			System.out.println("Browser not available");
		}
	driver.manage().window().maximize();
	driver.get(url);
	wUtil.waitForPageLoad(driver);
	}

@BeforeMethod ()
	
	public void configBm() throws Throwable {
	String username = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(username, password);
	}

@AfterMethod ()
	//logout the application
	public void configAm() {
	HomePage homepage = new HomePage(driver);
	homepage.logout();
	}

@AfterClass ()
	public void configAc() {
	//closing or quitting the browser
	driver.quit();
 	}

@AfterSuite ()
	public void configAs() {
	//connection to the DB
	System.out.println("==== closing the database===");
	}
}

