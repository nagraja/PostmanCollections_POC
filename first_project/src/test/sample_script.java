package test;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import main.TestData.ReadTestCasesData;
import main.utilities.app_fl_or;
import main.utilities.global_functions;

public class sample_script 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
						
		//Global Functions Object Creation
		global_functions gfOBJ = new global_functions();
		//ReadTestCasesData rtcdOBJ = new ReadTestCasesData();
		
		
		//Calling and Assigning Returned Value from Browser TypeFunction
		String Selected_BT = gfOBJ.BrowserTypeRequest_Fun();
		
		//Calling Browser Launch Function and Assigning Driver value returned from Function
		WebDriver DriverOBJ = gfOBJ.LaunchBrowser_Fun(Selected_BT);
				
		gfOBJ.LaunchApplication_Fun();
		String URL_Value = DriverOBJ.getCurrentUrl();
		System.out.println("Browser Launched"+URL_Value);
		System.out.println("Git Test Browser Launched"+URL_Value);
		System.out.println("Git Test1 Browser Launched"+URL_Value);
		System.out.println("Git Test2 Browser Launched"+URL_Value);
		
		//Function Library and Object Repository Object Creation
		app_fl_or florOBJ = new app_fl_or(DriverOBJ);
		
		//Find Sign in object and click on theSign in	
		florOBJ.SignIn_Fun();
		
		
		//HashMap<String, String> colnames = florOBJ.GetColumnNames_Fun();
		//System.out.println(colnames.get("ColName1"));
		
		//gfOBJ.CloaseBrowserAndApplication();
		 
		//rtcdOBJ.ReadData();
		
	}

	
}
