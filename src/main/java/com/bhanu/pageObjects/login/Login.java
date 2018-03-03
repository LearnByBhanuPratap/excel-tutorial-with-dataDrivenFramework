package com.bhanu.pageObjects.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhanu.helper.logger.LoggerHelper;
import com.bhanu.helper.waitHelper.WaitHelper;
import com.bhanu.pageObjects.home.Home;
import com.bhanu.testBase.DataSource;

public class Login {

	private WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(Login.class);

	@FindBy(xpath = "//input[@name='user_name']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='user_password']")
	WebElement password;
	
	@FindBy(id = "submitButton")
	WebElement loginButton;


	public Login(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(userName, DataSource.getExplicitWait());
	}


	public void setUserName(String userName) {
		log.info("entering user Name: " + userName);
		this.userName.sendKeys(userName);
	}

	public void setPassword(String password) {
		log.info("entering password: " + password);
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		log.info("clicking login button");
		loginButton.click();
	}

	public Home loginToApplication(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickLogin();
		return new Home(driver);
	}
	
	
}
