package com.bhanu.pageObjects.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhanu.helper.logger.LoggerHelper;
import com.bhanu.helper.waitHelper.WaitHelper;
import com.bhanu.pageObjects.Leads.Leads;
import com.bhanu.pageObjects.login.Login;
import com.bhanu.testBase.DataSource;

public class Home {

	private static Logger log = LoggerHelper.getLogger(Home.class);
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	@FindBy(xpath="//img[@title='vtiger-crm-logo.gif']")
    WebElement vtigerHomePageLogo;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement logout;
	
	@FindBy(linkText="Sign Out")
	WebElement signOut;
	
	@FindBy(linkText = "Leads")
	WebElement leads;
	
	
	public Home(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(vtigerHomePageLogo, DataSource.getExplicitWait());
	}
	
	public Login logout() {
		log.info("performing mouse over...");
        Actions action = new Actions(driver);
        action.moveToElement(logout).build().perform();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		signOut.click();
		log.info("clicked on signout...");
		return new Login(driver);
	}
	
	/**
	 * 
	 * @return {@link Leads}
	 */
	public Leads navigateToLeads(){
		log.info("navigating to leads");
		leads.click();
		return new Leads(driver);
	}

}
