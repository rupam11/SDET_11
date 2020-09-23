package StepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDef {

	WebDriver driver;
	//
	@Before
	public void runB4() {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/KumariRupam/eclipse-workspace/SDET/MvnProj/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
	}
	

		@Given("I am able to navigate onto the login page")
		public void i_am_able_to_navigate_onto_the_login_page() {
			driver.get("https://opensource-demo.orangehrmlive.com");
		}
		@When("I enter the username as {string}")
		public void i_enter_the_username_as(String userNm) {
			driver.findElement(By.id("txtUsername")).sendKeys(userNm);
			
		}
		@When("I Enter teh password is {string}")
		public void i_enter_teh_password_is(String pwd) {
			driver.findElement(By.id("txtPassword")).sendKeys(pwd);
			
		}
		@When("I click on submit button")
		public void i_click_on_submit_button() {
			driver.findElement(By.id("btnLogin")).click();
		}
		@Then("I should see the username as {string}")
		public void i_should_see_the_username_as(String expRes) {
			String act = driver.findElement(By.id("welcome")).getText();
			Assert.assertEquals(expRes, act);
			//driver.close();			
		}
		
		@Then("I should see the error message {string}")
			public void i_should_see_the_error_message(String expRes) {
			String act = driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
			Assert.assertEquals(expRes, act);
		}
		
		@Then("Do logout")
		public void do_logout() throws InterruptedException {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='welcome']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		}






		@After
		public void afterRun() throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
		}

}
