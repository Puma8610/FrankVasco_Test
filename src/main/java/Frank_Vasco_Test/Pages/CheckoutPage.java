package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="div[class='inventory_item_name']")
    private List<WebElement> productTitle;

    @FindBy(id="finish")
    private WebElement finishButton;

    @FindBy(css="h2[class='complete-header']")
    private WebElement thanksMsg;

    public String getLowestProductTitle(){
        getWait();
        return getTextElement(productTitle.get(0));
    }

    public String getHighestProductTitle(){
        return getTextElement(productTitle.get(1));
    }

    public void clickOnFinishButton(){
        findElementUntilClickable(finishButton);
        click(finishButton);
    }

    public String getThankyouMsg(){
        getWait();
        return getTextElement(thanksMsg);
    }

}
