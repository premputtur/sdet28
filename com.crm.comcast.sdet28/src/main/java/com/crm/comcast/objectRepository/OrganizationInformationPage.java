package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * organization information POM class 
 * @author Premananda K
 *
 */

public class OrganizationInformationPage {
	//element initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// element identification or declaration
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement orgInfoText;
//getters method
public WebElement getOrgInfoText() {
	return orgInfoText;
}
/**
 * It will return the organization information text
 * @return
 */
public String getOrgInnformationText() {
	return orgInfoText.getText();
	
}
}
