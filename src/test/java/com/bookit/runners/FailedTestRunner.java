package com.bookit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "@target/rerun.txt",
         glue = "com/bookit/stepDefinitions",
         dryRun = false
)

public class FailedTestRunner {



}
