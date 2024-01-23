package washitup.Adminmodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DashBoard {
	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.washitup.in/adminlogin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("washitup@admin.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("WashIt_Up@24");
		driver.findElement(By.xpath("//button[@type='button']")).click();

		String totalsalesRevenue = driver.findElement(By
				.xpath("//div[@class='total-orders-card']/child::h5[.='Total Sales']/following-sibling::div/child::h4"))
				.getText();
		System.out.println("TotalSales+Revenue----->" + totalsalesRevenue);

		String totalitems = driver.findElement(By
				.xpath("//div[@class='total-orders-card']/child::h5[.='Total Items']/following-sibling::div/child::h4"))
				.getText();
		System.out.println("TotalItems----->" + totalitems);

		String totalcustomers = driver.findElement(By.xpath(
				"//div[@class='total-orders-card']/child::h5[.='Total Customers']/following-sibling::div/child::h4"))
				.getText();
		System.out.println("TotalCustomers----->" + totalcustomers);

		String totalvendors = driver.findElement(By.xpath(
				"//div[@class='total-orders-card']/child::h5[.='Total Vendors']/following-sibling::div/child::h4"))
				.getText();
		System.out.println("TotalVendors----->" + totalvendors);

		String totaldrivers = driver.findElement(By.xpath(
				"//div[@class='total-orders-card']/child::h5[.='Total Drivers']/following-sibling::div/child::h4"))
				.getText();
		System.out.println("Totaldrivers----->" + totaldrivers);

		String totalorders = driver.findElement(By.xpath(
				"//div[@class='total-orders-card']/child::h5[.='Total Orders']/following-sibling::div/descendant::h4"))
				.getText();
		System.out.println("Totalorders----->" + totalorders);

		String active = driver
				.findElement(By.xpath("//div[@class='active-orders']/child::p[.='Active']/following-sibling::p"))
				.getText();
		System.out.println("Active orders----->" + active);

		String completedorders = driver
				.findElement(By.xpath("//div[@class='active-orders']/child::p[.='Completed']/following-sibling::p"))
				.getText();
		System.out.println("Completed Orders----->" + completedorders);

		WebElement Logout = driver
				.findElement(By.xpath("//button[@class='header-select-button' and text()='Log Out']"));
		Logout.click();

		driver.quit();

		// dashboard=driver.findElement(By.xpath("//section[@class='section-in-aside-dashboard']/descendant::h5[.='Dashboard']"))
		// .click();

		// orders=driver.findElement(By.xpath("//h5[.='Orders']")).click();

		/*
		 * String mn = "7780451154";
		 * 
		 * driver.findElement(By.xpath(
		 * "//div[@class='each-section-2']/child::h5[contains(text(),'Vendors')]")).
		 * click(); Thread.sleep(3000); WebElement name = driver.findElement(By
		 * .xpath("//div[@class='order-body-header2']/child::p[@class='order-body-para' and text()="
		 * + mn + "]")); name.click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//button[@id='cal']")).click();
		 */

		/*
		 * String targetdate = "05/jan/2024";
		 * 
		 * 
		 * Calendar calendar = Calendar.getInstance();
		 * 
		 * try { SimpleDateFormat targetDateFormat = new
		 * SimpleDateFormat("dd/MMM/yyyy"); targetDateFormat.setLenient(false); Date
		 * formattedTargetDate = targetDateFormat.parse(targetdate);
		 * calendar.setTime(formattedTargetDate); } catch (ParseException e) { throw new
		 * Exception("invalid date you have provided, please enter a valid date"); } int
		 * targetMonth = calendar.get(Calendar.MONTH); int targetYear =
		 * calendar.get(Calendar.YEAR);
		 */
	}
}
