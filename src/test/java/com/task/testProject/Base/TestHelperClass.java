package com.task.testProject.Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestHelperClass {
	
	public static WebDriver driver;
	
	public TestHelperClass(){		
	}
	
	@Before
	public void SetUp(){
		TestHelperClass.driver = DriverFactory.GetDriver();
	}
	
	@After
	public void TearDown(){
		driver.close();
	}

}
