package com.sele.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoTestngnew {
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
		
@Test(dataProvider="registerdata")
public void register(String user,String pass) throws Exception {
	
	    SoftAssert sa =new SoftAssert();
	    
	    driver.findElement(By .linkText("REGISTER")).click();
		driver.findElement(By .name("country")).sendKeys("TOGO");
		driver.findElement(By .name("email")).sendKeys(user);
		driver.findElement(By .name("password")).sendKeys(pass);
		driver.findElement(By .name("confirmPassword")).sendKeys(pass);
		driver.findElement(By .name("register")).click();
		String res=driver.findElement(By .xpath("*//table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
        sa.assertEquals(res,"Note: Your user name is mary.");
		Assert.assertEquals(res,"Note: Your user name is mary.");
        System.out.println(res); 
      
		//max browser
		driver.manage().window().maximize();}
	//close browser
		//driver.close();
	  //System.out.println("Insid Test3");
 
 @DataProvider
 public Object[][] registerdata() throws Exception{
	 
	 File s=new File("registerdata.xlsx");
	    FileInputStream f1=new FileInputStream(s);
	    //workbook
	    
	    XSSFWorkbook xb=new XSSFWorkbook(f1);
	    XSSFSheet xs=xb.getSheet("Sheet1");
	    XSSFRow gcrow=xs.getRow(0);
	   int rcnt =xs.getLastRowNum();
	   int ccnt= gcrow.getLastCellNum();
	   
	    System.out.println(rcnt+ccnt);
	    Object[][] d1=new Object[rcnt-1][ccnt];
	    for(int i=0;i<=xs.getLastRowNum()-1;i++) {
	    	 
	    	
	    	for(int j=0;j<=ccnt;j++) {
	    		String data=xs.getRow(i+1).getCell(j).getStringCellValue();
   					d1[i][j]=data;
	            
	    	} 	
	    	    
	    }
	    return d1;  
	
 }
 }
