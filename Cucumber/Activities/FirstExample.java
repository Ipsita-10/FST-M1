package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstExample extends BaseClass{

	@BeforeAll
	public static void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	
	@Given("the user is on TS homepage")
	public void openHomePage() {
		driver.get("https://v1.training-support.net/");
		String pageTitle = driver.getTitle();
		Assertions.assertEquals("Training Support", pageTitle);
	}
	
	@When("the user clicks on the about us link")
	public void clickOnAboutUs() {
		driver.findElement(By.id("about-link")).click();
	}
	
	@Then("the user is redirected to the about page")
	public void getAboutPageInfo() {
		Assertions.assertEquals("About Training Support", driver.getTitle());		
	}
}

