package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	WebDriver driver;
	
	@Given("^Open FF and Launch URL$")
	public void Open_FF_and_Launch_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.facebook.com/");
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		System.out.println("Maximized Window");
	}

	@When("^I entered \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_entered_username_and_password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
		System.out.println("Entered Username");
		driver.findElement(By.id("pass")).sendKeys(arg2);
		System.out.println("Entered Password");
	}

	@Then("^User should be able to login successfully$")
	public void User_should_be_able_to_login_successfully() throws Throwable {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		System.out.println("Clicked on Signin buttom");
		driver.quit();
		System.out.println("Closed window");
	}
}
