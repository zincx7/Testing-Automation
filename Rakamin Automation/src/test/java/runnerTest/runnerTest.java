package runnerTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "stepDef",
        features = "src/test/java/feature",
        plugin = "html:HTML_report.html",
        tags = "@Regression"
)
public class runnerTest {

}

