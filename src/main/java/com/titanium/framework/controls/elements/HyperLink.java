package com.titanium.framework.controls.elements;

import com.titanium.framework.controls.api.ImplementedBy;
import com.titanium.framework.controls.internals.Control;

/**
 * Intarface that helps to generate all custom methods for a webelement called hyperlink
 * @author Gilberto Sánchez Mares
 */
@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {
    // Click on one hyperlink
    void clickLink();
    // Get the text from link
    String getLinkText();
    // Check partial text exist on one link
    boolean checkLinkTextContains(String containsText);
}
