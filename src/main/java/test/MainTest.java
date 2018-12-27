package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pageObjects.Mail_HomePage;
import pageObjects.Password_Page;
import pageObjects.Username_Page;
import pageObjects.Gmail_Page;
import testData.GenericExcelReader;
import utilities.CaptureTestScreen;

public class MainTest {

	public WebDriver driver;
	public static final String currentDir = System.getProperty("user.dir");
	public static final String dataPath = currentDir + "//src//main//resources//ExcelData//testdata.xlsx";
	
	@Test(dataProvider = "passData")

	public void gmailLogin(String username, String password, String mailSearch, String subjectAvailability) throws InterruptedException {

		// Mail_HomePage.homeSignInLink(driver).click();
		Thread.sleep(2000);
		
		//Entering the username of the Gmail account
		Username_Page.emailID(driver).sendKeys(username);
		CaptureTestScreen.captureScreenShot(driver);
		Username_Page.nextButton(driver).click();
		Thread.sleep(2000);
		
		//Entering the password of the Gmail Account
		Password_Page.passwordField(driver).sendKeys(password);
		CaptureTestScreen.captureScreenShot(driver);
		Password_Page.nextButtonPassword(driver).click();
		Thread.sleep(5000);
		
		//Searching for a particular mail
		Gmail_Page.searchMail(driver).sendKeys(mailSearch);
		CaptureTestScreen.captureScreenShot(driver);
		Thread.sleep(2000);
		Gmail_Page.searchButton(driver).click();
		Thread.sleep(2000);
		CaptureTestScreen.captureScreenShot(driver);
		
		//Clicking on the predefined mail record
		Gmail_Page.mailRecord(driver).click();
		Thread.sleep(2000); 
		CaptureTestScreen.captureScreenShot(driver);
		
		//Verifying the mail subject and mail body against predefind string
		String subjectText= Gmail_Page.mailSubject(driver).getText();
		String bodyText= Gmail_Page.mailBody(driver).getText();	
		Assert.assertTrue(subjectText.contains(subjectAvailability), "Searched word is not available in the subject");
		Assert.assertTrue(bodyText.contains(mailSearch), "Searched word is not available in the Body");
	}

	
	//Excel sheet contains the Username, Password, mailsearch String and subject availability String
	@DataProvider
	public Object[][] passData() {
		
		GenericExcelReader config = new GenericExcelReader(dataPath);
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][4];
		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
			data[i][3] = config.getData(0, i, 3);
		}
		return data;
	}
	
	

	@BeforeMethod

	public void beforeMethod() {

		// Create a new instance of the Chrome driver

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		driver = new ChromeDriver();

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL for Gmail

		driver.get("https://www.gmail.com");

	}

	@AfterMethod

	public void afterMethod() {

		// Close the driver

		driver.quit();

	}

}