package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {
   public static WebDriver getDriver(String browser) {
		  if(browser.equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_H2A.05.18\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			  return new ChromeDriver();
		  }
		  else if(browser.equalsIgnoreCase("ff")) {
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\Training_H2A.05.18\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			  return new FirefoxDriver();
		  }
		  
		  else {
			  return null;
		  }
		  
			}

}
