package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity6 extends Base {

    @Given("user is on ToDo list page")
    public void navigateToPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/todo-list");
    }

    @When("User enters the following tasks")
    public void inputTasks(DataTable inputTasks) {
        List<String> tasks = inputTasks.asList();
        driver.findElement(By.xpath("//div[@class = 'ui red bottom attached button']")).click();
        for (String task : tasks) {
            driver.findElement(By.id("taskInput")).sendKeys(task);
            driver.findElement(By.xpath("//button[@class = 'ui blue button']")).click();
        }
    }

    @Then("tasks are added")
    public void verifyResults() {
        List<WebElement> ele = driver.findElements(By.xpath("//div[@id = 'tasksList']/div"));
        Assert.assertEquals(3, ele.size());
    }
}
