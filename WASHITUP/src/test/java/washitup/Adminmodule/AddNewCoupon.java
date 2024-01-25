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

public class AddNewCoupon {
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

		WebElement couponcategory = driver
				.findElement(By.xpath("// div[@class='each-section-2']/child::h5[contains(text(),'Coupons')]"));
		couponcategory.click();

		WebElement clickonaddnewcoupon = driver.findElement(By.xpath("//button[@class='assign-vendor']"));
		clickonaddnewcoupon.click();

		WebElement entercouponcode = driver.findElement(By.xpath("//input[@placeholder='Enter Coupon Code']"));
		entercouponcode.sendKeys("AutomationWashitup");

		WebElement enterdiscount = driver.findElement(By.xpath("//input[@placeholder='Enter Discount']"));
		enterdiscount.sendKeys("5000");

		WebElement enterminprice = driver.findElement(By.xpath("//input[@placeholder='Enter Minimum Price']"));
		enterminprice.sendKeys("50000");

//		WebElement cancelbtn = driver.findElement(By.xpath("//button[text()='Cancel']"));
//		cancelbtn.click();

		WebElement addbtn = driver.findElement(By.xpath("//button[text()='Add']"));
		addbtn.click();

	}
}
