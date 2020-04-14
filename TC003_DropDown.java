package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC003_DropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.xpath("//*[@id='button']/a/img")).click();
		driver.findElement(By.linkText("Accounts")).click();
		
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.name("industryEnumId")).sendKeys("Aerospace");
		
		
		WebElement own=driver.findElement(By.name("ownershipEnumId"));
		Select ownSelect=new Select(own);
		ownSelect.selectByIndex(2);
		
		
		WebElement source=driver.findElement(By.name("dataSourceId"));
		Select sourceSelect=new Select(source);
		sourceSelect.selectByVisibleText("Cold Call");
		
		
		WebElement initialTeam=driver.findElement(By.name("initialTeamPartyId"));
		Select initialTeamSelect=new Select(initialTeam);
		initialTeamSelect.selectByValue("DemoSalesTeam2");
		
		
		
		driver.close();
		
	}

}
