import java.time.Duration;

// Assignment 56

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLearnMavenParameterTest {
	@Test
	public void mavenParameter() {
		String URL = System.getProperty("url");
		String EMAIL = System.getProperty("email");
		String PASSWORD = System.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(URL);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(EMAIL);;
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);;
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop","HomePage is not displayed");
		Reporter.log("Homepage is Displayed",true);
		
		
	
	}

}
