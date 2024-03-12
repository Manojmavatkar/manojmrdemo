package PomProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginDetails.LoginPageInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void BeforeLoad() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverManager.chromedriver().setup();

	}

	@Test
	public void AfterLoad() throws IOException  {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		LoginPageInfo lp = new LoginPageInfo(driver);
		prop = new Properties();
		FileInputStream fis = new FileInputStream("PropertyFile");
		prop.load(fis);

		lp.Email_id().sendKeys(prop.getProperty("username"));
		lp.Password().sendKeys(prop.getProperty("password"));
		lp.LoginButton().click();
	}

	@AfterMethod
	public void Closure() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Code successfully executed");
		driver.quit();
	}

}
