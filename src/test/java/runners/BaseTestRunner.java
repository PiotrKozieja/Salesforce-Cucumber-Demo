package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "stepDefinitions",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        tags = "@api")
public class BaseTestRunner extends AbstractTestNGCucumberTests {
}
