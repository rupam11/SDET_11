package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features={"src/test/resources/Login/login.feature"},
	glue= {"StepDef"},
	dryRun=false,//to check whether you have missed a steps in scenario
	monochrome=true,// look console o/p look better
	//tags= {"@DC-Test-Suite","@getAllByodMapperForClientByType"},
	strict = true,//it will check wether any step is not defined in step definitionreport
	plugin= {"html:target/htmlReport.html","junit:target/junitXMLReport.xml","json:target/jsonReport.json"},
	tags="@Login"
	
	)
public class Test_runner {

}
