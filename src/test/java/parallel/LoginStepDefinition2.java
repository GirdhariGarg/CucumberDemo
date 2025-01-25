package parallel;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.tmb.pages.LoginPage1;
import com.tmb.pages.WebBase;
import com.tmb.runner.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition2{
LoginPage1 loginPage; 
WebDriver driver;
	@Given("launch url {string}")
	public void launch_url(String url) throws MalformedURLException{
		driver = WebBase.getDriver();
		
		  System.out.println("aftr getting hooks driver");
		  driver.manage().window().maximize(); 
		  driver.get(url);
		  //Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  System.out.println("page title is :"+driver.getTitle());
		  //Hooks.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 
		}
}
