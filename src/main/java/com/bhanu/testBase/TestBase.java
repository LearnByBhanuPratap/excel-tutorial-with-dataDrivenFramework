package com.bhanu.testBase;

import org.apache.log4j.Logger;

import com.bhanu.helper.logger.LoggerHelper;

public class TestBase {
	
	public static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	public static void main(String[] args) {
		log.info("test log");
	}

}
