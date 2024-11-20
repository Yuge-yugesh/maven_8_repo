package JenkinsparameterTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class JenkisParameterTest {
	@Test
	public void recieveParameter() {
		String value = System.getProperty("browser");
		Reporter.log(value,true);
	}
}
