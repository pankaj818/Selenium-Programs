package com.pankaj;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class TestCases {
	WebDriver driver =null;
	
  @BeforeSuite    //brforesuit used for open the browser
  public void beforeSuite() {
	  driver=new FirefoxDriver();
	  driver.get("file:///D:/JAVA%20SOFTWARE/Selenium%20Software/Offline%20Website/pages/examples/logout.html");
  }
	 
  @Test
  public void blankUserName() {
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	  String actErrorMessage = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	  String expErrorMessage = "Resister a new membership";
	  Assert.assertEquals(actErrorMessage, expErrorMessage);	  
  }
  @Test
  public void spCharUserName() {
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("gghd");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ndjodko");
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	  String actErrorMessage = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	  String expErrorMessage = "Resister a new membership";
	  Assert.assertEquals(actErrorMessage, expErrorMessage);
  }
  @Test
  public void invalidUserName() {
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("jdeudiid");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("judu");
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	  String actErrorMessage = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	  String expErrorMessage = "Resister a new membership";
	  Assert.assertEquals(actErrorMessage, expErrorMessage);
  }
  @Test
  public void validUserName() {
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	  String actTitle =driver.getTitle();
	  String expTitle = "DashBoard";
	  Assert.assertEquals(actTitle, expTitle);
  }
 

}
