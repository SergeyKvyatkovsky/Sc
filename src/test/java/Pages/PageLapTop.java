package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLapTop {
    public WebDriver driver;

    public PageLapTop(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()=\"Lenovo\"]")
    private WebElement filterByCreate;

    public void clickFilters(){
        filterByCreate.click();
    }

}
