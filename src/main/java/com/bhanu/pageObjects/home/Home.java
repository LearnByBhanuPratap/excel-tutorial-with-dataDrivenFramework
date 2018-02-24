package com.bhanu.pageObjects.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home {

	private WebDriver driver;
	
	public Home(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
