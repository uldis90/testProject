package com.task.testProject.Tests;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import com.task.testProject.Base.TestHelperClass;
import com.task.testProject.Pages.BasePageClass;
import com.task.testProject.Pages.VacanciesPage;

public class TestClass extends TestHelperClass{

	public static VacanciesPage vacPage;
	public static BasePageClass basePage;
	
	
	@Before
	public void saddas()
	{
		vacPage = new VacanciesPage(driver);
		basePage = new BasePageClass(driver);
	}
	
	
	@Test
	public void TestSkillsCount()
	{		
		basePage.OpenHomePage();
		basePage.OpenCareersMenu();
		basePage.OpenVacancies();		
		vacPage.OpenVacantyByName("Test Automation Engineer");
		String skills[] = vacPage.GetSkillsByName("Test Automation Engineer");	
		Assert.assertEquals(skills.length, 5,"Qualification contains exactly 5 skills:");
	}
	
}
