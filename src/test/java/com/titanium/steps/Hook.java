package com.titanium.steps;

import com.titanium.framework.base.DriverFactory;
import com.titanium.framework.config.Constants;
import com.titanium.framework.utils.SeleniumUtils;
import com.titanium.framework.utils.WaitUtil;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Result;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hook extends DriverFactory {

    @Before
    public void initialize(Scenario scenario) {
        Reporter.addScenarioLog(scenario.getName());
        getInstance().getDriver().navigate().to(Constants.URL);
        WaitUtil.sync();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.getStatus().equals(Result.Type.FAILED)) {
            Reporter.addScreenCaptureFromPath(SeleniumUtils.takeSnapShot(),"Test_Failed!");
        }
    }
}
