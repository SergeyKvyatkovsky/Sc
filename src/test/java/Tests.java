import Pages.MainPage;
import Pages.PageLapTop;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Tests extends WebDriverSettings{

    @Description("In the test method searches laptop by lenovo.")
    @Test(singleThreaded = true, invocationCount = 2, invocationTimeOut = 50000 , suiteName = "suitone",groups = "groupOne",testName = "testing")
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
