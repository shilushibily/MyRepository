package com.obsqura.mainproject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InterruptedIOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TestErp {
	static WebDriver driver1;
	  Utility1 u=new Utility1();
	JavascriptExecutor js;
	SoftAssert softAssert=new SoftAssert();
  @Test(priority=0,enabled=true)
  public void login() throws InterruptedException, IOException
  {
	  WebElement username=driver1.findElement(By.id("loginform-username"));
	  username.sendKeys(u.ReadExcel(0,0));
	  WebElement password=driver1.findElement(By.id("loginform-password"));
	  password.sendKeys(u.ReadExcel(1, 0));
	  Thread.sleep(6000);
	  WebElement loginbutton=driver1.findElement(By.xpath("//*[@id=\'login-form\']/button/span"));
	  loginbutton.click();
	  Thread.sleep(8000);

  }
  
  @Test(priority=1,enabled=true)
  public void accountPage() throws InterruptedException, AWTException
  {
	  	WebElement accounts=driver1.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/a"));
	  	accounts.click();
	  	WebElement supplierinvoice=driver1.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul/li[1]/a"));
	  	supplierinvoice.click();
	  
	  	WebElement invoicenumber=driver1.findElement(By.xpath("//*[@id=\'grid-filters\']/td[2]/input"));
	  	invoicenumber.sendKeys("gst23314/02/19",Keys.ENTER);
	  
	  	Thread.sleep(8000);
	  
	  	WebElement supplierhistories=driver1.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span"));
	  	supplierhistories.click();
	 
	 	WebElement suppliername=driver1.findElement(By.xpath("//*[@id=\'w0-filters\']/td[2]/input"));
	 	suppliername.sendKeys("Raisa",Keys.ENTER);
	 	Thread.sleep(8000);
	  
	    WebElement supplierpayment=driver1.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a/span"));
		supplierpayment.click();
		WebElement createpayment=driver1.findElement(By.xpath("/html/body/div/div/section[2]/p/a"));
		createpayment.click();
		WebElement supplierselect=driver1.findElement(By.xpath("//*[@id=\'select2-supplierpayment-supplier_id-container\']"));
		supplierselect.click();
		WebElement suppliersearch=driver1.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		suppliersearch.sendKeys("appu");
		 
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(8000);
		 WebElement amount=driver1.findElement(By.xpath("//*[@id=\'supplierpayment-amount\']"));
		 amount.sendKeys("500");		
		 WebElement savebutton=driver1.findElement(By.xpath("//*[@id='w0']/div[10]/button"));
		 savebutton.click();
		 Thread.sleep(8000);
  }
  
  @Test(priority=2,enabled=true)
  
  public void clientpage() throws InterruptedException, AWTException
  {
	  WebElement clientsoption=driver1.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[4]/a"));
	  clientsoption.click(); 
	  WebElement postcode=driver1.findElement(By.xpath("//*[@id=\'w0-filters\']/td[4]/input"));
	  postcode.sendKeys("695583");
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(8000);
	  WebElement createclient=driver1.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a"));
	  createclient.click(); 
	  WebElement clientname=driver1.findElement(By.xpath("//*[@id=\'client-client_name\']"));
	  clientname.sendKeys("Shilu");
	  WebElement clientaddress=driver1.findElement(By.xpath("//*[@id=\'client-client_address\']"));
	  clientaddress.sendKeys("Vattakappara(H),Kanjirappally");
	  WebElement clientpostcode=driver1.findElement(By.xpath("//*[@id=\'client-postcode\']"));
	  clientpostcode.sendKeys("686507"); 
	  WebElement state=driver1.findElement(By.xpath("//*[@id=\'client-state\']"));
	  state.sendKeys("Kerala"); 
	  WebElement phone=driver1.findElement(By.xpath("//*[@id=\'client-phone\']"));
	  phone.sendKeys("919961548481"); 
	  WebElement email=driver1.findElement(By.xpath("//*[@id=\'client-email\']"));
	  email.sendKeys("shilu.shibily@gmail.com"); 
	  WebElement statuscheckbox=driver1.findElement(By.xpath("//*[@id='client-status']"));
	  statuscheckbox.click();
	  WebElement save=driver1.findElement(By.xpath("//*[@id='w0']/div[8]/div/button"));
	  save.click();
	  Thread.sleep(8000);
	  //WebElement updatebutton=driver1.findElement(By.xpath("/html/body/div/div/section[2]/p/a"));
	  //updatebutton.click();

	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	 
	  driver1=u.utility("https://www.qabible.in/erp/", "chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver1.close();
  }

}
