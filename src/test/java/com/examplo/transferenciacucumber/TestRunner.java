package com.examplo.transferenciacucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        plugin = { "pretty", "html:target/cucumber-reports/report.html" },
        glue= "com.examplo.transferenciacucumber.financeiro",
        monochrome = true, dryRun = true)
@CucumberContextConfiguration
@SpringBootTest(classes = TransfercucumberApplication.class)
public class TestRunner { }
