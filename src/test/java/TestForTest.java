import Pages.MainPage;
import Pages.PageLapTop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestForTest extends WebDriverSettings{



    @Test
    public void TestMethod(){
        System.out.println("Start");
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.openPage();
        mainPage.clickPathToLaptop();
        PageLapTop pageLapTop = PageFactory.initElements(driver, PageLapTop.class);
        pageLapTop.clickFilters();
    }



}
