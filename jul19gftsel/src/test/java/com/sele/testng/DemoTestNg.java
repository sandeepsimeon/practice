package com.sele.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTestNg {
	
  @Test(priority=1, enabled=false)
  public void openApp() {
	  System.out.println("Inside openApp method");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside beforeMethod method");
  }
  
  @Test(priority=2)
  public void Login() {
	  System.out.println("Inside login method");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside afterMethod method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside BeforeClass method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside afterClass method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest method");
  }
  
  @Test(priority=3)
  public void Logout() {
	  System.out.println("Inside logout method");
	  
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside beforeSuite method");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside afterSuite method");
  }

}
