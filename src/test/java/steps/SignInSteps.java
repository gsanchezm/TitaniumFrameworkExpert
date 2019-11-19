package steps;

import com.titanium.framework.base.Base;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SignInSteps extends Base {
    @Then("^I login with user \"([^\"]*)\" and pass \"([^\"]*)\"$")
    public void iLoginWithUserAndPass(String user, String password)  {
        currentPage = getInstance(LoginPage.class);
        currentPage.as(LoginPage.class).loginAs(user).withPassword(password).login();
    }

    @And("^I Log Out from the page$")
    public void iLogOutFromThePage() throws Throwable {
        currentPage = getInstance(HomePage.class);
        currentPage.as(HomePage.class).moveCursorToUserName();
        currentPage.as(HomePage.class).clickLogOut();
    }
}
