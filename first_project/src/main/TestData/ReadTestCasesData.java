package main.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestCasesData 
{
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell UN_V;
	
	
	public void ReadData() throws IOException
	 {
	     // Import excel sheet.
	     File src = new File("C:\\Eclipse_WorkSpace\\TC_DataFiles\\Login_FT_DF.xlsx");
	      
	     // Load the file.
	     FileInputStream finput = new FileInputStream(src);
	      
	     // Load the workbook.
	    workbook = new XSSFWorkbook(finput);
	      
	     // Load the sheet in which data is stored.
	     sheet = workbook.getSheetAt(0);
	      System.out.println("Last Row Number Is: "+sheet.getLastRowNum());
	     for(int i=1; i<=sheet.getLastRowNum(); i++)
	     {
	         // Import data for Email.
	         //XSSFCell UN_V = sheet.getRow(i).getCell(2);
	         //XSSFCell PW_V = sheet.getRow(i).getCell(3);
	         
	         Row Row_V = sheet.getRow(i);
	         String UN_V = Row_V.getCell(2).toString();
	         String PW_V = Row_V.getCell(3).toString();
	         
	          
	         //cell.setCellType(Cell.CELL_TYPE_STRING);
	         //System.out.println("Column Value Is: "+UN_V.getStringCellValue().toString());
	         //System.out.println("UserName Value Is: "+UN_V.getRichStringCellValue().toString()+" Password Value Is: "+PW_V.getRichStringCellValue().toString());
	         //System.out.println("UserName Value Is: "+UN_V+" Password Value Is: "+PW_V);
	         //driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
	         
	         
	         // Import data for password.
	         //XSSFCell PW_V = sheet.getRow(i).getCell(4);
	         //cell.setCellType(Cell.CELL_TYPE_STRING);
	         //System.out.println("Column Value Is: "+PW_V.getStringCellValue());
	         //driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
	                 
	       }
	  } 
}
