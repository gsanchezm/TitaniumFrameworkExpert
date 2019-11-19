package steps;

import com.titanium.framework.base.Base;
import com.titanium.framework.utils.WaitUtil;
import pages.FindMoviesPage;
import pages.HomePage;
import pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends Base {

    @Given("^user must be on IMDb web application$")
    public void userMustBeOnIMDbWebApplication() {
        //Initialize the page where you'll work
        currentPage = getInstance(HomePage.class);
    }

    @And("^user must be on \"([^\"]*)\" Page$")
    public void userMustBeOnPage(String pageName){
        // currentPage = getInstance(LeftPanelPage.class);

        //currentPage.as(LeftPanelPage.class)
        //      .clickOnMenu(pageName);
    }

    @When("^I click the button \"([^\"]*)\"$")
    public void iClickTheButton(String buttonName) {
        currentPage = getInstance(SignUpPage.class);
        switch (buttonName.toLowerCase()){
            case "create a new account":
                currentPage.as(SignUpPage.class).clickCreateNewAccount();
                break;
            case "sign in with imdb":
                currentPage.as(SignUpPage.class).clickSignInWithIMDb();
                break;
            default:
                new Exception("Wrong selection");
        }
        WaitUtil.sync();
    }

    @And("^I type \"([^\"]*)\"")
    public void iTypeOn(String text) {
        currentPage = getInstance(HomePage.class);
        currentPage.as(HomePage.class).setSearch(text);
    }

    @When("^I click on the link \"([^\"]*)\"$")
    public void iClickOnTheLink(String link){
        if(link.toLowerCase().equals("other sign in options")){
            currentPage = getInstance(HomePage.class);
            currentPage.as(HomePage.class).clickOtherSignInOptions();
        }else{
            currentPage = getInstance(FindMoviesPage.class);
            currentPage.as(FindMoviesPage.class).selectMovie(link);
        }
        WaitUtil.sync();
    }
}
