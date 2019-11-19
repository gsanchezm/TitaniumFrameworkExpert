package runner;

import com.titanium.framework.base.BrowserType;
import com.titanium.framework.base.DriverFactory;

import io.cucumber.testng.*;

import org.testng.annotations.*;

import java.net.MalformedURLException;

import static com.vimalselvam.cucumber.listener.Reporter.loadXMLConfig;

@CucumberOptions(features = {"src/test/java/features/"},
        glue = {"steps"},
        plugin = {"pretty"})
        //plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"})
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUpClass(String browser) throws MalformedURLException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        //ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        //extentProperties.setReportPath(Constants.HTML_REPORT);
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runnerTests(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    /*@Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
        //loadXMLConfig(new File(Constants.EXTENT_CONFIG));
        //Reporter.setSystemInfo("user", System.getProperty("user.name"));
        //Reporter.setSystemInfo("os", System.getProperty("os.name"));
        //Reporter.setTestRunnerOutput("Sample test runner output message");
        DriverFactory.getInstance().removeDriver();
    }
}
