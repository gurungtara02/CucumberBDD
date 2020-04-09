package _8CucumberBDD.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/_8CucumberBDD/Features", glue="_8CucumberBDD.StepsDef",
        tags= {"@Smoke"})

public class Smoke_Runner {
}
