package com.tmb.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@tag4",
		features = "src//test//resources//parallel",
		glue = {"parallel"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber.json"},
		monochrome = true,
		publish=true
		
		)
////mvn clean test -Dcucumber.feature="path/to/feature-files" -Dcucumber.filter.tags="@Your_tag"
//https://github.com/cucumber/cucumber-jvm/blob/main/release-notes/v5.0.0.md#property-based-options
/*
 * cucumber.ansi-colors.disabled= # true or false. default: false
 * cucumber.execution.dry-run= # true or false. default: false
 * cucumber.execution.limit= # number of scenarios to execute (CLI only).
 * cucumber.execution.order= # lexical, reverse, random or random:[seed] (CLI
 * only). default: lexical cucumber.execution.strict= # true or false. default:
 * false. cucumber.execution.wip= # true or false. default: false.
 * cucumber.features= # command separated paths to feature files. example:
 * path/to/example.feature, path/to/other.feature cucumber.filter.name= # regex.
 * example: .*Hello.* cucumber.filter.tags= # tag expression. example: @smoke
 * and not @slow cucumber.glue= # comma separated package names. example:
 * com.example.glue cucumber.plugin= # comma separated plugin strings. example:
 * pretty, json:path/to/report.json cucumber.object-factory= # object factory
 * class name. example: com.example.MyObjectFactory cucumber.snippet-type= #
 * underscore or camelcase. default: underscore
 */

//for see extent report properly in jenkins
/*
 * System.setProperty("hudson.model.DirectoryBrowserSupport.CSP",
 * "sandbox allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src *"
 * );
 */
public class Test {

	

}
/*
 * extends AbstractTestNGCucumberTests
 * 
 * @Override
 * 
 * @DataProvider(parallel = true) public Object[][] scenarios() { return
 * super.scenarios(); }
 */