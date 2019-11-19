package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.api.ImplementedBy;
import com.titanium.framework.controls.internals.Control;

/**
 * Intarface that helps to generate all custom methods for a webelement called button
 * @author Gilberto Sánchez Mares
 */
@ImplementedBy(ButtonBase.class)
public interface Button extends Control {
    // Verify if a button is enabled or not
    boolean getButtonIsEnabled();
}
