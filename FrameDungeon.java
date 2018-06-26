package com.qait.testing.TatocTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FrameDungeon {
	
	WebDriver driver;
	
	public FrameDungeon(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void whentwocolorsmatch()
	{
		WebElement ele = driver.findElement(By.id("main"));
		driver.switchTo().frame(ele);
		String expAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
        
        Boolean cond=true;
        
        while(cond)
        {   driver.findElement(By.linkText("Repaint Box 2")).click();

        	WebElement childele = driver.findElement(By.id("child"));
    		driver.switchTo().frame(childele);	
    		String actualAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
    		
			if(actualAnswer.equals(expAnswer)) {
				cond = false;
				
			}
			driver.switchTo().parentFrame();
			
        }
		
        driver.findElement(By.linkText("Proceed")).click();
        
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/drag");
	}
	
	public void whentwocolorsnotmatch()
	{
		WebElement ele = driver.findElement(By.id("main"));
		driver.switchTo().frame(ele);
		String expAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
        
        Boolean cond=true;
        
        while(cond)
        {   driver.findElement(By.linkText("Repaint Box 2")).click();

        	WebElement childele = driver.findElement(By.id("child"));
    		driver.switchTo().frame(childele);	
    		String actualAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
    		
			if(!(actualAnswer.equals(expAnswer))) {
				cond = false;
				
			}
			driver.switchTo().parentFrame();
			
        }
		
        driver.findElement(By.linkText("Proceed")).click();
        
        Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/error");
    	
	}
	
}
