package com.examplo.transferenciacucumber.financeiro;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Elton H. Paula
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@TransferenciaDinheiroTeste",
        glue = "com.examplo.transferenciacucumber.financeiro", monochrome = true, dryRun = false)
public class TransferenciaDinheiroTeste {


}
