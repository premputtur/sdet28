package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * CreateOrganizationPage POM design
 * @author Premananda K
 *
 */

public class CreateOrganizationPage {
	//element initialization
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// element identification and declare 
	@FindBy (name ="accountname")
	private WebElement organizationTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
// getter method
	public WebElement getOrganizationField() {
		return getOrganizationField();
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method will create an organization
	 * @param orgName
	 */
	public void createOrganization(String orgName) {
		
	organizationTextField.sendKeys(orgName);
	saveButton.click();
		
	}
	

}
