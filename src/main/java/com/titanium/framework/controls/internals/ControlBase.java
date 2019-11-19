package com.titanium.framework.controls.internals;

import com.titanium.framework.base.DriverFactory;
import com.titanium.framework.utils.SeleniumUtils;
import com.titanium.framework.utils.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.util.List;

import static com.titanium.framework.utils.LogUtil.info;

public class ControlBase implements Control {
    private final WebElement element;

    public ControlBase(final WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public ControlBase waitFor() {
        WaitUtil.sync();
        return this;
    }

    @Override
    public ControlBase waitForVisible() {
        WaitUtil.waitForElementVisible(getWrappedElement());
        return this;
    }

    @Override
    public ControlBase scrollUp() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            jse.executeScript("window.scrollBy(0,-250)", "");
            info("Scroll executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public ControlBase scrollDown() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            jse.executeScript("window.scrollBy(0,250)", "");
            info("Scroll executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public ControlBase scrollToElement() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", getWrappedElement());
            info("Scroll executed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    // Get the value from textbox
    @Override
    public String getElementText(){
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    // Type text in textbox
    @Override
    public ControlBase enterText(String text) {
        SeleniumUtils.highLight(getWrappedElement());
        clear();
        sendKeys(text);
        return this;
    }

    // Perform a click on a button
    @Override
    public void performClick() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    // Perform a click an submit a form when the input type is submit
    @Override
    public void performSubmit() {
        SeleniumUtils.highLight(getWrappedElement());
        submit();
    }
}
