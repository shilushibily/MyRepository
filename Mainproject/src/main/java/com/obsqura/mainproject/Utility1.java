package com.obsqura.mainproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utility1 {
public static WebDriver driver;
JavascriptExecutor js;
private Object FileUtils;

public WebDriver utility(String url,String browser)
{
switch(browser.toLowerCase()) {
/////////////url////////////////////////

case "ie":
	System.setProperty("webdriver.ie.driver","F:\\Selenium\\IEDriverServer.exe");
	driver=new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.get(url);
case "chrome":
	System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
     //  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
  
}
return driver;  

}
//////////////////////////////////click///////////////////////////


public String ReadExcel(int r, int c)throws IOException {
	// TODO Auto-generated method stub
	String value="";
	
	FileInputStream obj=new FileInputStream("C:\\Users\\HP\\Desktop\\main.xlsx");
	XSSFWorkbook objbook=new XSSFWorkbook(obj);
	XSSFSheet objsheet=objbook.getSheet("Sheet1");
	XSSFRow objrow=objsheet.getRow(r);
	XSSFCell objcell=objrow.getCell(c);
	CellType objtype=objcell.getCellType();
	if(objtype==CellType.NUMERIC)
	{
		
	double value1=objcell.getNumericCellValue();
	String str=String.valueOf(value1);
	return str;
	}
	else if(objtype==CellType.STRING)
	{
		value=objcell.getStringCellValue();
		}
	return value;
}
public void click(By property)
{
driver.findElement(property).click();

}
//////////////////sendkeys////////////////////////////////////
public void sendkeys(By property,String value)
{
driver.findElement(property).sendKeys(value);
}
///////////////////wait//////////////////////////////
public void implicitywait()
{
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

//////////////////////screenshot///////////////////////////////////
public void takescreenshot()
{

File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
//FileUtils.copyFile(src, new File("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots"+System.currentTimeMillis()+".png"));
}
catch(Exception e) {
}
}
////////////////////////////scroll up/////////////////////////

public void scrollup(int a, int b) 
{
js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(a,b)");
}
////////////////////////////scroll down////////////////////////////

public void scrolldown(int a, int b)
{
js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(a,b)");
}
public static void handleSleep(int i)
{
	// TODO Auto-generated method stub
	
}

}







