package project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity extends BaseClass{
	
	@Test(priority=1)
	public void verifyWebsiteTitle() {
		 // Check the title of the page
	    String title = driver.getTitle();
	    
	  //Assertion for page title
	    Assert.assertEquals("SuiteCRM", title);
	}
	
	@Test(priority=2)
	public void getUrl() {
		 // Check the url of the page
	    String url = driver.getCurrentUrl();
	    
	  //Print page url
	    System.out.println("URL is: "+url);;
	}
	
	@Test(priority=3)
	public void getCopyrightText() {
		 // Find copyright element text
		String copyright = driver.findElement(By.id("admin_options")).getText();
		
		//print copyright text
		System.out.println("Text in copyright in footer section: "+copyright);
		
	}
	
	@Test(priority=4)
	public void Login() throws InterruptedException {
		//expected home page url
		String expectedUrl = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
		
		//enter username and password
		WebElement userId = driver.findElement(By.id("user_name"));
		userId.sendKeys("admin");
		//userId.sendKeys("​pa$$w0rd");
		WebElement pwd = driver.findElement(By.id("username_password"));
		pwd.sendKeys("​pa$$w0rd");
		Thread.sleep(2000);
		
		//click on Login
		driver.findElement(By.id("bigbutton")).click();
		Thread.sleep(3000);
		
		//check home page is loaded
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl, expectedUrl);
	}
	
	@Test(priority=5)
	public void getColor(){
		
		//find navigation menu and get color
		WebElement navBar = driver.findElement(By.xpath("//div[@id='toolbar']"));
		String color = navBar.getCssValue("color");
		
		//print color of navigation menu
		System.out.println("Color of navigation menu: "+color);		
	}
	
	@Test(priority=6)
	public void menuChecking() {
		//check if Activities menu is displayed
		WebElement activities = driver.findElement(By.xpath("//a[text()='Activities']"));
		Assert.assertTrue(activities.isDisplayed(), "Activities menu present");
	}
	
	@Test(priority=7)
	public void readAdditionalInfo() throws InterruptedException {
		//click on sales menu
		driver.findElement(By.xpath("//a[text()='Sales']")).click();
		Thread.sleep(2000);
		//click on leads option
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(2000);
		//click on additional details icon
		driver.findElement(By.xpath("//span[@title='Additional Details'][1]")).click();
		Thread.sleep(2000);
		//get phone number and print it
		String phnNum = driver.findElement(By.xpath("//span[@class='phone']")).getText();
		System.out.println("Phone no. is: "+phnNum);
		//close additional information
		driver.findElement(By.xpath("//div[@aria-labelledBy='ui-id-6']//child::button[@title='Close']")).click();
	}
	
	@Test(priority=8)
	public void traversingTables1() throws InterruptedException {
		//click on sales menu
				driver.findElement(By.xpath("//a[text()='Sales']")).click();
				Thread.sleep(2000);
				//click on Accounts option
				driver.findElement(By.xpath("//a[text()='Accounts']")).click();
				Thread.sleep(2000);
				List<String> nameList = new ArrayList<String>();
				for(int i=1; i<5; i++) {
						String name = driver.findElement(By.xpath("//table[@class='list view table-responsive']//tr[@class='oddListRowS1']["+i+"]//td[4]")).getText();
						nameList.add(name);
				}
				
				System.out.println("1st 5 names in odd rows of Accounts table: ");
				System.out.println(nameList);
	}
	
	@Test(priority=9)
	public void traversingTables2() throws InterruptedException {
		//click on sales menu
		driver.findElement(By.xpath("//a[text()='Sales']")).click();
		Thread.sleep(2000);
		//click on leads option
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(2000);
		//print first 10 values of names column
		List<String> nameList = new ArrayList<String>();
		for(int i=3; i<13; i++) {
			String name = driver.findElement(By.xpath("//table[@class='list view table-responsive']//tr["+i+"]//td[3]//a")).getText();
			nameList.add(name);
		}
			
			System.out.println("1st 10 list of names in Leads table: ");
			System.out.println(nameList);
		
		//print first 10 users
		List<String> userList = new ArrayList<String>();
		for(int i=3; i<13; i++) {
			String user = driver.findElement(By.xpath("//table[@class='list view table-responsive']//tr["+i+"]//td[8]//a")).getText();
			userList.add(user);
		}
			System.out.println("1st 10 List of users in Leads table:");
			System.out.println(userList);
	}
}
