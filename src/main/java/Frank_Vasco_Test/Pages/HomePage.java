package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id="react-burger-menu-btn")
    private WebElement hamburgerIcon;

    @FindBy(css="span[class='title']")
    private WebElement productsTitle;

    @FindBy(css="div[class='inventory_item_price']")
    private List<WebElement> prices;

    @FindBy(css="button[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToCartButtons;

    @FindBy(css="div[class='inventory_item_name']")
    private List<WebElement> productName;

    @FindBy(id="shopping_cart_container")
    private WebElement shoppingCart;



    public void clickOnHamburguerIcon(){
        getWait();
        click(hamburgerIcon);
    }

    public void addToCartLowestPriceProduct(){
        findElementUntilClickable(addToCartButtons.get(lowestPrice()));
        click(addToCartButtons.get(lowestPrice()));
    }

    public void addToCartHighestPriceProduct(){
        findElementUntilClickable(addToCartButtons.get(highestPrice()));
        click(addToCartButtons.get(highestPrice()));

    }

    public String getLowestPriceProductName(){
        findElementUntilClickable(productName.get(lowestPrice()));
        return getTextElement(productName.get(lowestPrice()));
    }

    public String getHighestPriceProductName(){
        findElementUntilClickable(productName.get(highestPrice()));
        return getTextElement(productName.get(highestPrice()));
    }

    public String getHomePageTitle(){
        findElementUntilClickable(productsTitle);
        return getTextElement(productsTitle);
    }

    public void clickOnShoppingCart(){
        click(shoppingCart);
    }


    public int lowestPrice(){
        float lowerPrice = 1000;
        int lowerPricePosition = 0;
        for (int i = 0; i < prices.size(); i++) {
            String elementPrice  = prices.get(i).getText();
            float priceNumber = Float.parseFloat(elementPrice.replace("$", ""));
            if(priceNumber<lowerPrice){
                lowerPrice = priceNumber;
                lowerPricePosition = i;
            }
        }
        return lowerPricePosition;
    }

    public int highestPrice(){
        float highestPrice = 0;
        int highestPricePosition = 0;
        for (int i = 0; i < prices.size(); i++) {
            String elementPrice  = prices.get(i).getText();
            float priceNumber = Float.parseFloat(elementPrice.replace("$", ""));
            if(priceNumber>highestPrice){
                highestPrice = priceNumber;
                highestPricePosition = i;
            }
        }
        return highestPricePosition;
    }

}
