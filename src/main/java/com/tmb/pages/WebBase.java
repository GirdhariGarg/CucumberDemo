package com.tmb.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebBase {
	public static WebDriver rDriver;
	
	//ChromeOptions co= new ChromeOptions();
	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	
	/*
	 * public WebDriver getDriver() throws MalformedURLException {
	 * WebDriverManager.chromedriver().setup();
	 * co.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	 * co.addArguments("--remote-origin-policy=.*"); tdriver.set(new
	 * RemoteWebDriver(new URL("http://10.0.0.44:4444"), co)); driver =
	 * tdriver.get(); return driver; }
	 */
	/*
	 * public void launchURL() { tdriver.get().get("https://www.google.co.in");
	 * FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(tdriver.get()) ;
	 * fluentWait.until(ExpectedConditions.titleIs("Google"));
	 * fluentWait.ignoring(NoSuchElementException.class);
	 * fluentWait.pollingEvery(Duration.ofSeconds(3)); }
	 */
	public static void tearDown() {
		if(tdriver!=null) {
		tdriver.get().quit();
		tdriver.remove();
		}
	}

	
	public static WebDriver setLocalDriver() {
		switch((System.getProperty("browser")!=null)?System.getProperty("browser"):"chrome"){			
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			tdriver.set(new ChromeDriver(options));
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
			
			//driver= new FirefoxDriver();
			break;
			
		default: System.out.println("pls provide browser");
		}
		return tdriver.get();
		
	}

	public static WebDriver setRemoteDriver() throws MalformedURLException {

		Capabilities capabilities = null;

		switch(System.getProperty("browser")){
		case "chrome":
			capabilities= new ChromeOptions();
			break;
		case "firefox":
			capabilities= new FirefoxOptions();
			
		}
		URL url= new URL("http://localhost:4444/wd/hub");
		return rDriver = new RemoteWebDriver(url, capabilities);
	}

	public static WebDriver getDriver() throws MalformedURLException {
		if (Boolean.getBoolean("selenium.grid.enable")) {
			System.out.println("getting remote driver");
			return rDriver;
		}else {
		System.out.println("getting local driver");
		return tdriver.get();
		}
		
	}
}
