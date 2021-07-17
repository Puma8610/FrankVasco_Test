package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id="user-name")
    private WebElement userNameTxt;

    @FindBy(id="password")
    private WebElement passwordTxt;

    @FindBy(id="login-button")
    private WebElement loginButton;


    public void sendkeysUsername(String userName ){
        getWait();
        click(userNameTxt);
        sendKeys(userNameTxt, userName);
    }

    public void sendKeysPassword(String password){
        click(passwordTxt);
        sendKeys(passwordTxt, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

}
