package washitup.Adminmodule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.washitup.in/adminlogin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("washitup@admin.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("WashIt_Up@24");
		driver.findElement(By.xpath("//button[@type='button']")).click();

		driver.findElement(By.xpath("//div[@class='each-section-2']/child::h5[contains(text(),'Vendors')]")).click();
		Thread.sleep(3000);

		String vendormn = "7780451154";
		WebElement venmno = driver.findElement(By.xpath(
				"//div[@class='order-body-header2']/child::p[@class='order-body-para' and text()=" + vendormn + "]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", venmno);
		Thread.sleep(3000);
		venmno.click();

		List<WebElement> orderscount = driver
				.findElements(By.xpath("//div[@class='order-body-header1']/following-sibling::div"));
		int totalorders = orderscount.size();
		System.out.println("TOTAL NO OF ORDERS    :  " + totalorders);

		Thread.sleep(5000);
		int n = totalorders;
		for (int j = 0; j < n; j++) {

			for (int i = 0; i < 5; i++) {

				WebElement elements = driver
						.findElement(By.xpath("//div[@class='order-body-header1']/following-sibling::div[" + (j + 1)
								+ "]/child::p[" + (i + 1) + "]"));
				System.out.print(elements.getText() + "   ");
			}

			System.out.println();
//			System.out.println();
		}

	}
}
