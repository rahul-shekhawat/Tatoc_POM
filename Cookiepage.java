package com.qait.testing.TatocTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class Cookiepage {
	
	WebDriver driver;
	public Cookiepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void trytoaddcookie()
	{
		driver.findElement(By.linkText("Generate Token")).click();
        String token=driver.findElement(By.id("token")).getText();
        String []ss=token.split("\\s+");
        System.out.println(ss[1]);
        Cookie name=new Cookie("Token",ss[1]);
        driver.manage().addCookie(name);
        driver.findElement(By.linkText("Proceed")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/end");
	}

}
