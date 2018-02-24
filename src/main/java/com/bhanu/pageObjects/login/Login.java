package com.bhanu.pageObjects.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bhanu.helper.logger.LoggerHelper;

public class Login {

	public WebDriver driver;
	
	private static Logger log = LoggerHelper.getLogger(Login.class);
	
	
	@FindBy(xpath="//input[@name='user_name']")
	WebElement userName;
	
	
	public void setUserName(String userName){
		log.info("entering user Name: "+userName);
		this.userName.sendKeys(userName);
	}
}
