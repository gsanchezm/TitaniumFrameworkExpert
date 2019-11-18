package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.api.ImplementedBy;
import com.titanium.framework.controls.internals.Control;

/**
 * Intarface that helps to generate all custom methods for a webelement called Textbox
 * @author Gilberto Sánchez Mares
 */

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {
    // Type text in textbox
    void enterText(String text);
    // Get the value from textbox
    String getTextValue();
}
