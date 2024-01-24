package washitup.Adminmodule;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import ObjectRepository.LoginPage;
import genericutility.FileUtility;
import genericutility.IConstants;
import genericutility.JavaUtility;
import genericutility.WebDriverUtility;

public class Login {

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

		/*
		 * driver.findElement(By.xpath(
		 * "//div[@class='each-section-2']/child::h5[contains(text(),'Services')]")).
		 * click();
		 * 
		 * driver.findElement( By.
		 * xpath("//div[@class='order-summary-head']/child::button[contains(text(),'Add New Item')]"
		 * )).click();
		 * 
		 * // driver.findElement(By.xpath("//input[@id='image']")).
		 * sendKeys("/WASHITUP/src/test/resources/Cartoon Dress.jpg");
		 * 
		 * 
		 * JavascriptExecutor j = (JavascriptExecutor) driver; WebElement click =
		 * driver.findElement(By.xpath("//input[@id='image']"));
		 * j.executeScript("arguments[0].click();", click);
		 * 
		 * Robot robot = new Robot(); robot.delay(2000); StringSelection stringselection
		 * = new StringSelection("C:\\Users\\Vamshi\\Downloads\\Cartoon Dress.jpg");
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,
		 * null); robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * 
		 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_V);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER); //
		 * utility.QuitBrowser();
		 * 
		 */

		/*
		 * WebElement element = driver.findElement(By.xpath(“//table[@id =
		 * ‘tableID’]/tbody//tr[last()]”)); JavascriptExecutor js = (JavascriptExecutor)
		 * driver; js.executeScript(“arguments[0].scrollIntoView();”, element);
		 * 
		 * Thread.sleep(2000);
		 */
		driver.close();
	}
}
