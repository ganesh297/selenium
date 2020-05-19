package com.selenium.practice;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TC0016_Go {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.id("roundTrip")).click();
		//webklipper-publisher-widget-container-notification-frame
		WebElement frameNoti=driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");		
		driver.findElement(By.xpath("//i[@class='we_close']")).click();
		driver.switchTo().defaultContent();
		
		//driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Chennai", Keys.DOWN, Keys.ENTER);
		//driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Bengaluru", Keys.DOWN, Keys.ENTER );
		
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Chennai");
		Thread.sleep(3000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Bengaluru");
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(date.format(formatter));
		
		String dateSplit[]=date.format(formatter).split("-");
		String date1=dateSplit[0];
		int date1Int=Integer.parseInt(date1);
		int date2Int=date1Int+1;
		System.out.println(date2Int);

		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='30']")).click();
		
		//driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.id("returnCalendar")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='1']")).click();
		
		driver.findElement(By.id("pax_link_common")).click();
		Thread.sleep(3000);
		
		WebElement type=driver.findElement(By.id("gi_class"));
		Select typeSelect=new Select(type);
		typeSelect.selectByVisibleText("Business");
		
		
		driver.findElement(By.id("gi_search_btn")).click();
		
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath("//div[@class='popBodyChildContent marginT10']/div")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//button[@class='button blue small fr Ok']")).click();
		///////////////////////////////////////////////////////////////////////////////////////
		
		
		
	/*	String url = "https://www.goibibo.com/";
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--diable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Round Trip
        driver.findElementByXPath("//span[text()='Round trip']").click();

        // Switch to frame to handle green Pop up
        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        // pop up
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElementByXPath("//div[@class='close tablecell']//i[1]/.."))).click();
        driver.switchTo().defaultContent();

        // Enter From
        WebElement src = driver.findElementByXPath("(//span[text()='Multicity']/following::input)[1]");
        src.sendKeys("Chennai");
        Thread.sleep(4000);
        src.sendKeys(Keys.DOWN,Keys.ENTER);
     // Enter Destination
        WebElement dest = driver.findElementByXPath("//input[@placeholder='Destination']");
        dest.sendKeys("Bengaluru");
        Thread.sleep(4000);
        dest.sendKeys(Keys.DOWN, Keys.ENTER);

        // DATE
        Date date = new Date();
        // Get the current date
        System.out.println("Current date is : " + date);
        // Get only the date (and not month, year, time etc)
        DateFormat sdf = new SimpleDateFormat("dd");
        // Get today's date
        String today = sdf.format(date);
        // Convert to integer and add 1 to it
        int tomorrow = Integer.parseInt(today) + 1;
        // Print tomorrow's date
        System.out.println("Tomorrow's date is : " + tomorrow);
        String date1 = Integer.toString(tomorrow);
        System.out.println("String converted date is : " + date1);
        Thread.sleep(3000);

        // choose departure
        driver.findElementById("departureCalendar").click();
        driver.findElement(By.xpath("//div[text()='28']")).click();

        // choose return
        driver.findElementById("returnCalendar").click();
       
        driver.findElementByXPath("//span[text()=\" Economy\"]").click();

        // Select DropDown TravelClass
        WebElement tclass = driver.findElementById("gi_class");
        Select tc = new Select(tclass);
        tc.selectByVisibleText("Business");

        // Click on search button
        driver.findElementById("gi_search_btn").click();

        // Pop up text
        String sorryNoFlights = driver.findElement(By.xpath("//div[@class='popBodyChildContent marginT10']//div[1]"))
                .getText();
        System.err.println(sorryNoFlights);
*/				
	}
}
