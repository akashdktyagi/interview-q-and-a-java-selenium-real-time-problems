package com.automationfraternity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

/*
Steps:
* Classs to be imported
    ```java
    import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
    import org.openqa.selenium.support.events.WebDriverEventListener;
    ```
* Create a Class and Implement WebDriverEventListener
* Implement either 'WebDriverEventListener' or extends 'AbstractWebDriverEventListener'
* WebDriverEventListener which is an interface that has some predefined methods for tracking the Webdriver events. It requires us to implement ALL the methods predefined in the Interface.
* AbstractWebDriverEventListener Class which provides us with the facility of implementing only those methods in which we are interested.
* For Now I am just putting just logs inside these methods.
* They are typically to be used for some advanced logging for your Framework etc.

 */
public class _16_1_WebDriverEvenListenerImpl extends AbstractWebDriverEventListener {

    private static final Logger logger = LogManager.getLogger(_16_1_WebDriverEvenListenerImpl.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Logging WebDriver Event: beforeFindBy. ");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Logging WebDriver Event: afterFindBy. ");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Logging WebDriver Event: beforeClickOn");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Logging WebDriver Event: afterClickOn");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Logging WebDriver Event: beforeChangeValueOf");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Logging WebDriver Event: afterChangeValueOf");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.info("Logging WebDriver Event: onException");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        logger.info("Logging WebDriver Event: beforeGetScreenshotAs");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        logger.info("Logging WebDriver Event: afterGetScreenshotAs");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        logger.info("Logging WebDriver Event: beforeGetText");
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        logger.info("Logging WebDriver Event: afterGetText");
    }
}
