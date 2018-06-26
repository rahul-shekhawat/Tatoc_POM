package com.qait.testing.TatocTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAround {
	 
	WebDriver driver;
	
	public DragAround(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void draganddrop()
	{
		WebElement from=driver.findElement(By.id("dragbox"));
        WebElement to=driver.findElement(By.id("dropbox"));
        Actions act=new Actions(driver);					

        act.dragAndDrop(from, to).build().perform();
        driver.findElement(By.linkText("Proceed")).click();
		
        Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.1.86/tatoc/basic/windows");
	    
	}
}