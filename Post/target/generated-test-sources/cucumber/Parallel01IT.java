import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"C:/Users/Chenl10/Cyber/project/web_BDD_testing-master/Post/src/test/java/com/automationpractice/features/Postage_calculation.feature"},
plugin = {"json:target/cucumber-parallel/1.json", "html:target/cucumber-parallel/1.html"},
monochrome = false,
 tags = {"@FuctionTest"}, glue = { "com.automationpractice.stepdefs" })
public class Parallel01IT {
}
