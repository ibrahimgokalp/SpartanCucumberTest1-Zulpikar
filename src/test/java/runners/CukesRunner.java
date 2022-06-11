package runners;

import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features/",
        glue = "step_definitions/",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}