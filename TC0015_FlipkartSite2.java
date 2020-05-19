package com.selenium.practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC0015_FlipkartSite2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Electronics']"))).isDisplayed();
		WebElement elect=driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions actions=new Actions(driver);

		actions.moveToElement(elect).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Samsung'])[1]"))).isDisplayed();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[text()='Samsung'])[1]")).click();
		Thread.sleep(5000);
		
		List<WebElement> mobileNames=driver.findElements(By.xpath("//a[@class='_2cLu-l']"));
		List<WebElement> mobilePrices=driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
		
		
		for(WebElement mobileName:mobileNames){
			String MN=mobileName.getText();
			System.out.println(MN);
		}
		
		
		for(WebElement mobilePrice:mobilePrices){
			String Price=mobilePrice.getText();
			System.out.println(Price);
		}
		
	}
}
