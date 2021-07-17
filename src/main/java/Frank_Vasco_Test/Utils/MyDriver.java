package Frank_Vasco_Test.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

    private WebDriver driver;

    public MyDriver(String browser){
        switch (browser){
            case "chrome":
                System.setProperty ("webdriver.chrome.driver","C:\\driver\\chromedriver.exe" );
                driver = new ChromeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
