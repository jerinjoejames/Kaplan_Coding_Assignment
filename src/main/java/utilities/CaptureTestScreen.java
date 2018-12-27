package utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureTestScreen {
	public static final String currentDir = System.getProperty("user.dir");
	public static void captureScreenShot(WebDriver driver){
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 String screenshotPath = currentDir + "//src//main//resources//Screenshot//";
				 
		 FileHandler.copy(src, new File(screenshotPath+System.currentTimeMillis()+".png"));
		       }
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		    }
		 
		}
}
