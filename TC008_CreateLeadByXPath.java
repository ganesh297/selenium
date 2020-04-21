package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC008_CreateLeadByXPath {

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
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Test Leaf");
		driver.findElement(By.xpath("//a/img[@alt='Lookup']")).click();
		
		String parentWindow=driver.getWindowHandle();
		//Navigate to second window
		for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);		    
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-groupName']/a)[1]")).click();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Ganesh");	
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("M");		
		WebElement source=driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		Select sourceSelect=new Select(source);
		sourceSelect.selectByVisibleText("Conference");
		
		
		WebElement MC=driver.findElement(By.xpath("//select[@id='createLeadForm_marketingCampaignId']"));
		Select MCSelect=new Select(MC);
		MCSelect.selectByVisibleText("Affiliate Sites");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Test Message");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastNameLocal']")).sendKeys("Test Message");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_personalTitle']")).sendKeys("Test Message");
		driver.findElement(By.xpath("//a/img[@id='createLeadForm_birthDate-button']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr/td[text()='2'])[1]")).click();
		
		WebElement industry=driver.findElement(By.xpath("//select[@id='createLeadForm_industryEnumId']"));
		Select industrySelect=new Select(industry);
		industrySelect.selectByVisibleText("Aerospace");
		
		
		
		WebElement ownership=driver.findElement(By.xpath("//select[@id='createLeadForm_ownershipEnumId']"));
		Select ownershipSelect=new Select(ownership);
		ownershipSelect.selectByVisibleText("Sole Proprietorship");
		
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Test Message");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(3000);
		
		String name=driver.findElement(By.xpath("(//td/span[text()='Company Name']/following::td/span)[1]")).getText();
		String AccountID= name.replaceAll("[^0-9]", "");
		System.out.println("Account ID is "+AccountID.trim());	
		
		String Acc[]=name.split("\\(");
		String Acc1[]=Acc[1].split("\\)");
		String AccID=Acc1[0].trim();
		
		System.out.println("Account ID is "+AccID);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(AccID);

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		
		int record=driver.findElements(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).size();
		
		System.out.println(record);
		
		if(record==0){
			
		System.out.println("Record is deleted");
		}
		else{
			System.out.println("Record is not deleted");
				
			
		}
		
		String title=driver.getTitle();
		System.out.println("Title of the Page is: "+title);
		
		//driver.close();
		
	}

}
