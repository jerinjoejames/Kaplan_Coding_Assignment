package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Password_Page {

	private static WebElement element = null;
	 
	//Password Text Box
	 public static WebElement passwordField(WebDriver driver){
		 
		    element = driver.findElement(By.name("password"));
		 
		 return element;
		 
		 
		    }
	 
	 // "Next" button in the Password page to Login
	 public static WebElement nextButtonPassword(WebDriver driver){
		 
		    element = driver.findElement(By.id("passwordNext"));
		 
		 return element;
		 
		    }
}
