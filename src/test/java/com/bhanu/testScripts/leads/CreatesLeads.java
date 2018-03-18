package com.bhanu.testScripts.leads;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bhanu.pageObjects.Leads.Leads;
import com.bhanu.pageObjects.home.Home;
import com.bhanu.pageObjects.login.Login;
import com.bhanu.testBase.DataSource;
import com.bhanu.testBase.TestBase;

public class CreatesLeads extends TestBase {

	Login login;
	Home home;

	@DataProvider(name = "testData")
	public Object[][] testData() {
		String[][] data = getExcelData("demo.xlsx", "leadsData");
		return data;
	}

	@BeforeClass
	public void beforeClass() {
		getApplicationURL(DataSource.OR.getProperty("url"));
		login = new Login(driver);
	}

	@Test(dataProvider="testData")
	public void testCreateLead(String userName, String password, String type, String firstName, String lastName, String company, String designation, String leadSource, String industry, String annualrevenue, String noofemployees, String street,
			String postalCode, String country, String description, String phone, String mobile, String email, String leadStatus, String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		home = login.loginToApplication(userName, password);
		Leads leads = home.navigateToLeads();
		leads.createLeads(type, firstName, lastName, company, designation, leadSource, industry, annualrevenue, noofemployees, street, postalCode, country, description, phone, mobile, email, leadStatus);
		home.logout();
	}

}
