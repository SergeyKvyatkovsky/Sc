package Pages;

import Utils.UtilsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;



@Listeners
public class MainPage extends UtilsMethods {
    UtilsMethods utils = new UtilsMethods();

    public WebDriver driver;


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class=\"Header__BlockCatalogLink\"]/span[@class=\"Header__ButtonCatalog Header__CatalogDescShow visible-lg\"]")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//a[@href='/kompyutery/']")
    private WebElement catalogComputer;

    @FindBy(xpath = "//a[@href=\"/kompyutery/noutbuki_i_aksessuari/\"]")
    private WebElement laptopAndAcc;

   @FindBy(xpath = "//a[@href='/kompyutery/noutbuki_i_aksessuari/']/following-sibling::div[@class=\"DesktopMenu__SubMenu\"]/div[@class=\"DesktopMenu__SubMenuContainer\"]/div/a[@href=\"/noutbuki/\"]")
    private WebElement laptopOnly;

    @FindBy(xpath = "//div[@id=\"top-banner\"]")
    private WebElement adBanner;


    public void openPage() {
        driver.get(LINK);
    }

    public void clickPathToLaptop(){
        Actions builder = new Actions(driver);
        driver = utils.checkBannerAndWaitLoadingBanner(driver);
        builder.moveToElement(buttonCatalog).pause(1000).build().perform();
        builder.moveToElement(catalogComputer).pause(1000).build().perform();
        builder.moveToElement(laptopAndAcc).pause(1000).build().perform();
        builder.click(laptopOnly).pause(1000).build().perform();
    }
}
