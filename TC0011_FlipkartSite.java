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

public class TC0011_FlipkartSite {

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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Apple'])[1]"))).isDisplayed();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[text()='Apple'])[1]")).click();
		Thread.sleep(5000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//img[@alt='iPhone 8 Plus X3 for Store']/ancestor::a"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(5000);		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='iPhone 8 Plus X3 for Store']/ancestor::a"))).click();
		Thread.sleep(5000);		
		
		String price=driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
		System.out.println("First Product Prize is "+price);
		
	List<WebElement>names=driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div"));
	int nameSize=names.size();
	System.out.println(nameSize);
	for(int i=2; i<nameSize;i++){
		
String MN=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div["+i+"]/div/div/div/a/div[2]/div[1]/div[1]")).getText();

	System.out.println(MN);
	}
		
		



	}
}
