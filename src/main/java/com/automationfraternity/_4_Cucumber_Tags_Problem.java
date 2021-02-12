/*
Create by Akash Tyagi on 11 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */
/*
tags="@Sanity" :  Will Run Scenario which is tagged with Sanity. Does not matter if it has other tags as well.
tags="@Sanity and @Regression" : Will Run Scenario which is tagged with Sanity as well as Regression.
tags="@Sanity and not @Regression" :  Will Run Scenario which is tagged with Sanity but not Regression.
tags="@Sanity or @Regression" : Will Run Scenario tagged with Sanity or Regression.

Complex Case: I want to run @Sanity and @ui, but not @Regression
tags="@Sanity and @ui" : Will Run Scenario tagged with @Sanity and @ui. But this also run test case which has @Sanity, @Ui but other tags as well.
So, I should write: tags="@Sanity and @ui and (not @Regression)
*/
package com.automationfraternity;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features/MyFeature.feature",//this file is under src/main/resources
        glue="com.automationfraternity",
        tags="@Sanity and @ui and (not @Regression)",
        plugin = {"pretty",
                "html:target/html/htmlreport.html"
        },
        publish=false,
        dryRun=false
)
public class _4_Cucumber_Tags_Problem {
}



