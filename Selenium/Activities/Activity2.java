package activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	public static void main(String[] args) {
		// Setup the Firefox driver(GeckoDriver)
				WebDriverManager.firefoxdriver().setup();
				
				// Create a new instance of the Firefox driver
			    WebDriver driver = new FirefoxDriver();
			    
			 // Open the browser
			    driver.get("https://v1.training-support.net/selenium/login-form");
			    
			  //Get page title
			    System.out.println("Browser page title: "+driver.getTitle());
			    
			   //Enter username
			    String username = "admin";
			    driver.findElement(By.id("username")).sendKeys(username);
			    
			  //Enter password
			    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
			    
			  //Click on login
			    driver.findElement(By.xpath("//button[text()='Log in']")).click();
			    
			  //Get welcome message
			    String welcomeMsg = "";
			    welcomeMsg = driver.findElement(By.id("action-confirmation")).getText();
			    if (welcomeMsg.equals("Welcome Back, "+username)){
			    	
			    	System.out.println("Welcome message shown as expected: " +welcomeMsg);
			    }
			    
			    
			    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    File saveScreenshot = new File("src/test/resources/screenshot.png");
			    try {
					FileUtils.copyFile(screenshot, saveScreenshot);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    driver.quit();

	}

}
