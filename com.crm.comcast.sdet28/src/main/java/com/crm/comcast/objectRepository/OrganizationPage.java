package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * organizationPage POM design
 * @author Premananda K
 *
 */
public class OrganizationPage {
	//element initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//element identification or declaration
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createorgPlusImage;
//getters method
public WebElement getCreateorgPlusImage() {
	return createorgPlusImage;
}
// business logic
/**
 * This method will click on createOrg plusImage
 */
public void clickCreateorgImg() {
	createorgPlusImage.click();
}
}