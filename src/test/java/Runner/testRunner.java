package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={"C:\\Users\\2303755\\eclipse-workspace\\Hackathon_Project-1 3\\Hackathon_Project-1\\FeatureFile\\feature.feature" ,"C:\\Users\\2303755\\eclipse-workspace\\Hackathon_Project-1 3\\Hackathon_Project-1\\FeatureFile\\feature2.feature"},
		glue="StepDefinition",plugin = {"pretty", "html:cucumber/myReport.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
         dryRun=false,
         monochrome=true,
         publish=true,
         tags="@Smoke")

public class testRunner {

}
