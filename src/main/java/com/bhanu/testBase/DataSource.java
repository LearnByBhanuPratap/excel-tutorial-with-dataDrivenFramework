package com.bhanu.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bhanu.helper.logger.LoggerHelper;
import com.bhanu.utility.ResourceHelper;

public class DataSource {

	private static Logger log = LoggerHelper.getLogger(DataSource.class);

	public static Properties OR;

	private String browerType;
	private String userName;
	private String password;
	private String url;
	long implicitWait;
	long explicitWait;
	long pageLoadTime;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBrowerType() {
		return browerType;
	}

	public void setBrowerType(String browerType) {
		this.browerType = browerType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static long getImplicitWait() {
		// this is used to read data from properties file
		//return Integer.parseInt(OR.getProperty("implicitWait"));
		// to read same data from Jenkin parameters
		System.out.println(System.getProperty("implicitWait"));
		return Integer.parseInt(System.getProperty("implicitWait"));
	}

	public static long getExplicitWait() {
		// this is used to read data from properties file
		//return Integer.parseInt(OR.getProperty("explicitWait"));
		// to read same data from Jenkin parameters
		System.out.println(System.getProperty("explicitWait"));
		return Integer.parseInt(System.getProperty("explicitWait"));
	}

	public static long getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageLoadTime"));
	}


	static {
		log.info("loading config.properties..");
		OR = new Properties();
		File f1 = new File(ResourceHelper.getResourcePath("/src/main/resources/projectConfig/config.properties"));
		try {
			FileInputStream file = new FileInputStream(f1);
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("loading config.properties done");
	}

}
