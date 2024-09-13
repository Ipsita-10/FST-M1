package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	// Declare the WebDriver object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();      
        
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        
        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void LoginTestCase() {
        String username = "admin";
        String password = "password";
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        
      //Get welcome message
	    String welcomeMsg = "";
	    welcomeMsg = driver.findElement(By.id("action-confirmation")).getText();      
        Assert.assertEquals(welcomeMsg, "Welcome Back, "+username);
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
