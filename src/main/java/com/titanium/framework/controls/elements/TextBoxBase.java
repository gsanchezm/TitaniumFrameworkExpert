package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.internals.ControlBase;
import com.titanium.framework.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

/**
 * Class where you implement the logic to all the methods generated in the TextBoox interface
 * @author Gilberto Sánchez Mares
 */
public class TextBoxBase extends ControlBase implements TextBox {
    public TextBoxBase(WebElement element) {
        super(element);
    }
}
