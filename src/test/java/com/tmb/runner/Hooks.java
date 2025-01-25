package com.tmb.runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmb.pages.WebBase;
import com.tmb.utils.Loggers;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Hooks {
	public WebDriver driver;
	//ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	@BeforeAll
	public static void runDocker() throws IOException, InterruptedException {

		if (Boolean.getBoolean("selenium.grid.enable")) {

			Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
			Thread.sleep(15000);
			Runtime.getRuntime().exec("cmd /c start start_dockergridscale.bat");
		}

	}

	@AfterAll
	public static void stopDocker() throws IOException, InterruptedException {
		if (Boolean.getBoolean("selenium.grid.enable")) {
			Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
			Thread.sleep(10000);

			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

		}

	}

	@Before(order=0)
	public void beforeRun() throws MalformedURLException {
		Loggers.info("under @before func");
		if (Boolean.getBoolean("selenium.grid.enable")) {
			driver = WebBase.setRemoteDriver();
		} else {
			System.out.println("under @before local");
			driver = WebBase.setLocalDriver();
		}
	}

	@After(order=0)
	public void tearDown(Scenario sce) throws IOException {
		driver = WebBase.getDriver();
		if (sce.isFailed()) {
			final byte[] sbyte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// sce.attach(sbyte, "image/png", sce.getName());
		}
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\Screenshots\\" + sce.getName() + ".png"));
		// sce.attach(screenshot, "image/png", sce.getName());
		byte[] imageBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// Files.write(Paths.get(RESULT_FILENAME), imageBytes);
		sce.attach(imageBytes, "image/png", sce.getName());
		if (Boolean.getBoolean("selenium.grid.enable") == false) {
			//tdriver.get().quit();
			//WebBase.tearDown();
			System.out.println("closing browser");
			driver.quit();
		}

	}

	public WebDriver getLocalDriver() {
		switch ((System.getProperty("browser") != null) ? System.getProperty("browser") : "chrome") {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--remote-allow-origins=*");
			//                   tdriver.set(new ChromeDriver());
			//tdriver.get().get("https://google.com");
			//driver = new ChromeDriver();
			//driver.get("https://google.com");
			System.out.println("running chrome local driver");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			//tdriver.set(new FirefoxDriver());
			driver= new FirefoxDriver();
			System.out.println("getting firefox driver");

			break;

		default:
			System.out.println("pls provide browser");
		}
		return driver;
		//return tdriver.get();
	}

	public WebDriver getRemoteDriver() throws MalformedURLException {

		Capabilities capabilities = null;

		switch (System.getProperty("browser")) {
		case "chrome":
			capabilities = new ChromeOptions();
			break;
		case "firefox":
			capabilities = new FirefoxOptions();
		}
		URL url = new URL("http://10.0.0.44:4444/wd/hub");
		return new RemoteWebDriver(url, capabilities);
	}

}
