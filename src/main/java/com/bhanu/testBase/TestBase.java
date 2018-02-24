package com.bhanu.testBase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bhanu.excel.tutorial.ReadDataFromExcelSheet;
import com.bhanu.helper.logger.LoggerHelper;

public class TestBase {
	
	public WebDriver driver;

	public static Logger log = LoggerHelper.getLogger(TestBase.class);

	/**
	 * This method will give excel data in 2D array based on sheet Name
	 * @param excellocation
	 * @param sheetName
	 * @return
	 */
	public String[][] getExcelData(String excellocation, String sheetName) {
		ReadDataFromExcelSheet readDataFromExcelSheet = new ReadDataFromExcelSheet();
		return readDataFromExcelSheet.getExcelData(excellocation, sheetName);
	}

	/**
	 * This method will update result in excel sheet.
	 * @param excellocation
	 * @param sheetName
	 * @param testCaseName
	 * @param testStatus
	 * @throws IOException
	 */
	public void updateResult(String excellocation, String sheetName, String testCaseName, String testStatus)
			throws IOException {
		ReadDataFromExcelSheet readDataFromExcelSheet = new ReadDataFromExcelSheet();
		readDataFromExcelSheet.updateResult(excellocation, sheetName, testCaseName, testStatus);
	}
	
	/**
	 * This method will create browser Objects.
	 * @param browser
	 * @return
	 */
	public WebDriver getBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			ChromeDriver driver = new ChromeDriver();
			return driver;
		}
		else if(browser.equalsIgnoreCase("firefox")){
			FirefoxDriver driver = new FirefoxDriver();
			return driver;
		}
		return null;
	}
}
