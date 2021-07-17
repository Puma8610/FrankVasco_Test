package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="div[class='inventory_item_name']")
    private List<WebElement> productTitle;

    @FindBy(id="checkout")
    private WebElement checkoutButton;



    public String getLowestPriceProductTitle(){
        getWait();
        return getTextElement(productTitle.get(0));
    }

    public String getHighestPriceProductTitle(){
        return getTextElement(productTitle.get(1));
    }

    public void clickOnCheckout(){
        click(checkoutButton);
    }


}
