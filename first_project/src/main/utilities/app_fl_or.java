package main.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class app_fl_or 
{
	WebDriver DriverOBJ = null;
	private By SignInObj = By.xpath("//*[@id='nav-link-accountList']");
	
	private By unOBJ = By.xpath("//*[@id='ap_email']");
	private By pwOBJ = By.xpath("//*[@id='continue']");
	private By cbOBJ = By.xpath("//*[@id='continue']");
	//private By UN_Empty_amOBJ = By.xpath("//*[@id='auth-email-missing-alert']/div[@class='a-box-inner a-alert-container']/div[@class='a-alert-content']");
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    	
	
	//*[@id="nav-link-accountList"]/div/span
	
	//Why we need this piece of code here used for what
	public app_fl_or(WebDriver Driver)
	{
		this.DriverOBJ = Driver;
	}
		
	public void SignIn_Fun()
	{
		try 
		{
			DriverOBJ.findElement(SignInObj).isDisplayed();
			System.out.println("SignIn Object Exists");
			DriverOBJ.findElement(SignInObj).click();
			
			// Import excel sheet.
		    File src = new File("C:\\Eclipse_WorkSpace\\TC_DataFiles\\Login_FT_DF.xlsx");
		     
		    // Load the file.
		    FileInputStream finput = new FileInputStream(src);
		     
		    // Load the workbook.
		   workbook = new XSSFWorkbook(finput);
		     
		    // Load the sheet in which data is stored.
		    sheet = workbook.getSheetAt(0);
		    System.out.println("Last Row Number Is: "+sheet.getLastRowNum());
		    
		    System.out.println("Last Column Number Is: "+sheet.getRow(0).getLastCellNum());
		    
		    //Hash Map Object Creation Starts
		    	HashMap<String, String> cnOBJ = new HashMap<>(); //cnOBJ=columnnameOBJ
		    //Hash Map Object Creation Ends	    
		    
		    System.out.println(cnOBJ.entrySet());
		    
		    for(int i=1; i<=sheet.getLastRowNum(); i++)
		    {
		    	//This Loop is to Get the Column Name and corresponding Value Start
		    	cnOBJ.clear();
		    	for (int cni=0; cni<sheet.getRow(0).getLastCellNum(); cni++)
			    {
			    	
			    	cnOBJ.put(sheet.getRow(0).getCell(cni).toString(), sheet.getRow(i).getCell(cni).toString());
			    }		    	
		    	//This Loop is to Get the Column Name and corresponding Value Ends
		    	
		    	//System.out.println(cnOBJ.get("TC_Name"));
		    	
		    	
		    	Row Row_V = sheet.getRow(i);
		    	String ExecutionFlag_V = Row_V.getCell(2).toString();
		    	System.out.println("Execution Flag Value Is: "+ExecutionFlag_V);
		    	
		    			        
		    	switch (Row_V.getCell(2).toString())
		    	{
		    		case "yes":
		    			//String UN_V = Row_V.getCell(3).toString();
		    			String UN_V = cnOBJ.get("UserName_V");
				        String PW_V = Row_V.getCell(4).toString();
				        //String AM_EV = Row_V.getCell(5).toString();
				        String AM_EV = cnOBJ.get("TC_Exception_EV");
				        System.out.println("UserName Value Is: "+cnOBJ.get("UserName_V")+" Password Value Is: "+cnOBJ.get("Password_V"));
				        System.out.println("Row Number Is: "+i);
				        switch (i)
				        {
					        case 1:
					        	DriverOBJ.findElement(unOBJ).sendKeys(cnOBJ.get("UserName_V")); 
						        DriverOBJ.findElement(cbOBJ).click();
						        By UN_Empty_amOBJ = By.xpath("//*[@id='auth-email-missing-alert']/div[@class='a-box-inner a-alert-container']/div[@class='a-alert-content']");
						        String AlertMessage_AV = DriverOBJ.findElement(UN_Empty_amOBJ).getText().toString();
						        System.out.println("Alert Message Is: "+AlertMessage_AV);
						       
						        if (cnOBJ.get("TC_Exception_EV").equals(AlertMessage_AV))
						        	{
						        		System.out.println("Expected Alert Message: "+cnOBJ.get("TC_Exception_EV")+" ***AND*** Actual Alert Message: "+AlertMessage_AV+" ***Are Matched");
						        	}
						        else
						        	{
						        		System.out.println("Expected Alert Message: "+cnOBJ.get("TC_Exception_EV")+" ***AND*** Actual Alert Message: "+AlertMessage_AV+" ***Are Not Matched");
						        	}
						        break;
					        case 2:
					        	DriverOBJ.findElement(unOBJ).sendKeys(cnOBJ.get("UserName_V")); 
						        DriverOBJ.findElement(cbOBJ).click();
						        By UN_Empty_amOBJ1 = By.xpath("//*[@id='auth-error-message-box']/div[@class='a-box-inner a-alert-container']/div[@class='a-alert-content']/ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-none']/li/span[@class='a-list-item']");
						        String AlertMessage_AV1 = DriverOBJ.findElement(UN_Empty_amOBJ1).getText().toString();
						        System.out.println("Actual Alert Message Is: "+AlertMessage_AV1);
						        if (cnOBJ.get("TC_Exception_EV").equals(AlertMessage_AV1))
					        		{
					        			System.out.println("Expected Alert Message: "+cnOBJ.get("TC_Exception_EV")+" ***AND*** Actual Alert Message: "+AlertMessage_AV1+" ***Are Matched");
					        		}
						        else
					        		{
						        	System.out.println("Expected Alert Message: "+cnOBJ.get("TC_Exception_EV")+" ***AND*** Actual Alert Message: "+AlertMessage_AV1+" ***Are Not Matched");
					        		}
					        	break;
					     }
				        break;
		    		
		    		case "no":
		    			System.out.println("This Test Case Is Skipped");
		    			break;
		    	}
		    }
			
		} 
		catch (Exception e)
		{
			System.out.println("SignIn Object Not Exists");
		}
	}
	
	//Hash Map creation for reading the column names
	//public HashMap<String, String> GetColumnNames_Fun()
	//{
		
		
		//HashMap<String, String> colnames = new HashMap<>();
		//colnames.put("ColName1", "Test1");
		//colnames.put("ColName2", "Test2");
		//return colnames;
		
	//}
	
	
	
	
	
}
