package com.sele.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class action {
	WebDriver driver;
  @Test
  public void f() {
	  driver =Drivers.getDriver("chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  Actions act =new Actions(driver);
	  //act.moveToElement(driver.findElement(By .tagName())).click().build().perform();
	  act.moveToElement(driver.findElement(By .cssSelector("#menu3 > li:nth-child(3)"))).click().build().perform();
			

	  //driver.findElement(By .xpath("//*[@id=\"menu3\"]/li[3]/a/span")).click();
	 // a.moveToElement(driver.findElement(By .xpath("//*[@id=\\\"menu3\\\"]/li[3]/a/span")));
	
	  
	 // act.moveToElement((WebElement) driver.findElement(By.xpath("//span[contains(text(),'AboutUs'],[contains(text(),'Our\n" + 
			 		//"												Offices'][contains(text(),'Chennai')]"))).click().perform();
	  
	 // act.moveToElement(driver.findElement(By .xpath("//span[contains(text(),'Our\n" + 
	 	//	"												Offices')]")));
	
	 // act.moveToElement(driver.findElement(By .xpath("//span[contains(text(),'Chennai')]"))).click().build().perform();
	  
  }
}
