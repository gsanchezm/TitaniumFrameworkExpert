package pages;

import com.titanium.framework.controls.elements.Button;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SignUpPage {


    /*@FindBy(id = "ap_email")
    TextBox txtEmail;

    @FindBy(id = "ap_password")
    TextBox txtEmail;*/

    @FindBy(id = "signInSubmit")
    private Button btnSubmit;

    public LoginCommand loginAs(String userName){
        return new LoginCommand(userName);
    }

    public class LoginCommand{
        private String userName;
        private String password;

        public LoginCommand(String userName){
            this.userName = userName;
        }

        public LoginCommand withPassword(String password){
            this.password = password;
            return  this;
        }

        public void login(){
            txtEmail.waitForVisible().enterText(userName);
            txtPassword.waitForVisible().enterText(password);
            btnSubmit.waitForVisible().performSubmit();
        }
    }
}
