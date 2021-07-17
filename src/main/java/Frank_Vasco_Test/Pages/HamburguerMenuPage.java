package Frank_Vasco_Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburguerMenuPage extends BasePage {

    public HamburguerMenuPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id="logout_sidebar_link")
    private WebElement logoutOption;

    public void clickOnLogout(){
        getWait();
        click(logoutOption);
    }


}
