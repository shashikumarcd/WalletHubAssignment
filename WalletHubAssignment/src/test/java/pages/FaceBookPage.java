package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.ReadWriteExcel;

public class FaceBookPage extends BasePage {
	
	@FindBy(id="email")
	private WebElement emailText;

	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[@text()=\"What's on your mind, C D?\"]")
	private WebElement statusText;
	
	@FindBy(xpath="//*[text()='Post']")
	private WebElement postButton;	
	
  public FaceBookPage(WebDriver driver) {
		super(driver);		
	}

  String[] userDetails;

  public void FaceBookLogin() throws Exception {
	
	try {
		
		userDetails = ReadWriteExcel.ReadUserDetails(1);
		driver.get("https://www.facebook.com/");
		
		emailText.sendKeys(userDetails[0]);
		Thread.sleep(1000);
		
		password.sendKeys(userDetails[1]);
		Thread.sleep(1000);
		
		loginButton.click();
		Thread.sleep(1000);
		
		
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	
	
  }
 
  
  public void StatusPost() throws Exception {
		
		try {
						
			statusText.sendKeys("Hello World");
			Thread.sleep(1000);
			
			postButton.click();
			Thread.sleep(1000);			
						
			
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		
	  }

}
