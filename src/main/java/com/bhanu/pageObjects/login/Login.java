package com.bhanu.pageObjects.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhanu.helper.logger.LoggerHelper;
import com.bhanu.pageObjects.home.Home;

public class Login {

	private WebDriver driver;

	private static Logger log = LoggerHelper.getLogger(Login.class);

	@FindBy(xpath = "//input[@name='user_name']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='user_password']")
	WebElement password;

	public Login(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void setUserName(String userName) {
		log.info("entering user Name: " + userName);
		this.userName.sendKeys(userName);
	}

	public void setPassword(String password) {
		log.info("entering password: " + password);
		this.password.sendKeys(password);
	}

	public Home loginToApplication(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		return new Home(driver);
	}
}
