package parallel;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.tmb.pages.LoginPage1;
import com.tmb.pages.WebBase;
import com.tmb.utils.Loggers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition{
    LoginPage1 loginPage;
WebDriver driver;
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() throws MalformedURLException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
		loginPage = new LoginPage1();
		  driver = WebBase.getDriver();
		  Loggers.info("this is logg file");
		 loginPage.enterCred("https://www.icicibank.com");
		  driver.get("https://www.flipkart.com");
		  System.out.println("chrome1 page title is : "+driver.getTitle());
		 
		
		
	    //throw new io.cucumber.java.PendingException();
	}

	@Given("some other precondition")
	public void some_other_precondition() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.amazon.com");
		System.out.println("chrome2 page title is : "+driver.getTitle());
		
		//System.out.println("some other precondition");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I complete action")
	public void i_complete_action() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		//System.out.println("I complete action");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("chrome3 page title is : "+driver.getTitle());
	}

	@When("some other action")
	public void some_other_action() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@When("yet another action")
	public void yet_another_action() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Given("I want to write a step with name2")
	public void i_want_to_write_a_step_with_name2() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
	}

	@Then("I verify the Fail in step")
	public void i_verify_the_fail_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("some other precondition");
		

	}



}
