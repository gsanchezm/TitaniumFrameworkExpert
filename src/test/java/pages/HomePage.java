package pages;

import com.titanium.framework.base.BasePage;
import com.titanium.framework.controls.elements.HyperLink;
import com.titanium.framework.controls.elements.TextBox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage {
    @FindBy(linkText = "Other Sign in options")
    private HyperLink lnkOtherSignIn;

    @FindBy(id = "nbusername")
    private HyperLink lnkUserName;

    @FindBy(linkText = "Log Out")
    private HyperLink lnkLogOut;

    @FindBy(xpath = "(//span[@class='downArrow'])[6]")
    private WebElement lstUserMenu;

    @FindBy(id = "navbar-query")
    private TextBox txtSearch;

    public void clickOtherSignInOptions(){
        lnkOtherSignIn.clickLink();
    }

    public String getUserName(){
        return lnkUserName.getLinkText();
    }

    public void moveCursorToUserName(){
        lstUserMenu.click();
    }

    public void clickLogOut(){
        lnkLogOut.clickLink();
    }

    public void setSearch(String search){
        txtSearch.enterText(search);
    }
}
