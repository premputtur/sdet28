package getTheProductDetails;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewProductAndAddDescriptionTest {

	public static void main(String[] args) throws IOException {
		// 
				FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
				Properties property = new Properties();
				property.load(fis);
				String browser = property.getProperty("browser");
				String url = property.getProperty("url");
				String username = property.getProperty("username");
				String password = property.getProperty("password");
				// read the data from excel sheet
				 FileInputStream fis1 = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
				 Workbook workbook = WorkbookFactory.create(fis1);
				 Sheet sheet = workbook.getSheet("Sheet1");
					Row row = sheet.getRow(2);
					Cell cell = row.getCell(3);
					String ProductName = cell.getStringCellValue();
					System.out.println(ProductName);
					workbook.close();
					
					// launch the browser
					WebDriver driver = null;
					if(browser.equals("chrome")) {

						System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
						driver=new ChromeDriver();
					}else if (browser.equals("firefox")) {
						
						System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
						driver=new FirefoxDriver();
					}
					else {
						System.out.println("browser is not supported");
						
					}
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					driver.get(url);
					driver.findElement(By.name("user_name")).sendKeys(username);
					driver.findElement(By.name("user_password")).sendKeys(password);
					driver.findElement(By.id("submitButton")).click();
					driver.findElement(By.linkText("Products")).click();
					driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
					driver.findElement(By.name("productname")).sendKeys("Nokia");
					driver.findElement(By.name("description")).sendKeys("sbdscdbcsbdc");
					driver.findElement(By.name("button")).click();
					String actualProductName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
					if(actualProductName.contains("Nokia")) {
						System.out.println("ProductName is created");
					}
					else {
						System.out.println("ProductName is not created");
					}
					WebElement proImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					Actions action = new Actions(driver);
					action.moveToElement(proImage).perform();
					driver.findElement(By.linkText("Sign Out")).click();
					driver.quit();

	}

}
