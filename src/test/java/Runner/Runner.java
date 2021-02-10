package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json", "pretty" },
        features = {"src/test/features"},
        strict = true,
        monochrome = true,
        glue = {"Steps","Hook"},
        tags = {"@stable"}
)
public class Runner extends AbstractTestNGCucumberTests{
}

