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

public class TC0010_DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//DRAGGABLE
		System.out.println("**************************************");

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a/h5[text()='Draggable']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a/h5[text()='Draggable']")).click();
		Point p=	driver.findElement(By.id("mydiv")).getLocation();
		int x=p.getX();
		int y=p.getY();


		Actions actions=new Actions(driver);
		//Thread.sleep(5000);
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		System.out.println(source.getLocation());


		actions.dragAndDropBy(source, 300, 300).build().perform();
		Thread.sleep(10000);
		driver.navigate().back();










		//DROPPABLE
		WebElement element1 = driver.findElement(By.xpath("//a/h5[text()='Droppable']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element1);
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a/h5[text()='Droppable']")).click();

		Actions actions1=new Actions(driver);
		WebElement source1=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest1=driver.findElement(By.xpath("//div[@id='droppable']"));		
		actions1.dragAndDrop(source1, dest1).build().perform();


		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(10000);
		WebElement elect=driver.findElement(By.xpath("//span[text()='Electronics']"));
		//Actions actions3=new Actions(driver);

		actions.moveToElement(elect).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[text()='Mi'])[1]")).click();
		Thread.sleep(5000);

		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Mi")){
			System.out.println("Test Case Passed");
		}else{

			System.out.println("Test Case Failed");
		}




	}
}
