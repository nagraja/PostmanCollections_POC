package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import main.utilities.app_fl_or;
import main.utilities.global_functions;

public class SignIn_Script1 
{
  @Test
  public void Signin_s1() 
  {
  
	//Global Functions Object Creation
	global_functions gfOBJ = new global_functions();
	//ReadTestCasesData rtcdOBJ = new ReadTestCasesData();
			
	//Calling and Assigning Returned Value from Browser TypeFunction
	//String Selected_BT = gfOBJ.BrowserTypeRequest_Fun();
	
	//Calling Browser Launch Function and Assigning Driver value returned from Function
	WebDriver DriverOBJ = gfOBJ.LaunchBrowser_Fun("Chrome");
			
	gfOBJ.LaunchApplication_Fun();
	String URL_Value = DriverOBJ.getCurrentUrl();
	System.out.println("Browser Launched"+URL_Value);
	//System.out.println("What Browser Selected Is: "+Selected_BT+" and Launched"+URL_Value);
		
	
	//Function Library and Object Repository Object Creation
	app_fl_or florOBJ = new app_fl_or(DriverOBJ);
	
	//Find Sign in object and click on theSign in	
	florOBJ.SignIn_Fun();
  
  }
}
