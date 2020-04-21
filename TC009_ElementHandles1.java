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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC009_ElementHandles1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//TEXTBOX
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='Edit']")).click();
		driver.findElement(By.id("email")).sendKeys("Ganesh");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Test Message");

		String text=driver.findElement(By.xpath("(//input[@name='username'])[1]")).getText();
		System.out.println(text);

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		boolean status=driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		System.out.println(status);

		driver.navigate().back();


		//BUTTON
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='Button']")).click();

		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();

		driver.findElement(By.xpath("//a/h5[text()='Button']")).click();

		WebElement position=driver.findElement(By.xpath("//button[text()='Get Position']"));

		Point point = position.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");

		String color=	driver.findElement(By.xpath("//button[text()='What color am I?']")).getCssValue("color");
		System.out.println(color);

		WebElement s=driver.findElement(By.xpath("//button[text()='What is my size?']"));

		Dimension size = s.getSize();
		System.out.println("Width : " + size.width);
		System.out.println("Height : " + size.height);

		driver.navigate().back();

		//HYPERLINK
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='HyperLink']")).click();

		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();

		driver.findElement(By.xpath("//a/h5[text()='HyperLink']")).click();

		String href=driver.findElement(By.partialLinkText("Find where am supposed")).getAttribute("href");
		System.out.println(href);

		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();

		String title=driver.getTitle();

		if(title.equalsIgnoreCase("HTTP Status 404 – Not Found")){
			System.out.println("Page is broken");
		}
		else{
			System.out.println("Page is not broken");

		}

		driver.navigate().back();
		
		
		//HYPERLINK
		System.out.println("**************************************");

		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();

		driver.findElement(By.xpath("//a/h5[text()='HyperLink']")).click();

		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkSize=links.size();
		System.out.println(linkSize);

		for(WebElement link:links){
			System.out.println("Link Name:"+link.getText());
		}

		driver.navigate().back();

		//DROP DOWN
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='Drop down']")).click();

		WebElement DD1=driver.findElement(By.id("dropdown1"));
		Select DD1Select=new Select(DD1);
		DD1Select.selectByIndex(1);

		WebElement DD2=driver.findElement(By.name("dropdown2"));
		Select DD2Select=new Select(DD2);
		DD2Select.selectByVisibleText("Selenium");

		WebElement DD3=driver.findElement(By.id("dropdown3"));
		Select DD3Select=new Select(DD3);
		DD3Select.selectByValue("1");


		WebElement DD4=driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select DD4Select=new Select(DD4);

		List<WebElement> lists=DD4Select.getOptions();
		System.out.println("Drop Down Size: "+lists.size());

		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Selenium");

		driver.findElement(By.xpath("(//select/option[text()='Selenium'])[6]")).click();

		driver.navigate().back();

		//RADIO BUTTON
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='Radio Button']")).click();

		driver.findElement(By.xpath("//input[@id='yes']")).click();

		List<WebElement> RBs=driver.findElements(By.xpath("//input[@name='news']"));
		int RBSize=RBs.size();
		for(int i=1;i<=RBSize;i++){
			boolean RBStatus=driver.findElement(By.xpath("(//input[@name='news'])["+i+"]")).isSelected();
			if(RBStatus==true){
				System.out.println(i+"nd Radio Button is Selected");
			}
		}

		List<WebElement> ageRB=driver.findElements(By.xpath("//input[@name='age']"));
		int AgeRBSize=ageRB.size();
		for(int i=1;i<=AgeRBSize;i++){
			boolean AgeRBStatus=driver.findElement(By.xpath("(//input[@name='age'])["+i+"]")).isSelected();
			if(AgeRBStatus==false){
				driver.findElement(By.xpath("(//input[@name='age'])["+i+"]")).click();
			}
		}
		driver.navigate().back();

		//CHECKBOX
		System.out.println("**************************************");
		driver.findElement(By.xpath("//a/h5[text()='Checkbox']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]/input")).click();   //DOUBT
		Thread.sleep(2000);

		boolean CB2Status=	driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input")).isSelected();
		System.out.println(CB2Status);	

		Thread.sleep(2000);

		List<WebElement> CB3=driver.findElements(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div"));
		int CB3Size=CB3.size();
		for(int i=1;i<=CB3Size;i++){
			boolean CB3Status=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div["+i+"]/input")).isSelected();
			Thread.sleep(2000);

			if(CB3Status==true){
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div["+i+"]/input")).click();
			}
		}

		List<WebElement> CB4=driver.findElements(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div"));
		int CB4Size=CB4.size();
		for(int i=1;i<=CB4Size;i++){
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div["+i+"]/input")).click();

		}

		driver.navigate().back();

		//WAIT TO DISAPPEAR
		System.out.println("**************************************");
		Thread.sleep(2000);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a/h5[text()='Wait to Disappear']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//a/h5[text()='Wait to Disappear']")).click();
		WebDriverWait wait1=new WebDriverWait(driver,15);
		Boolean Disappear=wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button/b[contains(text(),'disappear. Keep looking at me')]")));
		if(Disappear==true){
			String textAfterDisappear=driver.findElement(By.xpath("//p/strong[contains(text(),' I know you can do it! Button is disappeared!')]")).getText();
			System.out.println(textAfterDisappear);
		}

		driver.navigate().back();
		Thread.sleep(2000);

		//WAIT TO DISAPPEAR
		System.out.println("**************************************");
		WebElement element2 = driver.findElement(By.xpath("//a/h5[text()='Wait to Appear']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element2);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a/h5[text()='Wait to Appear']")).click();

		WebElement appear=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/b[contains(text(),'here Guys')]")));
		boolean buttonAppear=appear.isDisplayed();
		if(buttonAppear==true){
			int buttonSize=driver.findElements(By.xpath("//button")).size();
			System.out.println(buttonSize);
			if(buttonSize==5){
				System.out.println("All Buttons are displayed");
			}else{
				System.out.println("Expected Button is not getting displayed");

			}
		}

		
		driver.navigate().back();
		Thread.sleep(2000);

		//WAIT TO TEXT APPEAR
		System.out.println("**************************************");
		WebElement element3 = driver.findElement(By.xpath("//a/h5[text()='Wait for Text Change']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element3);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a/h5[text()='Wait for Text Change']")).click();

		WebElement buttonTextAppear=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		boolean buttonTextAppearStatus=buttonTextAppear.isDisplayed();
		if(buttonTextAppearStatus==true){
			driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
			Thread.sleep(3000);
			String alertText=driver.switchTo().alert().getText();
			System.out.println(alertText);
			driver.switchTo().alert().accept();
		}

		
	}
}
