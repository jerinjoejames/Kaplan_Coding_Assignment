package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Mail_HomePage {

	private static WebElement element = null;
	
	 public static WebElement homeSignInLink(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("a[text()='Sign In']"));
		 
		    return element;
		 
		    }
	 
}
