package Frank_Vasco_Test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    /***
     * Define WebDriverWait method for the project
     * @return WebDriverWait
     */
    public WebDriverWait getWait(){
        WebDriverWait wait =  new WebDriverWait(driver, 15);
        this.webDriverWait = wait;
        return webDriverWait;
    }

    /***
     *
     * @param element
     */
    public void findElementUntillVisibility(String element){
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
    }

    /**
     * Generic method to wait until an element is vivible
     * @param element
     */
    public void findElementUntillVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait Until element is clickable
     * @param element
     */
    public void findElementUntilClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Get text of an element
     * @param element
     * @return
     */
    public String getTextElement(WebElement element){
        return element.getText();
    }


    /***
     * Click in the button Selected
     * @param element
     */
    public void click(String element){
        getDriver().findElement(By.cssSelector(element)).click();
    }

    public void click(WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        element.sendKeys(text);
    }


    /**
     *Close the browser window
     */
    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }


}
