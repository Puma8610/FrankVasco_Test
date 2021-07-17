package SeleniumGlueCode;


import Frank_Vasco_Test.Pages.HomePage;
import Frank_Vasco_Test.Pages.LoginPage;
import Frank_Vasco_Test.Utils.MyDriver;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Test {

    public MyDriver myDriver;
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @Before
    public void beforeScenario(){
        myDriver =new MyDriver("chrome");
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Given("^User is in the login page$")
    public void the_login_page() throws Throwable {
        loginPage = new LoginPage(driver);
    }

    @When("^User types a valid \"([^\"]*)\"$")
    public void User_types_a_valid_userName(String userName) throws Throwable {
        loginPage.sendkeysUsername(userName);
    }

    @When("^Type a valid \"([^\"]*)\"$")
    public void type_a_valid_password(String password) throws Throwable {
        loginPage.sendKeysPassword(password);
    }

    @When("^Click on the Login button$")
    public void click_on_the_Login_button() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("^The application should load the Home page$")
    public void the_application_should_load_the_Home_page() throws Throwable {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getHomePageTitle(), "PRODUCTS");
        System.out.println("Test Finished");
    }

    @After
    public void afterScenario(){
        homePage.dispose();
        loginPage.dispose();
    }

}
