package com.titanium.framework.controls.api;

import com.titanium.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ControlFactory  extends PageFactory {
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page = null;
        try {
            page = pageClassToProxy.getConstructor().newInstance();
            PageFactory.initElements(
                    new ControlFieldDecorator(new AjaxElementLocatorFactory(driver,30)), page);

        }catch (Exception e){
            e.getStackTrace();
        }
        return pageClassToProxy.cast(page);
    }
}
