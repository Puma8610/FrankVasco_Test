package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver pDriver){
        super(pDriver);
    }

    @FindBy(id="first-name")
    private WebElement nameTxt;

    @FindBy(id="last-name")
    private WebElement lastNameTxt;

    @FindBy(id="postal-code")
    private WebElement postCodeTxt;

    @FindBy(id="continue")
    private WebElement continueButton;

    public void sendName(String name){
        getWait();
        sendKeys(nameTxt, name);
    }

    public void sendLastName(String postcode){
        sendKeys(lastNameTxt, postcode);
    }

    public void sendPostCode(String name){
        sendKeys(postCodeTxt, name);
    }

   public void clickOnContinueButton(){
        click(continueButton);
   }

}
