package web.Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"web.CaseDefinitions"},
        features = {"src/test/resources/webAutomation"},
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"}
)

public class runnerUtility {
}
