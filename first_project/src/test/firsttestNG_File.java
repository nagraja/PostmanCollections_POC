package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class firsttestNG_File 
{
	String baseURL = "http://www.amazon.com";
	public WebDriver tngdriver = null;
	
	
	@Test
	public void verifyHomePageTitle()
	{
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_WebDriver\\chromedriver_win32\\chromedriver.exe");
		tngdriver = new ChromeDriver();
		tngdriver.get(baseURL);
		String Title_EV = "Test";
		String Title_AV = tngdriver.getTitle();
		System.out.println("Page Actual Title Is: "+Title_AV);
		Assert.assertEquals(Title_AV, Title_EV);
		tngdriver.close();
	}
}
