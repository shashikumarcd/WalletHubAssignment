package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setUP() throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}

}
