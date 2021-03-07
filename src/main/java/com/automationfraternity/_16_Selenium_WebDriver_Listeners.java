package com.automationfraternity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/*

Steps:
* Create Driver
* Create Object of: ```EventFiringWebDriver```
* Create Object of: ```webDriverEvenListenerImpl```
* Register the WebDriverEventListener object with the Event Firing Web Driver
 */
public class _16_Selenium_WebDriver_Listeners {

    public static void main(String[] args){
        //Create Driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Create the Event Firing Web Driver
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);

        //Instantiate listener class
        _16_1_WebDriverEvenListenerImpl webDriverEvenListenerImpl = new _16_1_WebDriverEvenListenerImpl();

        //Register the listener Class
        eventFiringWebDriver.register(webDriverEvenListenerImpl);

        //Start basic operations
        eventFiringWebDriver.navigate().to("https://www.amazon.in/");
        WebElement element = eventFiringWebDriver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("Computer");

        eventFiringWebDriver.findElement(By.id("nav-search-submit-button")).click();

    }
}
/*
Output:
[INFO ] 2021-03-07 17:49:33.570 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: beforeFindBy.
[INFO ] 2021-03-07 17:49:33.592 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: afterFindBy.
[INFO ] 2021-03-07 17:49:33.596 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: beforeChangeValueOf
[INFO ] 2021-03-07 17:49:33.702 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: afterChangeValueOf
[INFO ] 2021-03-07 17:49:33.703 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: beforeFindBy.
[INFO ] 2021-03-07 17:49:33.713 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: afterFindBy.
[INFO ] 2021-03-07 17:49:33.713 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: beforeClickOn
[INFO ] 2021-03-07 17:49:36.365 [main] _16_1_WebDriverEvenListenerImpl - Logging WebDriver Event: afterClickOn
 */