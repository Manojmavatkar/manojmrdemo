package LoginDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageInfo {
	WebDriver driver;
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginBut = By.xpath("//input[@value=\"Login\"]");

	public LoginPageInfo(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Email_id() {
		
		return driver.findElement(emailid);
	}
	
	public WebElement Password() {
		
		return driver.findElement(password);
		
	}

	public WebElement LoginButton() {
		
		return driver.findElement(LoginBut);
	}
}
