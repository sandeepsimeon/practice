package com.sele.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoTestng2 {
	//init webdriver
	WebDriver driver;
  @Test
  public void browserInit() {
	   
	   driver=Drivers.getDriver("chrome");
	   driver.get("http://newtours.demoaut.com/");
		  
  }
  @Test
  public void openApp() {
	  	//title of the page
		System.out.println(driver.getTitle());
  }
		
@Test		
public void register() {
	
	    SoftAssert sa =new SoftAssert();
	    
		driver.findElement(By .linkText("REGISTER")).click();
		driver.findElement(By .name("country")).sendKeys("TOGO");
		driver.findElement(By .name("email")).sendKeys("mary");
		driver.findElement(By .name("password")).sendKeys("jane");
		driver.findElement(By .name("confirmPassword")).sendKeys("jane");
		driver.findElement(By .name("register")).click();
		String res=driver.findElement(By .xpath("*//table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
        sa.assertEquals(res,"Note: Your user name is mary.");
		Assert.assertEquals(res,"Note: Your user name is mary.");
        System.out.println(res);
        
		//max browser
		driver.manage().window().maximize();
	//close browser
		driver.close();
	  System.out.println("Insid Test3");
  }
}
