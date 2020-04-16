package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC005_CreateAccountByXPath {

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
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Ganesh");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Ganesh");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("M");
		
		WebElement source=driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		Select sourceSelect=new Select(source);
		sourceSelect.selectByVisibleText("Conference");
		
		WebElement industry=driver.findElement(By.xpath("//select[@id='createLeadForm_industryEnumId']"));
		Select industrySelect=new Select(industry);
		industrySelect.selectByVisibleText("Aerospace");
		
		WebElement ownership=driver.findElement(By.xpath("//select[@id='createLeadForm_ownershipEnumId']"));
		Select ownershipSelect=new Select(ownership);
		ownershipSelect.selectByVisibleText("Sole Proprietorship");
		
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Test Message");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(3000);
		
		String title=driver.getTitle();
		System.out.println("Title of the Page is: "+title);
		//driver.close();
		
	}

}
