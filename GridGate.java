package com.qait.testing.TatocTesting;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GridGate {

	WebDriver driver;
	
	public GridGate(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getgreenbox()
	{   
		return driver.findElement(By.className("greenbox"));
	}
	
	public WebElement getredbox()
	{   
		return driver.findElement(By.className("redbox"));
	}
	
	public void attemptclickongreenbox()
	{
		String ExpUrl="http://10.0.1.86/tatoc/basic/frame/dungeon";
		WebElement green=getgreenbox();
		green.click();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(ExpUrl, actual);
	}
	
	public void attemptclickonredbox()
	{
		String ExpUrl="http://10.0.1.86/tatoc/error";
		WebElement red=getredbox();	
		red.click();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(ExpUrl, actual);	
	}
}