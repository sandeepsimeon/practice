package com.sele.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import com.sele.testng.Drivers;

import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Scenario1 {
	WebDriver driver;
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest logger;	
	@Test(priority=1)
	public void open()
	{
		logger = extent.createTest("open");
		 driver=Drivers.getDriver("chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp");
	}	
	@Test(priority=2)
  public void testRegistration() throws InterruptedException {  
		logger = extent.createTest("testRegistrationMethod");
	  //System.out.println("inside test registration");		
		driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		Assert.assertEquals(driver.getTitle(), "Sign Up");
		driver.findElement(By .name("userName")).sendKeys("maryw");
		driver.findElement(By .name("firstName")).click();
  		//String s = driver.findElement(By .id("err")).getText();	
		driver.findElement(By .name("firstName")).sendKeys("christopher");
		driver.findElement(By .name("lastName")).click();
		driver.findElement(By .name("lastName")).sendKeys("sadd");
		driver.findElement(By .name("password")).click();
		driver.findElement(By .name("password")).sendKeys("pass3456");
		driver.findElement(By .name("confirmPassword")).click();
		driver.findElement(By .name("confirmPassword")).sendKeys("pass3456");
	driver.findElement(By .name("gender")).click();
	driver.findElement(By .name("emailAddress")).click();
	driver.findElement(By .name("emailAddress")).sendKeys("sandeep@gmail.com");
	driver.findElement(By .name("mobileNumber")).click();
	driver.findElement(By .name("mobileNumber")).sendKeys("8466858248");
	driver.findElement(By .name("dob")).click();
	driver.findElement(By .name("dob")).sendKeys("07/04/1998");
	driver.findElement(By .name("address")).click();
	driver.findElement(By .name("address")).sendKeys("asdskjlsafdhfoiuw fdjafskhaweprti flasjkdh1fas23 342 ");
	driver.findElement(By .name("securityQuestion")).click();
	driver.findElement(By .name("securityQuestion")).sendKeys("What is your Birth Place?");
	driver.findElement(By .name("answer")).click();
	driver.findElement(By .name("answer")).sendKeys("Hyderabad");
	driver.findElement(By .name("Submit")).click();
	driver.findElement(By .name("Login")).click();
			Thread.sleep(5000);
	}  
  @Test(priority=3)
  public void testLogin() throws InterruptedException {
	  logger = extent.createTest("testLogin");
	 // System.out.println("inside test login");
	 // driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  //driver.findElement(By.xpath("//a[@href='login.htm']")).click(); 
	  driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).sendKeys("maryw");
			driver.findElement(By.name("password")).click();			
			driver.findElement(By.name("password")).sendKeys("Pass3456");		
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.findElement(By .name("Login")).click();
			Assert.assertEquals(driver.getTitle(),"Home");
			Thread.sleep(5000);
			Assert.assertTrue(true);
			
  }
    @Test(priority=4)
  public void testCart() throws InterruptedException {
    	logger = extent.createTest("testCart");
	  //System.out.println("inside test Cart");
    	driver.findElement(By .name("products")).click();
    	driver.findElement(By .name("products")).sendKeys("bag");
    	driver.findElement(By .xpath("//input[@value='FIND DETAILS']")).click();
    	driver.findElement(By .xpath("/html/body/section/div/div/div[2]/div[2]/div/div/div[2]/center/a")).click();
    	driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
    	driver.findElement(By .xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
    	Thread.sleep(5000);
		Assert.assertTrue(true);
    }
    	    
  @Test(priority=5)
  public void testPayment() throws InterruptedException {
	  logger = extent.createTest("testPayment");
		driver.findElement(By .xpath("//input[@value='Proceed to Pay']")).click();  	
		//driver.findElement(By .name("radio1")).click();
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
	  		//driver.findElement(By.xpath("//input[@value='Andhra Bank']")).click();	
	  		driver.findElement(By.xpath("//a[@id='btn']")).click();
	  		driver.findElement(By.name("username")).sendKeys("123456");			
	  		driver.findElement(By.name("password")).sendKeys("Pass@456"); 	
	  		Thread.sleep(5000);
	  		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  		driver.findElement(By.xpath("//input[@value='PASSWORD']")).sendKeys("Trans@456");
	  		driver.findElement(By.xpath("//input[@type='submit']")).click();
	  		Thread.sleep(5000);
			Assert.assertTrue(true);	  	  
  }
     @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
    	  if(result.getStatus()==ITestResult.FAILURE) {
   	           	      logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"- Test case failed",ExtentColor.RED));
    	      TakesScreenshot sht=(TakesScreenshot)driver;
    	       File src=sht.getScreenshotAs(OutputType.FILE);
    	       String path=System.getProperty("user.dir"+"/extent-reports/snapshots/"+result.getName()+".png");
    	       FileUtils.copyFile(src,new File(path));
    	       logger.addScreenCaptureFromPath(path, result.getName());
    		  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"- Test case failed",ExtentColor.RED));
    		  
    		
    	  }else if(result.getStatus()==ITestResult.SKIP) {
    		  logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"- Test case skip",ExtentColor.ORANGE));
 
    	  }
      }
    	 //logger
	  //System.out.println("inside after method ");
  @BeforeTest
  public void startReportBeforeTest() {

	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
      extent=new ExtentReports();
      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Host Name","GFT NexGen Testing ");
      extent.setSystemInfo("Environment","Automation Testing Stream ");
      extent.setSystemInfo("User Name","Parker John");
       htmlReporter.config().setDocumentTitle("Title of the report comes here");
       htmlReporter.config().setReportName("Name of the report comes here");
       htmlReporter.config().setTheme(Theme.STANDARD);
	 // System.out.println("inside before test");
  }
  @AfterTest
  public void endReportAfterTest() {
	  extent.flush();
	 
	  //System.out.println("inside after test ");	
  }
  @Test(priority=7)
  public void testLogout() {
	 // System.out.println("inside test logout");
  }
}
