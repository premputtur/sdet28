package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.IPathConstants;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;
/**Test Script to create organization
 * 
 * @author Premananda K
 *
 */
public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createOrg() throws Throwable {
		//create object for utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

// generate random number
int randomNumber = jUtil.getRandomNumber();

// get data from excel sheet
String ExpectedorganizationName = eUtil.getStringCellData("sheet1", 1, 2);
ExpectedorganizationName=ExpectedorganizationName+randomNumber;

HomePage homePage = new HomePage(driver);
homePage.clickOrganizationLink();

OrganizationPage orgPage = new OrganizationPage(driver);
orgPage.clickCreateorgImg();

CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
createOrgPage.createOrganization(ExpectedorganizationName);

OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
String actualOrgName = orgInfoPage.getOrgInnformationText();

//organization name verification
if(actualOrgName.contains(ExpectedorganizationName)) {
	System.out.println("Organization is created");
}else {
	System.out.println("organization is not created");
}
}
}
