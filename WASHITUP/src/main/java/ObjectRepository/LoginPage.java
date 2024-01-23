package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailtxfield;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordtxfield;

	@FindBy(xpath = " //button[@type='button']")
	private WebElement loginbutton;

	public void PerfomLogin(String username, String password) {
		emailtxfield.sendKeys(username);
		passwordtxfield.sendKeys(password);
	}

	public void submitLogin() {
		loginbutton.click();
	}

}
