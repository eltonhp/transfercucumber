package com.examplo.transferenciacucumber.financeiro;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste",
        glue = "com.examplo.transferenciacucumber.financeiro", monochrome = true, dryRun = false)
public class ContaTeste {

}