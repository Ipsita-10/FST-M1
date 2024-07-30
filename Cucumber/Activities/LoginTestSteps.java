package stepDefinitions;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps extends BaseClass{
	
	@Given("User is on Login page")
	public void loginSetUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://v1.training-support.net/selenium/login-form");
	}
	
	@When("User enters username and password")
	public void userLogin() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@When("User enters {string} and {string}")
	public void userLogin(String username, String password) {
		WebElement user = driver.findElement(By.id("username"));
		user.clear();
		user.sendKeys(username);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@Then("Read the page title and confirmation message")
	public void verifyConfirmationMessage() {
		System.out.println(driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
		String welcomeMessage = driver.findElement(By.id("action-confirmation")).getText();
		Assertions.assertEquals(welcomeMessage, "Welcome Back, admin");
	}
	
	@Then("Read the page title and verify confirmation message as {string}")
	public void verifyConfirmationMessage(String expMessage) {
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
		String welcomeMessage = driver.findElement(By.id("action-confirmation")).getText();
		Assertions.assertEquals(welcomeMessage, expMessage);
	}
	
	@And("Close the Browser")
	public void closeBrowser() {
		driver.quit();
	}
}
