package day3.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//BrowsersDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		// switch to 3rd frame
		//driver.switchTo().frame(2); // by index 
		//driver.switchTo().frame("classFrame"); // by frame name
		driver.switchTo().frame(driver.findElement(By.name("classFrame"))); // by frame as webelement
		
		driver.findElement(By.linkText("org.openqa.selenium.devtools.events")).click();

	}

}
