package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;
/**
 * HomePage POM design
 * @author Premananda K
 *
 */
public class HomePage extends WebDriverUtility{
	//initialization of element
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//declaration of element
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Organizations")
	private WebElement contactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	//getter method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	//business logics
	/**
	 * this method will click on organization link
	 */
	
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	/**
	 * this method will perfrom logout action+66
	 */
		public void logout() {
			mouseHover (driver,logoutImg);
			signoutLink.click();
		}
	}
	


