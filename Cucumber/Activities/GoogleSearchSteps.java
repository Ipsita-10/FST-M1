package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps{
	WebDriver driver;
	WebDriverWait wait;
	@Given("User is on Google Home Page")
	public void setUp() throws Throwable{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.google.com/");
	}
	
	@When("User types in Cheese and hits ENTER")
	public void searchElement() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("cheese");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@Then("Show how many search results were shown")
	public void showSearchResults() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='result-stats']")));
		String resultCount = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
		System.out.println("Search results: "+resultCount);
	}
	
	@And("Close the browser")
	public void closeBrowser() {
		driver.quit();
	}
}
