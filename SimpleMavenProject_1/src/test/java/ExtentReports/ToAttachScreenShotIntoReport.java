package ExtentReports;

//Assignment 


import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToAttachScreenShotIntoReport 
{
	@Test
	public void screenShot()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String photo = ts.getScreenshotAs(OutputType.BASE64);
				
		String time = LocalDateTime.now().toString().replace(":","-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Report/extentReport"+time+".html");
		ExtentReports extReport=new ExtentReports();
		extReport.attachReporter(spark);
		ExtentTest test = extReport.createTest("screenShot");
		test.log(Status.PASS,"Adding ScreenShot into report");
		test.addScreenCaptureFromBase64String(photo);
		extReport.flush();
		
	}
}


