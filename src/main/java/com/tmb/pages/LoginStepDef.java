package com.tmb.pages;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	LoginPageFactory login = PageFactory.initElements(WebDriverFactory.getDriver(), LoginPageFactory.class);

	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}

}
