package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.internals.ControlBase;
import com.titanium.framework.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

/**
 * Class where you implement the logic to all the methods generated on the Button interface
 * @author Gilberto Sánchez Mares
 */
public class ButtonBase extends ControlBase implements Button  {
    public ButtonBase(WebElement element) {
        super(element);
    }

    // Perform a click on a button
    @Override
    public void performClick() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    // Get button text
    @Override
    public String getButtonText() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    // Perform a click an submit a form when the input type is submit
    @Override
    public void performSubmit() {
        SeleniumUtils.highLight(getWrappedElement());
        submit();
    }

    // Verify if a button is enabled or not
    @Override
    public boolean getButtonIsEnabled() {
        return isEnabled();
    }
}
