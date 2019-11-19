package pages;

import com.titanium.framework.base.BasePage;
import com.titanium.framework.controls.elements.Button;
import com.titanium.framework.controls.elements.HyperLink;
import com.titanium.framework.controls.elements.TextBox;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[text()='Create a New Account']")
    private HyperLink lnkCreateNewAccount;

    @FindBy(id = "ap_customer_name")
    private TextBox txtName;

    @FindBy(id = "ap_email")
    protected TextBox txtEmail;

    @FindBy(id = "ap_password")
    protected TextBox txtPassword;

    @FindBy(id = "ap_password_check")
    private TextBox txtPasswordCheck;

    @FindBy(id = "continue")
    private Button btnCreate;

    @FindBy(xpath = "//*[text()='Sign in with IMDb']")
    private Button btnSignInWithIMDb;

    public void clickCreateNewAccount(){
        lnkCreateNewAccount.clickLink();
    }

    public void clickSignInWithIMDb(){
        btnSignInWithIMDb.performClick();
    }

    public SignInCommand sigInAs(String userName){
        return new SignInCommand(userName);
    }

    public class SignInCommand{
        private String userName;
        private String email;
        private String password;

        public SignInCommand(String userName) {
            this.userName = userName;
        }

        public SignInCommand withEmail(String email){
            this.email = email;
            return this;
        }

        public SignInCommand withPassword(String password){
            this.password = password;
            return this;
        }

        public void createIMDbAccount(){
            txtName.enterText(userName);
            txtEmail.enterText(email);
            txtPassword.enterText(password);
            txtPasswordCheck.enterText(password);
            btnCreate.performSubmit();
        }
    }
}
