package com.crm.comcast.GenericUtilities;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * It will wait 20seconds till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait till element is visible
	 */
public void waitForVisibilityOfElement(WebDriver driver,WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
	element.click();
}
/**
 * This method will wait till element to be clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClick(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();	
}
/**
 * This method is used to wait for the element and do click operation
 * @param element
 * @throws Throwable
 */
public void waitAndClick(WebElement element) throws Throwable {
	int count =0;
	while(count<50) {
		try {
			element.click();
		}
		catch(Throwable e)
		{
			Thread.sleep(1000);
			count++;
			
		}
	}
}
/**
 * This method will select the element based on index
 * @param element
 * @param index
 */
public void seelctOption(WebElement element , int index ) {
	Select select = new Select(element);
	select.selectByIndex(index);	
}
/**
 * Method is used to select the value based on the text
 * @param element
 * @param value
 */
public void selectOption(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByValue(value);
}
/**
 * This method will verify whether expected option is present in dropdown list or not
 * @param element
 * @param expectedOptions
 * @return
 */
public WebElement verifyTheDropDownList(WebElement element , String expectedOptions) {
	Select select = new Select(element);
	List<WebElement> options = select.getOptions();
	for (WebElement ele:options) {
		if(ele.equals(expectedOptions)) {
			System.out.println("value is present in Dropdown");
			return ele;
		}
		else {
			System.out.println("value is not present in Dropdown");
			return ele;
		}
	}
	return null;
}
/**
 * This method performs mouse hovering actions 
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
}
/**
 * this method perform right click action
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.contextClick(element).perform();
}
/**
 * This method is used to perform javascript click on webelement
 * @param driver
 * @param element
 */
public void jsClick(WebDriver driver,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click",element);
}
/**
 * This method is used to send the value using javascript executor
 * @param driver
 * @param valueToEnter
 * @param element
 */
public void enterDataUsingJs(WebDriver driver,String valueToEnter,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='"+valueToEnter+"'",element);
	
}
/**
 * this method will switch to different windows using partial title
 * @param driver
 * @param partialWindowTitle
 */
public void switchWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> winIds = driver.getWindowHandles();
	Iterator<String> it = winIds.iterator();
	while (it.hasNext()) {
		String winId = it.next();
		String title = driver.switchTo().window(winId).getTitle();
		if(title.contains(partialWindowTitle))
		{
			break;
		}
		
		}
	}
/**
 * This method is used to take screenshot in the case of failure
 * @param driver
 * @param testCaseName
 * @return
 */
public String screenShot(WebDriver driver,String testCaseName) {
	JavaUtility jUtil = new JavaUtility();
	String filePath="./errorshot"+testCaseName+jUtil.sysytemDateAndTime()+".png";
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File(filePath);
	source.renameTo(destination);
	return filePath;	
}
/**
 * This method will switch the frames based on the index passed
 * @param driver
 * @param index
 */
public void switchFrames(WebDriver driver, int index) {
	driver.switchTo().frame(index);
	
}
/**
 * This method will switch the frames based on the nameor id passed
 * @param driver
 * @param nameOrId
 */
public void switchFrames(WebDriver driver, String nameOrId) {
	driver.switchTo().frame(nameOrId);
}
/**
 * This method is used to based on the webelement passed
 * @param driver
 * @param element
 */
public void switchFrames(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);	
}
/**
 * This method will accept the alert
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This method will dissmiss in alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
}
		
	

