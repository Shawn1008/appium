package test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(monochrome = true, features = "src/test/resources/test/LogIn_Test.feature",

		plugin = { "pretty" })

public class TestRunner {

}
