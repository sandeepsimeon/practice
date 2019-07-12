package com.sele.testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoAlert {
	WebDriver driver;
  @Test
  public void dalert() {
	  driver=Drivers.getDriver("chrome");
	  driver.get("http://demowebshop.tricentis.com/");
	  driver.manage().window().maximize();
	  System.out.println(driver.getTitle());
	  driver.findElement(By .xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();
	 Alert a= driver.switchTo().alert();
	 a.accept();
	 driver.findElement(By .id("small-searchterms")).sendKeys("Comp");
	 
	  
  }
}
