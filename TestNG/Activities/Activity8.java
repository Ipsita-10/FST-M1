package activity9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
	WebDriver driver;
	Alert alert;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("Page Title is :"+driver.getTitle());
		Reporter.log("Page launched");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		Reporter.log("Before method is executing");
		driver.switchTo().defaultContent();
	}

	@Test(priority=0)
	public void simpleAlertTestCase()
	{
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert opned!");
		Alert simpleAlert =driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");

		//get the text of alert
		String alertText = simpleAlert.getText();
		Reporter.log("Alert text is: " + alertText + " |");

		//Assertation
		Assert.assertEquals("This is a JavaScript Alert!", alertText);

		simpleAlert.accept();
		Reporter.log("Alert closed");
		Reporter.log("simpleAlertTestCase ended |");

	}

	@Test(priority = 1)
	public void confirmAlertTestCase()
	{
		
		driver.findElement(By.id("confirm")).click();
		Reporter.log("Confirmation Alert Opened");
		
		Alert confirmAlert=driver.switchTo().alert();
		String alertText1 = confirmAlert.getText();
		Reporter.log("Confirmation Alert Text is : "+alertText1);
		
		Assert.assertEquals(alertText1, "This is a JavaScript Confirmation!");
		confirmAlert.dismiss();
		Reporter.log("Confirmation alert cancelled");
		Reporter.log("confirmAlertTestCase Ended");
		
	}

	@Test(priority = 2)
	public void promptAlertTestCase()
	{
		driver.findElement(By.id("prompt")).click();
		Reporter.log("Prompt Alert Opened");
		
		Alert promptAlert=driver.switchTo().alert();
		String alertText2 = promptAlert.getText();
		
		Reporter.log("Prompt Alert Text is : "+alertText2);
		Assert.assertEquals(alertText2, "This is a JavaScript Prompt!");
		
		promptAlert.sendKeys("Create Reporter Log tcs");
		promptAlert.accept();
		Reporter.log("Prompt Alert Accepted");
		Reporter.log("promptAlertTestCase Ended");

	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}


}
