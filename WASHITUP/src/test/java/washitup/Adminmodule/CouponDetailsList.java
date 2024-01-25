package washitup.Adminmodule;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.LoginPage;
import genericutility.FileUtility;
import genericutility.IConstants;
import genericutility.JavaUtility;
import genericutility.WebDriverUtility;

public class CouponDetailsList {
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

		List<WebElement> couponscount = driver
				.findElements(By.xpath("//div[@class='order-body-header1']/following-sibling::div"));
		int Totalcoupons = couponscount.size();
		System.out.println("TOTAL NO OF COUPONS PRESENT --->  : " + Totalcoupons);

		// String couponprice = "'WASHITUP5000'";
		// "+ "WASHITUP5000" + "
		int n = Totalcoupons;
		// String[][] str = new String[n][6];
		Thread.sleep(5000);
		for (int j = 0; j < n; j++) {
			Thread.sleep(1000);

			for (int i = 0; i < 5; i++) {
				WebElement elements = driver
						.findElement(By.xpath("//div[@class='order-body-header1']/following-sibling::div[" + (j + 1)
								+ "]/child::p[" + (i + 1) + "]"));
				System.out.print(elements.getText() + "   ");

			}
			System.out.println();
		}
		Thread.sleep(2000);

		WebElement active = driver.findElement(By.xpath(
				"//div[@class='order-body-header1']/following-sibling::div/child::p[text()='WASHITUP5000']/following-sibling::select"));
		Select select = new Select(active);
		select.selectByVisibleText("Inactive");
	}
}

//div[@class='order-body-header1']/following-sibling::div/child::p[text()='WASHIT5000']/following-sibling::div
//div[@class='order-body-header1']/following-sibling::div/child::p[text()="WASHITUP5000"]/following-sibling::div
//div[@class='order-body-header1']/following-sibling::div["+(j+1)+"]/child::p[contains(text(),+'couponprice'+)]/following-sibling::div
//p[text()="WASHIT5000"]/following-sibling::div
