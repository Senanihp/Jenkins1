package framework_Utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility_Methods {
	 //Utility method for Send Keys
	public static void Enter_value_in_editfield(WebElement element,String value) {
		element.sendKeys(value);
	
	}
	//Utility Method for click
	public static void clicked(WebElement element) {
    element.click();
	}
	public static void select_by_index(WebElement element,int index) {
		Select options=new Select (element);
		options.selectByIndex(index);
		}
	public static void select_by_VisibleText(WebElement element,String value) {
		Select options=new Select (element);
		options.selectByVisibleText(value);
	}
	public static void select_by_value(WebElement element,String value) {
		Select options=new Select (element);
		options.selectByValue(value);
}
	public static Actions ActionsUtility(WebDriver driver) {
		Actions a=new Actions (driver);
		return a;
		}
	public static String Test_config() throws IOException {
	String filepath="./Test_Configuration/TestConfiguration.properties";
	FileInputStream fis=new FileInputStream(filepath);
    Properties prop=new Properties();
    prop.load(fis);
    String url=prop.getProperty("URL");
    return url;
}
	public static Object[][] GetTestData(String Sheetname) throws IOException {
		String filepath="./Test_Data/Test_Data.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		
		//Create object for excel file
		Workbook book=new XSSFWorkbook(fis);
		
		//Access the sheet
		Sheet sheet=book.getSheet(Sheetname);
		
		//Get row count and column count
		int rowcount=sheet.getPhysicalNumberOfRows();
		int col_count=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowcount);
		System.out.println(col_count);
		Object[][] data=new Object[rowcount-1][col_count];
		//Print all the rows and columns
		for(int row=1;row<=rowcount-1;row++) {
			for(int col=0;col<=col_count-1;col++) {	
		data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
			
			}
		}
		book.close();
		return data; 
	}
}
