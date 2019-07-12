package com.sele.testng;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Switch {
	
	WebDriver driver;
  @Test
  public void windswitch() throws Exception {
	  driver=Drivers.getDriver("chrome");
	  driver.get("http://google.co.in");
	  driver.manage().window().maximize();
	  System.out.println(driver.getTitle());
	  driver.findElement(By .linkText("Gmail")).click();
	  System.out.println(driver.getTitle());
	  driver.findElement(By .linkText("Terms")).click();
	  System.out.println(driver.getTitle());
	  Set<String> wndhand=driver.getWindowHandles();
	  System.out.println(wndhand.size());
	     Iterator<String> ita=wndhand.iterator();
	     String str=ita.next().toString();
	    String str1= ita.next().toString();
	     
	  driver.switchTo().window(str1);
	  
	  System.out.println(driver.getTitle());
	  driver.findElement(By .linkText("view archived versions")).click();
	  Thread.sleep(2000);
	  System.out.println(driver.getTitle());
	  
  }
}
