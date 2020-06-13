package com.task.testProject.Base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	DriverFactory()	{
	}		
	
	public static WebDriver GetDriver()
	{
		if(driver==null)
		{
			WebDriver newDriver = new ChromeDriver();
			newDriver.manage().window().maximize();
			newDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver = newDriver;
		}
		return driver;		
	}

}
