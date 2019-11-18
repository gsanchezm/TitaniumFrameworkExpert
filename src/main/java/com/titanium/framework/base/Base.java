package com.titanium.framework.base;

import com.titanium.framework.controls.api.ControlFactory;

/**
 * @author Gilberto Sánchez Mares
 */
public class Base {
    public static BasePage currentPage;
    public <TPage extends  BasePage> TPage getInstance(Class<TPage> page){
        Object obj = ControlFactory.initElements(DriverFactory.getInstance().getDriver(), page);
        return page.cast(obj);
    }
}
