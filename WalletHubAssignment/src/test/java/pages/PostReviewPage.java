package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import components.TestBase;

public class PostReviewPage extends BasePage {
  
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"scroller\"]/main/div[1]/nav/div[2]/a[2]/span[2]")
	private WebElement scrollToReview;

	@FindBy(xpath="//*[@id=\"reviews-section\"]/div[1]/div[3]//*[contains(@class,\"rvs-svg\")]//*[contains(@class,\"rating-box-wrapper\")]//*[name()=\"svg\" and contains(@class, \"rvs-star-svg\")][4]")
	private WebElement fourthStarClick;

	@FindBy(xpath="//*[@class='dropdown second']")
	private WebElement healthInsuranceDropdown;

	@FindBy(xpath="//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li")
	private WebElement selectDropDownValueAsHealthInsurance;

	@FindBy(xpath="//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/div[1]/textarea")
	private WebElement reviewText;

	@FindBy(className="//*[text()='Submit']")
	private WebElement submitButton;

	@FindBy(className="//*[text()='Test Insurance Company']")
	private WebElement verfiyReview;	
	
	public PostReviewPage(WebDriver driver) {
		super(driver);		
	}
	
	@Test
  public void AddReview() {

		try {
			driver.navigate().to("http://wallethub.com/profile/test_insurance_company/");
			Thread.sleep(2000);
			
			scrollToReview.click();
			Thread.sleep(2000);			
			
			//WebElement element = driver.findElement(By.xpath("//*[@id=\"reviews-section\"]/div[1]/div[3]//*[contains(@class,\"rvs-svg\")]//*[contains(@class,\"rating-box-wrapper\")]//*[name()=\"svg\" and contains(@class, \"rvs-star-svg\")][4]"));
			new Actions(driver).moveToElement(fourthStarClick).clickAndHold().build().perform();	
			fourthStarClick.click();		
			
			Thread.sleep(2000);
			healthInsuranceDropdown.click();	
			
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li"));
			for (WebElement option : options) {				
				Thread.sleep(1000);
			  if("Health Insurance".equals(option.getText()))
			    option.click();
			  	break;
			}
			
			Thread.sleep(2000);
			reviewText.sendKeys("Writing review by Selenium 3.0 Writing review by Selenium 3.0 Writing review by Selenium 3.0 Writing review by Selenium 3.0 Writing review by Selenium 3.0 Writing review by Selenium 3.0 Writing review by Selenium 3.0");
			
			Thread.sleep(2000);
			submitButton.click();		
			
			Thread.sleep(2000);			
			driver.navigate().to("https://wallethub.com/profile/");
			
			Thread.sleep(2000);	


		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}


	public boolean VerifyReviewAdded() {
		return verfiyReview.isDisplayed();
	}
}
