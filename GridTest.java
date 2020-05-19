package com.selenium.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		/*GRID
		----
		1. Go to path where jar is available
		2. CMD
		3. Type the below command
			java -jar selenium-server-standalone-3.141.59.jar -role hub
		4. To check the Grid is running, hit the below URL
			http://192.168.67.2:4444/
			
		5. Open new CMD where drivers are available
		6. Type the below command
			java -Dwebdriver.chrome.driver="D:\Webdrivers\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.67.2:4444/grid/register
*/		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		
		String hubURL="http://192.168.67.2:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(hubURL),options);
		
		driver.get("https://www.javatpoint.com/");
		System.out.println(driver.getTitle());
		
	}

}
