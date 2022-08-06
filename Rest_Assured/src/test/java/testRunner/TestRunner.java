package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features="src\\test\\java\\features",
        glue= "stepDefinition",
        tags = "@smoker",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/cucumber-TestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

	
}
