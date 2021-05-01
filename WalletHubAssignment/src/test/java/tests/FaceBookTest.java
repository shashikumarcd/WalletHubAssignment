package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import components.TestBase;
import pages.FaceBookPage;

public class FaceBookTest extends TestBase{

	private WebDriver driver;	

	@Test(priority=1)
	public void FBookLogin() {

		try {

			FaceBookPage  faceBookPage = new FaceBookPage(driver); 
			faceBookPage.FaceBookLogin();

			System.out.println("Hello World");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test(priority=2)
	public void StatusPost() {

		try {

			FaceBookPage  faceBookPage = new FaceBookPage(driver); 
			faceBookPage.StatusPost();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
