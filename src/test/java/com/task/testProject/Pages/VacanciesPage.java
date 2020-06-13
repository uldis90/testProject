package com.task.testProject.Pages;

import java.util.List;
import java.util.function.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacanciesPage{
	
	private final String VACANCIES_SELECTOR = "//*[@id=\"menu-main-1\"]/li/a";	
	private final String SKILLS_LOCATOR = "//div[contains(*,\"%s\")]/div/div/p";
	private final String SKILLS_HEADER_LOCATOR = "//div[contains(*,\"%s\")]/div/div/p/"
			+ "strong[contains(*,\"Professional skills and qualification:\")]";
	
	WebDriver driver;	
	public VacanciesPage(WebDriver driver)
	{
		this.driver = driver;
	}	

	
	public List<WebElement> GetAllVacancies()
	{	
		return driver.findElements(By.xpath(VACANCIES_SELECTOR));
	}
	
	public WebElement FindVacantyByName(final String jobName)
	{
		List<WebElement> vacantiesList = GetAllVacancies();
		
		if (!vacantiesList.isEmpty())
		{
			WebElement vacancy = vacantiesList.stream().filter(new Predicate<WebElement>() {
				public boolean test(WebElement x) {
					return jobName.equals(x.getText());
				}
			}).findFirst().get();
			return vacancy;
		}
	System.out.println("Vacanty \""+jobName+"\" not found!");	
	return null;
	}
	
	public void OpenVacantyByName(String jobName)
	{
		FindVacantyByName(jobName).click();
	}
	
	public String[] GetSkillsByName(String jobName)
	{
		String skillsHeader = String.format(SKILLS_HEADER_LOCATOR, jobName );	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(skillsHeader)));		
		
		//get all paragraphs
		String skillsLocator = String.format(SKILLS_LOCATOR, jobName );
		List<WebElement> paragraphs = driver.findElements(By.xpath(skillsLocator));	

		for(int i =0; i<paragraphs.size();i++)
		{
			String content = paragraphs.get(i).getText();
				
			if (content.toLowerCase().contains("professional skills and qualification:"))
			{				
				int paragraphIndex = i+2;
				WebElement skillsList = driver.findElement(By.xpath(skillsLocator+"["+paragraphIndex+"]"));	
				String skillsText = skillsList.getText();
				return skillsText.split("\\r?\\n");
			}
		}		
		System.out.println("No skills found for \""+jobName+"\" vacancy!");			
		return null;
	}
	
	
	
}
