
package LinkedIn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThankYouWish {
	static Robot robo;

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\drivers" + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		try {
			if (driver.findElement(By.className("nav__button-secondary")).isDisplayed() == true) {
				driver.findElement(By.className("nav__button-secondary")).click();
				try {
					if (driver.findElement(By.id("username")).isDisplayed() == true)

					{
						driver.findElement(By.id("username")).sendKeys("aks.testanalyst@gmail.com");
						driver.findElement(By.id("password")).sendKeys("Testos@123");
						driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button")).click();
					}
					else if (driver.findElement(By.className("session_key")).isDisplayed() == true) {
						driver.findElement(By.className("session_key")).sendKeys("aks.testanalyst@gmail.com");
						driver.findElement(By.className("session_password")).sendKeys("Testos@123");
						driver.findElement(By.xpath("/html/body/nav/section[2]/form/div[2]/button")).click();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (driver.findElement(By.id("login-submit")).isDisplayed() == true) {
				driver.findElement(By.id("login-email")).sendKeys("aks.testanalyst@gmail.com");
				driver.findElement(By.id("login-password")).sendKeys("Testos@123");
				driver.findElement(By.id("login-submit")).click();
			}

			else {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign in")));
				driver.findElement(By.linkText("Sign in")).click();
				driver.findElement(By.id("username")).sendKeys("aks.testanalyst@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Testos@123");
				driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button")).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// messaging-tab-icon
		driver.findElement(By.id("messaging-tab-icon")).click();

		// msg-conversation-card__content
		for (int i = 0; i < 500; i++) {

			if (driver.findElement(By.className("msg-conversation-card__content")).getText()
					.contains("Happy birthday")) {
				driver.findElement(By.className("msg-conversation-card__content")).click();

				if (driver.findElement(By.className("conversations-quick-replies__reply")).getText()
						.contains("Thank you")) {
					driver.findElement(By.className("conversations-quick-replies__reply")).click();
				} else {
					continue;
				}
			} else {
				driver.findElement(By.className("msg-conversation-card__content")).click();
				robo = new Robot();
				robo.keyPress(KeyEvent.VK_DOWN);
				robo.keyPress(KeyEvent.VK_DOWN);
				robo.keyRelease(KeyEvent.VK_DOWN);
				if (driver.findElement(By.className("msg-conversation-card__content")).getText()
						.contains("Happy birthday")) {
					driver.findElement(By.className("msg-conversation-card__content")).click();
				} else {
					robo.keyPress(KeyEvent.VK_DOWN);
					robo.keyRelease(KeyEvent.VK_DOWN);
					driver.findElement(By.className("msg-conversation-card__content")).click();
				}

			}
		}
	}

}
