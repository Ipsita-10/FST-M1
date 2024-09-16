package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6_DataTable {
	static WebDriver driver;
	static WebDriverWait wait;

		@Given("User completes the requirement")
		public void completeRequirement() {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Given completed");
		}

		@When("User enters the following username and password")
		public void user_enters_and(DataTable credentials) {
			List<List<String>> creds = credentials.asLists();
			for (List<String> cred : creds) {
				for (String credential : cred) {
					System.out.println(credential);
				}
			}
			System.out.println(creds);
		}

		@When("User enters the following tasks")
		public void inputTasks(DataTable inputTasks) {
			driver.get("https://v1.training-support.net/selenium/todo-list");
			List<String> tasks = inputTasks.asList();
			System.out.println(tasks);

			for(String task : tasks) {
				driver.findElement(By.id("taskInput")).sendKeys(task);
				driver.findElement(By.xpath("//button[text()='Add Task']")).click();
			}
		}

		@Then("Verify results")
		public void verifyResults() {
			System.out.println("Verification complete");
		}
	}


