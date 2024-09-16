package activity6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	@Test
	@Parameters({"username","password"})
	public void test(String Uname,String pass)
	{
		System.out.println("Page Title is :"+driver.getTitle());
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String ConfirmationMsg=driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confirmation msg is :"+ConfirmationMsg);
		
		Assert.assertEquals(ConfirmationMsg, "Welcome Back, admin");
		
	}

}
