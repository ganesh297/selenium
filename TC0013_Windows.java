package com.selenium.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC0013_Windows {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//TEXTBOX
		System.out.println("**************************************");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a/h5[text()='Window']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a/h5[text()='Window']")).click();
		
		driver.findElement(By.id("home")).click();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Test.png"));
		
		Set<String> windowsSet=driver.getWindowHandles();
		List<String> windowsList=new ArrayList<String>();
		windowsList.addAll(windowsSet);
		
		String childWindow=windowsList.get(1);
		driver.switchTo().window(childWindow);
		driver.close();
		
		String parentWindow=windowsList.get(0);
		driver.switchTo().window(parentWindow);
		//driver.close();
		
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> windowsSet1=driver.getWindowHandles();
		List<String> windowsList1=new ArrayList<String>();
		windowsList1.addAll(windowsSet1);
		
		System.out.println("Window Size: "+windowsList1.size());
		
		for(int i=1;i<windowsList1.size();i++){
			driver.switchTo().window(windowsList1.get(i));
			driver.close();
		}
		
		driver.switchTo().window(windowsList1.get(0));
		
		////////////////////////////////////////////////////////////
		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		Set<String> windowsSet2=driver.getWindowHandles();
		List<String> windowsList2=new ArrayList<String>();
		windowsList2.addAll(windowsSet2);
		
		System.out.println("Window Size: "+windowsList2.size());
		
		for(int i=1;i<windowsList2.size();i++){
			driver.switchTo().window(windowsList2.get(i));
			driver.close();
		}
		
		driver.switchTo().window(windowsList2.get(0));
		
		
		
	}

}
