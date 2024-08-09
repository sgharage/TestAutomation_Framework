package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseTest;

public class GooglePageTestFW extends BaseTest{

	@Test
	public static void SearchGoogle()
	{
		try {
			driver.findElement(By.xpath(Loc.getProperty("SearchBox"))).sendKeys("Facebook");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
			driver.findElement(By.xpath(Loc.getProperty("Search_btn"))).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			
		}
		catch(Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	
	}
	
	@Test
	public static void clickFacebook()
	{
		try {
			driver.findElement(By.xpath(Loc.getProperty("Facebooklink"))).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		}
		catch(Exception e)
		{
			System.out.println("Exception caught" +e.getMessage());
			
		}
	}
	
}
