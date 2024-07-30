import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


@pytest.fixture(scope="session")
def setup_driver(request):
     # Initialize the webdriver
    driver = webdriver.Firefox()
    
    # Get the underlying collection
    session = request.node
    
    # Pass through the driver to the test class
    for item in session.items:
        cls = item.getparent(pytest.Class)
        setattr(cls.obj,"driver",driver)

    driver.get('http://alchemy.hguy.co/crm')  
    # Execute the test method
    yield
    
    # Close the browser once the test has ended
    request.addfinalizer(driver.close)
    

@pytest.mark.usefixtures("setup_driver")
class Test_ProjectActivity:
    @pytest.mark.run(order=1)
    def test_activity1(self):
        # get the title of the page
        assert self.driver.title == 'SuiteCRM'


    @pytest.mark.run(order=2)
    def test_activity2(self):
        url = self.driver.current_url
        print(f"Current URL is: {url}")

    @pytest.mark.run(order=3)
    def test_activity3(self):
        copyright = self.driver.find_element(By.ID, "admin_options").text
       # print(f"Text in copyright in footer section: {copyright}")
        print(copyright)

    @pytest.mark.run(order=4)
    def test_activity4(self):
        expectedUrl = 'https://alchemy.hguy.co/crm/index.php?module=Home&action=index'
        userId = self.driver.find_element(By.ID, "user_name")
        userId.send_keys("admin")
        pwd = self.driver.find_element(By.ID, "username_password")
        pwd.send_keys('pa$$w0rd')
        time.sleep(2)

        # click on Login
        self.driver.find_element(By.ID, "bigbutton").click()
        time.sleep(2)
                   
         #check home page is loaded
        homePageUrl = self.driver.current_url
        assert homePageUrl == expectedUrl


    @pytest.mark.run(order=5)
    def test_activity5(self):
        navBar = self.driver.find_element(By.XPATH, "//div[@id='toolbar']")
        color = navBar.value_of_css_property('color')
        print(f"Color of navigation menu: {color}")

    @pytest.mark.run(order=6)
    def test_activity6(self):
        if (self.driver.find_element(By.XPATH, "//a[text()='Activities']")):
            assert True
        

    @pytest.mark.run(order=7)
    def test_activity7(self):
        #click on sales menu
        self.driver.find_element(By.XPATH, "//a[text()='Sales']").click()
        time.sleep(2)
		#click on leads option
        self.driver.find_element(By.XPATH, "//a[text()='Leads']").click()
        time.sleep(5)
		#click on additional details icon
        self.driver.find_element(By.XPATH, "//span[@title='Additional Details'][1]").click()
        time.sleep(2)
		#get phone number and print it
        phnNum = self.driver.find_element(By.XPATH, "//span[@class='phone']").text
        print(f"Phone no. is: {phnNum}")
		#close additional information
        self.driver.find_element(By.XPATH, "//div[@aria-labelledBy='ui-id-6']//child::button[@title='Close']").click()


    @pytest.mark.run(order=8)
    def test_activity8(self):
        self.driver.find_element(By.XPATH, "//a[text()='Sales']").click()
        time.sleep(2)
		#click on Accounts option
        self.driver.find_element(By.XPATH, "//a[text()='Accounts']").click()
        time.sleep(2)
        nameList = []
        for i in nameList:
            name = self.driver.find_element(By.XPATH, "//table[@class='list view table-responsive']//tr[@class='oddListRowS1']["+i+"]//td[4]").text
            nameList.add(name)
        print("1st 5 names in odd rows of Accounts table: ")
        print(nameList)


    @pytest.mark.run(order=9)
    def test_activity9(self):
        self.driver.find_element(By.XPATH, "//a[text()='Sales']").click()
        time.sleep(2)
		#click on leads option
        self.driver.find_element(By.XPATH, "//a[text()='Leads']").click()
        time.sleep(2)
		#print first 10 values of names column
        nameList = []
        for i in nameList: 
            name = self.driver.find_element(By.XPATH, "//table[@class='list view table-responsive']//tr["+i+"]//td[3]//a").text
            nameList.add(name)
		
        print("1st 10 list of names in Leads table: ")
        print(nameList)
		
		#print first 10 users
        userList = []		
        for i in userList:
            user = self.driver.find_element(By.XPATH, "//table[@class='list view table-responsive']//tr["+i+"]//td[8]//a").text
            userList.add(user)
        print("1st 10 List of users in Leads table:")
        print(userList)
     
