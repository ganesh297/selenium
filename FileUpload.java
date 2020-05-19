package com.selenium.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	 public static void main(String[] args) throws InterruptedException, IOException {
		 System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
			
		 driver.get("http://demo.automationtesting.in/Register.html");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  WebElement button=driver.findElement(By.xpath("//input[@id='imagesrc']"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		 // executor.executeScript("arguments[0].scrollIntoView(true);",button);
				
		 // Thread.sleep(2000);
			
		  Thread.sleep(5000);
		  
		  //round1- first file
		  try{
			  
			  driver.findElement(By.xpath("//input[@id='imagesrc']")).click();
		
		//  driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys(Keys.ENTER);
			
		  }catch(Exception e){
			   
			  executor.executeScript("arguments[0].click();", button);
				  
		  }
		  
		  //driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys(Keys.ENTER);
			
		  
		  Thread.sleep(5000);
		  Runtime.getRuntime().exec("D:\\fileupload.exe"+" "+ "D:\\butterfly.jpg");
		  
		  
		 // driver.quit();
		  
		
				  
		 /* AutoIT script

		  Sleep(500)
		  ControlFocus("File Upload","","Edit1")
		  Sleep(500)
		  ControlSetText("File Upload","","Edit1",$CmdLine[1])
		  Sleep(500)
		  ControlClick("File Upload","","Button1")
		  Sleep(500)

*/		  
		 }


}
