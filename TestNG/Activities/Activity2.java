package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	// Declare the WebDriver object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
            //Assertion for page title
        Assert.assertEquals("Target Practice", title);
        
    }
    
    @Test
    public void findButton() {                 
        //Find the black button on the page
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertEquals(blackButton.getText(), "Black");
    }
    
    @Test(enabled = false)
    public void demoSkip1() {
    	System.out.println("This method will be skipped");
    }
    
    @Test
    public void demoSkip2() {
    	throw new SkipException("Skipping this test case");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
