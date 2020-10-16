import Constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class WebDriverSettings implements Constant {

    public WebDriver driver;
    @BeforeTest
    public void precondition(){
        System.setProperty(BROWSER,PATH_TO_WEBDRIVER );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void postcondition(){
        driver.quit();
    }
}
