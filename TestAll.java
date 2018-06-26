package com.qait.testing.TatocTesting;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAll {
	
	WebDriver driver;
	GridGate gridobj;
	FrameDungeon frame;
	DragAround drag;
	PopUpWindow pop;
	Cookiepage cookie;
	@Test(priority=0)
	public void clickonredboxshouldrendererrorpage()
	{   gridobj=new GridGate(driver);
		gridobj.attemptclickonredbox();
		driver.navigate().back();
	}
	
	@Test(priority=1)
	public void clickongreenboxshouldrendernextpage()
	{	
		gridobj.attemptclickongreenbox();
	}
	
	@Test(priority=2)
	public void boxcolornotmatchingshouldrendererrorpage() 
	{
		frame=new FrameDungeon(driver);
		frame.whentwocolorsnotmatch();
		driver.navigate().back();
	} 
	
	@Test(priority=3)
	public void boxcolormatchshouldrendernextpage() 
	{		
		frame.whentwocolorsmatch();
	}
	
	@Test(priority=4)
	public void successfuldragwillgotonextpage()
	{
		drag=new DragAround(driver);
		drag.draganddrop();
		
	}
	
	@Test(priority=6)
	public void unsuccessfulformsubmissionwillgotoerrorpage()
	{
		pop=new PopUpWindow(driver);
		pop.submittheform("");
		driver.navigate().back();
	}
	
	@Test(priority=7)
	public void successfulformsubmissionwillgotonextpage()
	{
		pop.submittheform("rahul");		
	}
	
	
	@Test(priority=8)
	public void successfuladdingofcookiewillgotonextpage()
	{
		cookie=new Cookiepage(driver);
		cookie.trytoaddcookie();
	}
	
	@BeforeClass
	public void launchChrome()
	{   
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");			
	}
	
	
	@AfterClass
	public void closeChrome()
	{   
		driver.quit();
	}

}