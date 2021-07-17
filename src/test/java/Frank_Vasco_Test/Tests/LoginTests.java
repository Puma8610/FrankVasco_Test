package Frank_Vasco_Test.Tests;

import Frank_Vasco_Test.DataProviders.DataProviders;
import Frank_Vasco_Test.Pages.HamburguerMenuPage;
import Frank_Vasco_Test.Pages.HomePage;
import Frank_Vasco_Test.Pages.LoginPage;
import Frank_Vasco_Test.Utils.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {

    public MyDriver myDriver;
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(description = "Perform a login", dataProvider = "UserCredentials" , dataProviderClass = DataProviders.class)
    public void Test(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.sendkeysUsername(userName);
        loginPage.sendKeysPassword(password);
        loginPage.clickLoginButton();
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getHomePageTitle(), "PRODUCTS");
        System.out.println("Test Finished");
    }


    @AfterTest
    public void closePage(){
        homePage.dispose();
        loginPage.dispose();
    }

}
