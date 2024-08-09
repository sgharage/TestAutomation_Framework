/*
 * common features are moved into base class
 */
package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static Properties Loc = new Properties();
	public static FileReader fr1;
	
	@BeforeMethod
	public void setup() throws IOException {
		if(driver==null)
		{
			//FileReader fr = new FileReader("D:\\Sarika\\selenium project\\QAAutomation_PageObjectModel\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
			System.out.println("the Path is" + System.getProperty("user.dir"));
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			Loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();//base
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));//config properties
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();//base
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));//config properties
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("TEarDown Sucessfully");
		
	}
	
}
