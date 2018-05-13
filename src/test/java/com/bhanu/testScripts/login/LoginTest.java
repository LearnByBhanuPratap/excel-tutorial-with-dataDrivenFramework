package com.bhanu.testScripts.login;

import org.testng.SkipException;
import org.testng.TestNGException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bhanu.pageObjects.home.Home;
import com.bhanu.pageObjects.login.Login;
import com.bhanu.testBase.DataSource;
import com.bhanu.testBase.TestBase;

public class LoginTest extends TestBase{
	
	Login login;
	Home home;
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		String[][] data = getExcelData("demo.xlsx", "loginData");
		return data;
	}
	
	@BeforeClass
	public void beforeClass(){
		getApplicationURL(DataSource.OR.getProperty("url"));
		login = new Login(driver);
	}
	
	
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		Home homePage = login.loginToApplication(userName, password);
		homePage.logout();
		System.out.println("implicite wait is: "+System.getProperty("implicitWait"));
	}

}
