package com.sele.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActions {

	WebDriver driver;
@Test
public void testActions() throws Exception {
	
	driver=Drivers.getDriver("chrome");
	   //driver.get("http://newtours.demoaut.com/");
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_H2A.05.18\\Downloads\\chromedriver_win32\\chromedriver.exe");

		//driver=new ChromeDriver();
		/*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.presenceOfElementLocated(By .name("password")));*/
		//driver.get("http://jqueryui.com/");
		
		
		Actions a=new Actions(driver);
		driver.findElement(By .linkText("Droppable")).click();
		
		driver.switchTo().frame(0);
		WebElement drap=driver.findElement(By .id("draggable"));
		WebElement drop=driver.findElement(By .id("droppable"));
		a.dragAndDrop(drap,drop).perform();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By .linkText("Menu")).click();
		driver.switchTo().frame(0);
		//mouser hovering
		a.moveToElement(driver.findElement(By .xpath("//*[@id=\"ui-id-4\"]")))
		.moveToElement(driver.findElement(By .id("ui-id-6"))).click().build().perform();
		
	
	
	
		
		
}



}
