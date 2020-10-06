package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='Header__ButtonCatalog Header__CatalogShow Header__GetCatalog hidden-lg']")
    private WebElement buttonCatalog;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div[1]/div/div[7]/span[1]/span[2]/span")
    private WebElement catalogComputer;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div[1]/div/div[7]/span[8]")
    private WebElement laptopAndAcc;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div[1]/div/div[7]/a[75]")
    private WebElement laptopOnly;

    public void openPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.by/");
    }

    public void clickPathToLaptop(){
        buttonCatalog.click();
        catalogComputer.click();
        laptopAndAcc.click();
        laptopOnly.click();
        driver.getTitle();
    }
}
