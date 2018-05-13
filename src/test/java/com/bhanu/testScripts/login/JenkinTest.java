package com.bhanu.testScripts.login;

import org.testng.annotations.Test;

public class JenkinTest {

    @Test
	public void loginTest(){
     System.out.println("reading user Name from Jenin");
     System.out.println(System.getProperty("userName"));
     System.out.println("reading password from Jenin");
     System.out.println(System.getProperty("password"));
	}
}
