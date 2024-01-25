package washitup.Adminmodule;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.LoginPage;
import genericutility.FileUtility;
import genericutility.IConstants;
import genericutility.JavaUtility;
import genericutility.WebDriverUtility;

public class AddNewVendor {
	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriverUtility utility = new WebDriverUtility();
		FileUtility fileutility = new FileUtility();
		JavaUtility javautility = new JavaUtility();

		// initialize the data from property file
		fileutility.InitializePropertyFile(IConstants.PROPERTYPATH);

		String browser = fileutility.getDatafromPropertyFile("browser");
		String url = fileutility.getDatafromPropertyFile("url");
		String username = fileutility.getDatafromPropertyFile("username");
		String password = fileutility.getDatafromPropertyFile("password");
		String time = fileutility.getDatafromPropertyFile("timeouts");
		long timeouts = javautility.ConvertStringToLong(time);

		// launching the browser in the run time based on browser key
		WebDriver driver = utility.setUpDriver(browser);
		utility.geturl(url);
		utility.MaximizeBrowser();
		utility.WaitImplicitly(timeouts);

		LoginPage login = new LoginPage(driver);
		login.PerfomLogin(username, password);
		login.submitLogin();

		driver.findElement(By.xpath("//div[@class='each-section-2']/child::h5[contains(text(),'Vendors')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='assign-vendor']")).click();

		WebElement venname = driver.findElement(
				By.xpath("//input[@class='add-customer-input-box2' and @placeholder='Enter Vendor Name']"));

		venname.sendKeys("Automation1");

		WebElement primarypn = driver
				.findElement(By.xpath("//input[@class='PhoneInputInput' and @placeholder='Enter Phone number']"));
		primarypn.sendKeys("9849226081");

		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("automation@gmail.com");

		WebElement shopname = driver
				.findElement(By.xpath("//input[@class='add-customer-input-box2' and @placeholder='Enter Shop Name']"));
		shopname.sendKeys("AutomationSHOP");

		WebElement shopaddress = driver.findElement(
				By.xpath("//textarea[@class='add-customer-input-box2' and @placeholder='Enter Shop Address']"));
		shopaddress.sendKeys("Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum ");

		WebElement secphno = driver.findElement(
				By.xpath("//input[@class='PhoneInputInput' and @placeholder='Enter Secondary Phone number']"));
		secphno.sendKeys("9849226082");

		WebElement venloc = driver.findElement(
				By.xpath("//input[@class='add-customer-input-box2' and @placeholder='Enter Vendor Location']"));
		venloc.sendKeys("Automation-VIZAG");

		WebElement pincode = driver.findElement(
				By.xpath("//input[@class='add-customer-input-box2' and @placeholder='Enter Vendor PINCODE']"));
		pincode.sendKeys("515671");

		driver.findElement(By.xpath("//button[@class='add-cutomer-button']")).click();

	}
}
