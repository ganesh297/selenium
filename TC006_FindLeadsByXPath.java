package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC006_FindLeadsByXPath {

	public static void main(String[] args) throws InterruptedException {

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
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='10007']")).click();		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();	
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("TestLeaf");	
		
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_firstName']")).sendKeys("Ganesh");	
		driver.findElement(By.xpath("//input[@id='updateLeadForm_lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_lastName']")).sendKeys("Mahalingam");
		
		
		WebElement ownnership=driver.findElement(By.xpath("//select[@id='updateLeadForm_ownershipEnumId']"));
		Select ownnershipSelect=new Select(ownnership);
		ownnershipSelect.selectByVisibleText("Sole Proprietorship");
		
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).sendKeys("Selenium Automation Testing Training");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(3000);
		
		String name=driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(name);
		if(name.equalsIgnoreCase("Ganesh")){
			System.out.println("Test Case Passed");
		}else{
			System.out.println("Test Case Failed");
		}
		
		
		String title=driver.getTitle();
		System.out.println("Title of the Page is: "+title);
		//driver.close();
		
	}

}
