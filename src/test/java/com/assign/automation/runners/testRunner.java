package com.assign.automation.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="com.assign.automation.Stepdefs",
        tags="",
        plugin = {"pretty",
            "html:target/html/htmlReport.html",
            "json:target/json/jsonReport.json",
            },
        publish=true,
        dryRun=false
        )
public class testRunner {

}
