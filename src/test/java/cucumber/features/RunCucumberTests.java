package cucumber.features;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@Cucumber.Options(format = {"pretty", "html:target/cucumber", "json:target/cucumber/results.json"}) 

public class RunCucumberTests {
	
	
}