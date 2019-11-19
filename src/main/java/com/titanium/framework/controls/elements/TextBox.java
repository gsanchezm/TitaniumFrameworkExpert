package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.api.ImplementedBy;
import com.titanium.framework.controls.internals.Control;
import com.titanium.framework.controls.internals.ControlBase;

/**
 * Intarface that helps to generate all custom methods for a webelement called Textbox
 * @author Gilberto Sánchez Mares
 */

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {
}
