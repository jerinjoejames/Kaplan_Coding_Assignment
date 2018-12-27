package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gmail_Page {

	private static WebElement element = null;
	

	//Search Textbox in Gmail Page after logging in
	public static WebElement searchMail(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@aria-label='Search mail']"));

		return element;

	}

	//Search Button
	public static WebElement searchButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@aria-label='Search Mail']"));

		return element;

	}
	
	//Mail Record
	public static WebElement mailRecord(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[text()='Inbox']"));

		return element;

	}
	
	
	//Mail Subject full text
	public static WebElement mailSubject(WebDriver driver) {

		element = driver.findElement(By.xpath("//h2[@class='hP']"));

		return element;

	}
	
	//Mail Body text
	public static WebElement mailBody(WebDriver driver) {

		element = driver.findElement(By.xpath("(//div[@dir='ltr']//div)[4]"));

		return element;

	}

}