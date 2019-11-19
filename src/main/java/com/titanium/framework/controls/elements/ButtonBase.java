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

    // Verify if a button is enabled or not
    @Override
    public boolean getButtonIsEnabled() {
        return isEnabled();
    }


}
