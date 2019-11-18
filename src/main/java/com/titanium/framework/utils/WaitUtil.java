package com.titanium.framework.utils;

import com.titanium.framework.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.*;

public class WaitUtil {
    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),30, 1000);
    private static String pageLoadStatus;

    public static void sync(){
        do {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
    }

    public static void waitForElementVisible(final WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementPresence(final By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitForElementTextVisible(final WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilTextDisplayed(final WebElement element, String text){
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final WebElement element, String text){
        return webdriver -> element.getText().contains(text);
    }

    public static void waitForElementDisplayed(WebElement element){
        await("Wait for element to be displayed").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed, is(true));
    }

    public static void waitForElementNotDisplayed(WebElement element){
        await("Wait for element to be displayed").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed, is(false));
    }

    public static void waitForElementEnabled(WebElement element){
        await("Wait for element to be enabled").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isEnabled, is(true));
    }

    public static void waitForElementSelected(WebElement element){
        await("Wait for element to be selected").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isSelected, is(true));
    }

    public static void waitTime(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static void waitForElementsNumberBeMoreThan(By selector, int numberCountBefore){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selector, numberCountBefore));
    }

}
