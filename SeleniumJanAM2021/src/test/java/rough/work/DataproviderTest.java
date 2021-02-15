package rough.work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class DataproviderTest {
	
	@Test(dataProvider="htwtset")
	public void calculateBMI(String htset , String wtset){
		System.setProperty("webdriver.chrome.driver", ".//BrowsersDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
		driver.findElement(By.id("heightCMS")).sendKeys(htset);
		driver.findElement(By.id("weightKg")).sendKeys(wtset);
		driver.findElement(By.id("Calculate")).click();
		// click("calculate");
		// sendkeys("ht" , "170");
	}
	
	@DataProvider (name = "htwtset" , parallel=true)
	public Object[][] generateDatahtwt(){
		
		//String[][] values = {{"170" , "89"},{"189","56"},{"177","23"}};
		// we want to write some code which will take the test data from xls ;
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\Resources\\Testdata\\Testdata.xlsx");
		String sheetName = "Sheet1";;
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		System.out.println("Data---" + excel.getCellData(sheetName, 0, 1));
		System.out.println("Total rows are" + rowNum + "----------Total cols are" + colNum);
		Object[][] data = new Object[rowNum - 1][colNum];
		for (int rows = 2; rows <= rowNum; rows++) {
			for (int cols = 0; cols < colNum; cols++) {
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		
		return data;
	}

}
