package com.sele.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleDemo {
	WebDriver driver;
  @Test
  public void seltest() {
	  driver=Drivers.getDriver("chrome");
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.get("http://newtours.demoaut.com/");
	   
	   WebDriverWait wait = new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By .name("userName")));
	   driver.findElement(By .name("userName")).sendKeys("sandeepsimeon");
	   driver.findElement(By .name("password")).sendKeys("sandeep@123");
	   driver.findElement(By .name("login")).click();
	  	   //boolean b=driver.findElement(By .linkText("REGISTER")).isDisplayed();
	   //System.out.println(b);
	  //driver.findElement(By .linkText("REGISTER")).click();
	 //Select sel=new Select(driver.findElement(By .name("country")));
	 //sel.selectByValue("1");
	 //sel.selectByVisibleText("INDIA");
	 //sel.selectByIndex(220);
  }
}
