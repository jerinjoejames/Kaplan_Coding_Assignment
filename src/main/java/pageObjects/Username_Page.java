package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Username_Page {

	private static WebElement element = null;

	//Email Id text box
	public static WebElement emailID(WebDriver driver) {

		element = driver.findElement(By.id("identifierId"));

		return element;

	}

	//Next button in the Email Id entering page
	public static WebElement nextButton(WebDriver driver) {

		element = driver.findElement(By.id("identifierNext"));

		return element;

	}

}
