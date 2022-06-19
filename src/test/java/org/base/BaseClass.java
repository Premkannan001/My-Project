package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
    public static WebDriver driver;
	
	//Browser Launch
//	public static WebDriver browserLaunch() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		return driver;
//	}
    
    // Browser Launch select by if else
//    public static WebDriver browserLaunch(String browserName) {
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("firebox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else{
//			System.out.println("invalid browser");
//		}
//		return driver;	
//	}
	
    // Browser Launch select by switch case
    public static WebDriver browserLaunch(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;	

		default:
			System.out.println("invalid browser");
			break;
		}
		return driver;

	}
	
	// Url Lauch
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	// Maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	// implicitlyWait
	public static void implicitlyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
	
	
    // WebDriver methods
	// 1.close
	public static void close() {
		driver.close();
	}
	
	// 2.getcurrentUrl
	public static String getcurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	// 3.getTitle
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	// 4.quit
	public static  void quit() {
		driver.quit();
	}
	
	
	
	// WebElement Method
    // 1.findElement
	
	public static WebElement findElement(String locatorName,String value) {
		WebElement findElement=null;
		if(locatorName.equals("id")) {
		findElement = driver.findElement(By.id(value));
		}
		else if(locatorName.equals("name")) {
	        findElement = driver.findElement(By.name(value));
	        }
		else if(locatorName.equals("xpath")) {
		    findElement = driver.findElement(By.name(value));
		    }
		else if(locatorName.equals("tagName")) {
		    findElement = driver.findElement(By.name(value));
		    }
		else if(locatorName.equals("name")) {
		    findElement = driver.findElement(By.name(value));
		    }
		else if(locatorName.equals("name")) {
		    findElement = driver.findElement(By.name(value));
		    }
		else if(locatorName.equals("name")) {
		    findElement = driver.findElement(By.name(value));
		    }
		return findElement;	
	}
   //sendkeys     
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	//click
	public static void click(WebElement e) {
		e.click();

	}
   //Alert	
//	public static Alert alert() {
//        Alert a= driver.switchTo().alert();
//		return a;
//	}
	public static void accept() {
		 Alert a= driver.switchTo().alert();
		 a.accept();
	}
	public static void dismiss() {
		 Alert a= driver.switchTo().alert();
		 a.dismiss();
	}
	public  static String gettext() {
		Alert a=driver.switchTo().alert();
		String text = a.getText();
		return text;
	}
	public static void sendkeysAlert(String value) {
		Alert a=driver.switchTo().alert();
		a.sendKeys(value);
	}
	private void get(String script, String args) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(script, args);
	}
	
	
		
	
	
	
//	public static String getExcelData(String name, String Sheetname, int rowNo, int cellNo) throws IOException {
//		 File loc=new File("C:\\project\\MavenProject\\src\\test\\resources\\"+name+".xlsx");
//		
//	     FileInputStream fi=new FileInputStream(loc);
//	   
//	     Workbook w=new XSSFWorkbook(fi);
//	     
//	     Sheet s = w.getSheet(Sheetname);
//	    
//	     Row r = s.getRow(rowNo);
//	     
//	     Cell cell = r.getCell(cellNo);
//	     
//	     int type = cell.getCellType(); 
//	     
//	     String value=null;
//	     if(type==1 ) {
//		    	value = cell.getStringCellValue();
//		    }
//		    else {
//		    	 if(DateUtil.isCellDateFormatted(cell)) {
//		    		 SimpleDateFormat si=new SimpleDateFormat("dd-MMM-yyyy");
//		    		 value = si.format(cell.getDateCellValue());
//		    	 }
//		    	 else {
//		    		 value = String.valueOf((long)cell.getNumericCellValue());
//		    	 }
//	
//		    }
//		return value;
//	}
	
	public static Boolean specifiedUrlWait(int sec, String value) {
		WebDriverWait ww=new WebDriverWait(driver, sec);
		Boolean until = ww.until(ExpectedConditions.urlContains(value));
		return until;
	}
	
	
	public static void assertTrue(String message, boolean condition) {
		Assert.assertTrue(message, condition);
	}
	
	
	
	
	
	
	
	
}
