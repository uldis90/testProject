package com.task.testProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePageClass {
	private final String CAREER_MENU_ID = "menu-item-127";
	private final String VACANCIES_ID = "menu-item-131";
	private final String BASE_URL = "https://ctco.lv/en";	
	WebDriver driver;
	
	public BasePageClass(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	public void OpenCareersMenu()
	{				
		WebElement careerMenu = driver.findElement(By.id(CAREER_MENU_ID));
		Actions actonBuilder = new Actions(driver);
		actonBuilder.moveToElement(careerMenu).perform();
	}
	
	public void OpenVacancies()
	{
		WebElement vacancies = driver.findElement(By.id(VACANCIES_ID));
		vacancies.click();
	}
	
	public void OpenHomePage()
	{
		driver.get( BASE_URL);	
	}	

}
