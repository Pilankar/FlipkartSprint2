package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base extends DecryptPassword {
	static WebDriver driver;
	
	protected static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pilan\\eclipse-workspace\\SeleniumProjects\\Driver\\chromedriver.exe");
		
		//Launch the browser
		driver = new ChromeDriver();
		return driver;
	}
	
	protected static void type(WebElement element, String val) {
		element.sendKeys(val);
	}
	
	protected static void getUrl(String url) {
		driver.get(url);
	}
	
	protected static void maximize() {
		driver.manage().window().maximize();
	}
	
	protected static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	protected static void loadUrl(String url) {
		driver.get(url);
		maximize();
	}
	
	protected static void btnClick(WebElement element) {
		element.click();
	}
	
	protected static void quit() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
	
	protected static String getData(int r, int c) throws IOException {
		String value= null;
		
		File loc = new File("C:\\Users\\pilan\\eclipse-workspace\\Sprint2Demo\\ExcelData\\FlipkartLoginData.xlsx");

		FileInputStream fs = new FileInputStream(loc);
			
		Workbook workbook = new XSSFWorkbook(fs);
			
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Row row = sheet.getRow(r);
		
		Cell cell = row.getCell(c);
		
		int type = cell.getCellType();
		
		switch(type) {
			case 0: 
				// Number
				if(!DateUtil.isCellDateFormatted(cell)) {
					double getNum = cell.getNumericCellValue();
					long longNum = (long) getNum;
					value = String.valueOf(longNum);
				}
				break;
				
			case 1: 
				value = cell.getStringCellValue();
				break;
		}
		
		return value;
	}
	
	protected static String decryptPsw(String psw) {
		String decryptedString = decrypt(psw);
		return decryptedString;
	}
}
