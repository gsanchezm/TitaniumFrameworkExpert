package steps;

import com.titanium.framework.base.Base;
import pages.HomePage;
import pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Random;

public class SignUpSteps extends Base {

    @And("^I Create New Account for user \"([^\"]*)\"$")
    public void iCreateNewAccountForUser(String userName) {
        currentPage = getInstance(SignUpPage.class);
        currentPage.as(SignUpPage.class)
                .sigInAs(userName)
                .withEmail("gilberto.aspros+"+ (new Random().nextInt(1000)) + "@gmail.com")
                .withPassword("Tester619")
                .createIMDbAccount();
    }

    @Then("^I validate \"([^\"]*)\" is logged in$")
    public void iValidateIsLoggedIn(String userName) {
        currentPage = getInstance(HomePage.class);
        System.out.println(currentPage.as(HomePage.class).getUserName());
        Assert.assertEquals(userName, currentPage.as(HomePage.class).getUserName());
    }
}
