package com.selenium.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC0014_MergeLead {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();			
		driver.findElement(By.xpath("//a[text()='Leads']")).click();			
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();		
		driver.findElement(By.xpath("(//img[@alt='Lookup']//parent::a)[1]")).click();
		Thread.sleep(3000);
		
		Set<String> windows1=driver.getWindowHandles();
		List<String> windows1List=new ArrayList<String>();
		windows1List.addAll(windows1);
		System.out.println(windows1.size());
		driver.switchTo().window(windows1List.get(1));
		Thread.sleep(5000);		
		driver.findElement(By.name("firstName")).sendKeys("Gopi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='10323']")).click();
	
		
		driver.switchTo().window(windows1List.get(0));
		Thread.sleep(3000);	
		
		
		driver.findElement(By.xpath("(//img[@alt='Lookup']//parent::a)[2]")).click();
		Thread.sleep(3000);
		
		Set<String> windows2=driver.getWindowHandles();
		List<String> windows2List=new ArrayList<String>();
		windows2List.addAll(windows2);
		driver.switchTo().window(windows2List.get(1));
		Thread.sleep(5000);		
		driver.findElement(By.name("firstName")).sendKeys("Vishwa");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='10033']")).click();
		
		
		driver.switchTo().window(windows2List.get(0));
		Thread.sleep(3000);	
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Test.png"));
		
		String name=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(name);
		
				
	}

}
