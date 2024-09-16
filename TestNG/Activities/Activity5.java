package activity5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
	
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");	
	}
	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	@Test(groups = {"HeaderTests", "ButtonTests"})
	public void pageTitle()
	{
		String titleString=driver.getTitle();
		System.out.println("page title is :"+titleString); 
		Assert.assertEquals(titleString, "Target Practice");
	}
	
	@Test(dependsOnMethods = {"pageTitle"}, groups = "HeaderTests")
	public void HeaderTest1()
	{
		String thirdString=driver.findElement(By.id("third-header")).getText();
		Assert.assertEquals(thirdString,"Third header");
		
	}
	@Test(dependsOnMethods = {"pageTitle"},groups = "HeaderTests")
	public void HeaderTest2()
	{
		WebElement header5 = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(33, 186, 69)");
	}
   
	@Test(dependsOnMethods = {"pageTitle"},groups="ButtonTests")
	public void buttonTest1()
	{
		String buttonText= driver.findElement(By.xpath("//button[text()='Olive']")).getText();
		System.out.println("Button Text is :"+buttonText);
		Assert.assertEquals(buttonText, "Olive");
	}

	@Test(dependsOnMethods = {"pageTitle"},groups="ButtonTests")
	public void buttonTest2()
	{
		WebElement button= driver.findElement(By.xpath("//button[text()=\"Brown\"]"));
		
		Assert.assertEquals(button.getCssValue("color"), "rgb(255, 255, 255)");
	}
	
}
