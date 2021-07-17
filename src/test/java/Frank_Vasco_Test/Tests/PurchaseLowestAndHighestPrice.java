package Frank_Vasco_Test.Tests;

import Frank_Vasco_Test.DataProviders.DataProviders;
import Frank_Vasco_Test.Pages.*;
import Frank_Vasco_Test.Utils.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PurchaseLowestAndHighestPrice {

    public MyDriver myDriver;
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutPage checkoutPage;


    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(description = "Perform a Purchase of the product lowest price and the product with the highest price", dataProvider = "UserCredentials" , dataProviderClass = DataProviders.class)
    public void Test1(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.sendkeysUsername(userName);
        loginPage.sendKeysPassword(password);
        loginPage.clickLoginButton();
        homePage = new HomePage(driver);
        String lowestPriceProductName = homePage.getLowestPriceProductName();
        String highestPriceProductName = homePage.getHighestPriceProductName();
        System.out.println(lowestPriceProductName + "   " + highestPriceProductName );
        homePage.addToCartLowestPriceProduct();
        homePage.addToCartHighestPriceProduct();
        homePage.clickOnShoppingCart();
        shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(lowestPriceProductName, shoppingCartPage.getLowestPriceProductTitle());
        Assert.assertEquals(highestPriceProductName, shoppingCartPage.getHighestPriceProductTitle());
        System.out.println(shoppingCartPage.getLowestPriceProductTitle() + "   " + shoppingCartPage.getHighestPriceProductTitle() );
        shoppingCartPage.clickOnCheckout();
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.sendName("a");
        checkoutInfoPage.sendLastName("b");
        checkoutInfoPage.sendPostCode("1");
        checkoutInfoPage.clickOnContinueButton();
        checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(lowestPriceProductName, checkoutPage.getLowestProductTitle());
        Assert.assertEquals(highestPriceProductName, checkoutPage.getHighestProductTitle());
        System.out.println(checkoutPage.getLowestProductTitle() + "   " + checkoutPage.getHighestProductTitle() );
        checkoutPage.clickOnFinishButton();
        Assert.assertEquals(checkoutPage.getThankyouMsg(), "THANK YOU FOR YOUR ORDER");
        System.out.println("Test Finished");
    }

    @AfterTest
    public void closePage(){
        homePage.dispose();
        loginPage.dispose();
    }

}
