package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC0012_Alert {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//TEXTBOX
		System.out.println("**************************************");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a/h5[text()='Alert']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a/h5[text()='Alert']")).click();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		driver.switchTo().alert().sendKeys("Ganesh");
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		String text=driver.switchTo().alert().getText();
		if(text.contains("\n")){
			System.out.println("It has mult line");
		}else{
			System.out.println("It has single line");
		}
		
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
		
		
	}

}
