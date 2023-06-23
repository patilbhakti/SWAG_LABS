package com.swagLabsLoginTestRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue= {"com.swagLabsLoginExecutableFile"})
//@CucumberOptions(features= {"features"},glue= {"swagLabsLogin"})
public class SwagLabsLoginClass {
	
	

}
