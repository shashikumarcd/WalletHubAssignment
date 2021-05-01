package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.TestBase;
import pages.LoginPage;
import pages.PostReviewPage;

public class PostReviewTest extends TestBase{

	LoginPage loginPage;
	PostReviewPage postReviewPage;
	
	public WebDriver driver;
	@Test
	public void ValidLogin() {
		try {
			
			loginPage = new LoginPage(driver);		
			loginPage.Login();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	public void AddReview() {

		postReviewPage = new PostReviewPage(driver);		
		postReviewPage.AddReview();
		
		Assert.assertTrue(postReviewPage.VerifyReviewAdded());

	}


}
