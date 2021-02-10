package main.utilities;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class global_functions 
{
	WebDriver DriverOBJ = null;
	public String BrowserTypeRequest_Fun()
	{
		String[] BT_Choices = {"IE", "Chrome", "Firefox", "Edge"}; //BrowserType_Choices
		String Selected_BT = (String) JOptionPane.showInputDialog(null, "Choose BrowserType", 
		"Select Browser Type Against You Want To Open Application", 
		JOptionPane.QUESTION_MESSAGE, null, 
		BT_Choices, BT_Choices[0]);
		System.out.println("Selected Browser Type Is: "+Selected_BT);
		return Selected_BT;
		
	}
	
	public WebDriver LaunchBrowser_Fun(String Selected_BT)
	{
		
		switch (Selected_BT)
		{
			case "IE":
				System.setProperty("webdriver.ie.driver", "C:\\Selenium_WebDriver\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
				DriverOBJ = new InternetExplorerDriver();
				//DriverOBJ.navigate().to("http://www.amazon.com");
				DriverOBJ.manage().window().maximize();
				//String PageTitle_Value = DriverOBJ.getTitle();
				//System.out.println("Page Title Is: "+PageTitle_Value);
				break;
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium_WebDriver\\chromedriver_win32\\chromedriver.exe");
				DriverOBJ = new ChromeDriver();
				//DriverOBJ.navigate().to("http://www.amazon.com");
				DriverOBJ.manage().window().maximize();
				//String PageTitle_Value1 = DriverOBJ.getTitle();
				//System.out.println("Page Title Is: "+PageTitle_Value1);
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium_WebDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe");
				DriverOBJ = new FirefoxDriver();
				//DriverOBJ.navigate().to("http://www.publix.com");
				DriverOBJ.manage().window().maximize();
				//String PageTitle_Value111 = DriverOBJ.getTitle();
				//System.out.println("Page Title Is: "+PageTitle_Value111);
				break;
			case "Edge":
				System.setProperty("webdriver.edge.driver", "C:\\Selenium_WebDriver\\edgedriver_win64\\msedgedriver.exe");
				DriverOBJ = new EdgeDriver();
				//DriverOBJ.navigate().to("http://www.tacobell.com");
				DriverOBJ.manage().window().maximize();
				//String PageTitle_Value11 = DriverOBJ.getTitle();
				//System.out.println("Page Title Is: "+PageTitle_Value11);
				break;
		}
		return DriverOBJ;
	}
	
	public void LaunchApplication_Fun()
	{
		DriverOBJ.navigate().to("http://www.amazon.com");
	}
	
	public void CloaseBrowserAndApplication()
	{
		DriverOBJ.quit();
	}
	
	
	
	
	
	
}
