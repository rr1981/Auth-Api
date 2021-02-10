package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resouurce/feature", plugin = { "html:target/cucumber-report" })
public class TestRunner {

}
