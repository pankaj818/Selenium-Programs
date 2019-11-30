package com.pankaj;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class TestCaseDataProvider {
	WebDriver driver =null;
	
	  @BeforeSuite    //brforesuit used for open the browser
	  public void beforeSuite() {
		  driver=new FirefoxDriver();
		  driver.get("file:///D:/JAVA%20SOFTWARE/Selenium%20Software/Offline%20Website/pages/examples/logout.html");
	  }
  @Test(dataProvider = "logingTestCasesData")
  public void CheckAllCases(String TestCaseId, String  TestCaseDescr,String uname,String password,String expMassege) {//ithe jevdhe parameter taku thevdhe khali vhadvayche
	  System.out.println("Now TestCase Running >>" +TestCaseId+ "descr >>"+TestCaseDescr);
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uname);
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	 if(!TestCaseDescr.equals("valid")) {
	  String actErrorMessage = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	  String expErrorMessage = expMassege;
	  Assert.assertEquals(actErrorMessage, expErrorMessage);	
	 }else {
		 String actErrorMessage = driver.getTitle();
		 String expErrorMessage = expMassege;
	     Assert.assertEquals(actErrorMessage, expErrorMessage);	
	 }  
  }

  @DataProvider
  public Object[][] logingTestCasesData() {  //yaha se data upper provied ho raha hai isliy same name upper diya
    return new Object[][] {
      new Object[] {"TC01", "blank", "","","blank uname password allowed" },
      new Object[] {"TC01", "invalid","abcd","jsjh","invalid uname password not allowed" },
      new Object[] {"TC01", "valid","kiran@gmail.com","123456","DashBoard" },
    };
  }
}
