package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty","html:target/cucumber-reports/cucumber-html-report.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@contact")
public class BaseTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)

    public Object[][] scenarios(){
        return super.scenarios();
    }
}
