package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import components.ReadWriteExcel;

public class LoginPage extends BasePage{

	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginTab;

	@FindBy(name="em")
	private WebElement emailText;

	@FindBy(name="pw1")
	private WebElement password;

	@FindBy(className="btns")
	private WebElement loginButton;

	String[] userDetails;
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}

	@Test
	public void Login() throws Exception {

		try {
			
			userDetails = ReadWriteExcel.ReadUserDetails(1);
			driver.get("https://wallethub.com/join/light");

			Thread.sleep(2000);
			loginTab.click();

			emailText.sendKeys(userDetails[0]);
			Thread.sleep(2000);

			password.sendKeys(userDetails[1]);
			Thread.sleep(2000);

			loginButton.click();
			Thread.sleep(2000);


		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}	
}
