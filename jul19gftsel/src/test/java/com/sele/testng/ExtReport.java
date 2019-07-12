package com.sele.testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtReport {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
  @BeforeTest
  public void startReport() {
	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
      extent=new ExtentReports();
      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Host Name","GFT NexGen Testing ");
      extent.setSystemInfo("Environment","Automation Testing Stream ");
      extent.setSystemInfo("User Name","Parker John");
       htmlReporter.config().setDocumentTitle("Title of the report comes here");
       htmlReporter.config().setReportName("Name of the report comes here");
       htmlReporter.config().setTheme(Theme.STANDARD);
  }
  
  @Test
  public void passTest() {
	  logger=extent.createTest("passTest");
	  
	    driver=Drivers.getDriver("chrome");
		/*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.presenceOfElementLocated(By .name("password")));*/
		driver.get("http://www.newtours.demoaut.com/");	
		Assert.assertTrue(true);	  
	  logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed is passTest",ExtentColor.GREEN));
  }
   
  public void failTest() {
	  logger=extent.createTest("failTest");
	  Assert.assertTrue(false);
  }

  public void skipTest() {
	  logger=extent.createTest("skipTest");
	  //throw new SkipException("Skipping - this is not ready");
  }
  @AfterMethod
  public void getResult(ITestResult result) throws Exception {
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
  @AfterTest
  public void endReport() {
	extent.flush();  
  }
}
