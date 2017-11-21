import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = "src/test/resources/features",
        glue = "src/test/groovy/com/pgs/stepdefs",
        format = ["pretty", "html:build/reports/tests/cucumber/html", "json:build/reports/tests/cucumber.json"],
        tags = ["@DniOtwartePgs"]
)

class RunTests {

}