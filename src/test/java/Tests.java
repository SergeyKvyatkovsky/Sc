import Pages.MainPage;
import Pages.PageLapTop;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Tests extends WebDriverSettings{

    @Test(singleThreaded = true, invocationCount = QUANTITY_ITERATIONS, invocationTimeOut = TIME_FOR_THE_TEST_PASS , suiteName = "suitone",groups = "groupOne",testName = "testing")
    public void testSearchLenovo(){
        System.out.println("Start");
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.openPage();
        mainPage.clickPathToLaptop();
        PageLapTop pageLapTop = PageFactory.initElements(driver, PageLapTop.class);
        pageLapTop.clickFilterLenovoInSubMenuLaptop();
        pageLapTop.enterFilterPrice();
        pageLapTop.choseSortFromСheap();
        pageLapTop.choseSortFromExpensive();
    }
}
