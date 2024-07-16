package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {

	public static void main(String[] args) {
		// Setup the Firefox driver(GeckoDriver)
				WebDriverManager.firefoxdriver().setup();
				
				
				// Create a new instance of the Firefox driver
			    WebDriver driver = new FirefoxDriver();
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    
			 // Open the browser
			    driver.get("https://v1.training-support.net/selenium/ajax");
			    
			  //Get page title
			    System.out.println("Browser page title: "+driver.getTitle());
			    
			    WebElement changeContentBtn = driver.findElement(By.xpath("//button[text()='Change Content']"));
			    changeContentBtn.click();
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/child::h3")));
			    
			    WebElement delayedText = driver.findElement(By.xpath("//div[@id='ajax-content']/child::h3"));
			    
			    
			    System.out.println(delayedText.getText());		
			    
			    driver.quit();

	}

}
