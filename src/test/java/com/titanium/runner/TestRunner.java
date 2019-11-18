/*
package com.titanium.runner;

import com.titanium.framework.base.BrowserType;
import com.titanium.framework.base.DriverFactory;
import com.titanium.framework.config.Constants;
import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.testng.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.*;
import com.vimalselvam.cucumber.listener.ExtentProperties;

import java.io.File;
import java.net.MalformedURLException;

import static com.vimalselvam.cucumber.listener.Reporter.loadXMLConfig;

@CucumberOptions(features = {"src/test/java/features/"},
        glue = {"steps"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"})
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUpClass(String browser) throws MalformedURLException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(Constants.HTML_REPORT);
        //PropertyConfigurator.configure(Constants.LOG_PRO_DIR);
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
    }

    @Test(dataProvider = "features")
    public void runnerTests(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[] provideScenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
        loadXMLConfig(new File(Constants.EXTENT_CONFIG));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setTestRunnerOutput("Sample test runner output message");
        DriverFactory.getInstance().removeDriver();
    }
}
*/
