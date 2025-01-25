package com.tmb.pages;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;


public class LoginPage1{
	public WebDriver driver;

	/*
	 * public LoginPage(WebDriver localDriver) { this.driver=localDriver; }
	 */
	
	public void enterCred(String url) throws MalformedURLException {
		driver = WebBase.getDriver();
		driver.get("https://www.flipkart.com");
		 
	}
	
}
