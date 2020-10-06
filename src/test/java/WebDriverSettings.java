import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    public WebDriver driver;
    @BeforeTest
    public void precondition(){
        System.out.println("pre");
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterTest
    public void postcondition(){
        System.out.println("post");
        driver.quit();
    }
}
