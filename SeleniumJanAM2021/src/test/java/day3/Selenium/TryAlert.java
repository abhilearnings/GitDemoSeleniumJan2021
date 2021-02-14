package day3.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//BrowsersDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");
		driver.findElement(By.id("simple")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirm")).click();
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("prompt")).click();
		driver.switchTo().alert().sendKeys("Abhi");
		driver.switchTo().alert().accept();
		driver.close();
		

	}

}
