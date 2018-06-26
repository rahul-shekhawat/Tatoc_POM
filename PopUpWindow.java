package com.qait.testing.TatocTesting;
import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class PopUpWindow {
	
	WebDriver driver;
	
	public PopUpWindow(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void submittheform(String input)
	{
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys(input);
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window(parentWindowHandler);
        driver.findElement(By.linkText("Proceed")).click();
       
		if(input.equals(""))
		{
			Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/error");
			
		}
		else
		{
			Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/cookie");
		}
	}

}
