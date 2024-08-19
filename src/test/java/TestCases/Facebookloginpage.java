package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseTest;

public class Facebookloginpage extends BaseTest{
	
	@Test(dataProvider = "TestData" )
	public void enterUserDetail(String username, String Password)
	{
		System.out.println("Enter in method");
		driver.findElement(By.id(Loc.getProperty("username_editbox"))).sendKeys(username);
		driver.findElement(By.id(Loc.getProperty("password_editbox"))).sendKeys(Password);
		driver.findElement(By.xpath(Loc.getProperty("login_btn"))).click();
		
	}
	
	@DataProvider
	public Object[][] TestData()
	{
		return new Object[][]
		{
			{"Abc@gmail.com" , "Abc123"},
			{"xYz@abc.com", "12367"},
			{"1xYz@abc.com", "12367A"},
			{"2xYz@abc.com", "12367B"},
			{"Abcd#1234@xyz.com","908*89"},
			{"sarikagharage8@gmail.com", "Sarika@1205"},
			
		};
		
	}
}
