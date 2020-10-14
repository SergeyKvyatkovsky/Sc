package Pages;

import Utils.UtilsMethods;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Name("laptop page")
public class PageLapTop extends UtilsMethods{
    public WebDriver driver;

    public PageLapTop(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Lenovo']")
    private WebElement filterByCreate;

    @FindBy(xpath = "//input[@id=\"minnum_45\"]")
    private WebElement filterPriceBefore;

    @FindBy(xpath = "//input[@id=\"maxnum_45\"]")
    private WebElement filterPriceAfter;

    @FindBy(xpath = "//span[@class=\"ModelFilter__TxtBtnFormBlock\"]")
    private WebElement showFilterChose;

    @FindBy(xpath = "//div[@class=\"PanelSetUp__SelectionBlock\"]")
    private WebElement filterForSort;

    @FindBy(xpath = "//li[contains(@id, '_chzn_o_2')]")
    private WebElement getFilterForSortFromExpensive;

    @FindBy(xpath = "//li[contains(@id, '_chzn_o_0')]")
    private WebElement getFilterForSortFromChip;

    @FindBy(xpath = "//div[@class=\"ModelList\"]/div/div[@class='ModelList__ModelContentBlock']//div[@class=\"ModelList__PriceBlock\"]/span")
    private WebElement getFirstElementInSortTableFromPriceValue;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[3]/div[4]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/div[2]/span/span/span[2]/span")
    private WebElement getFirstElementInSortTableToPriceValue;

    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    UtilsMethods utilsMethods = new UtilsMethods();


    public void clickFilterInSubMenuLaptopLenovo(){
        utilsMethods.time();
        System.out.println("wait element lenovo");
        utilsMethods.waitElement(driver,"//a[text()='Lenovo']");
        utilsMethods.time();
        System.out.println("click element lenovo");
        filterByCreate.click();
        Assert.assertEquals(pageTitle.getText().s);
    }

    public void enterFilterPrice(){
        Actions builder = new Actions(driver);
        System.out.println("wait input");
        utilsMethods.waitElement(driver,"//input[@id=\"minnum_45\"]");
        System.out.println("enter price");
        builder.sendKeys(filterPriceBefore, PRICE_FROM).pause(500).build().perform();
        builder.sendKeys(filterPriceAfter, PRICE_TO).pause(100).build().perform();
        System.out.println("click on my choose!");
        builder.click(showFilterChose).pause(500).build().perform();
    }

    public void choseSortFromСheap(){
        Actions builder = new Actions(driver);
        System.out.println("Assert the most chip");
        utilsMethods.waitElement(driver,"//div[@class=\"PanelSetUp__SelectionBlock\"]");
        filterForSort.click();
        utilsMethods.time();
        System.out.println("Wait elemtnt the most chip");
        utilsMethods.waitElement(driver,"//li[contains(@id, '_chzn_o_0')]");
        utilsMethods.time();
        System.out.println("click elemtnt the most chip");
        getFilterForSortFromChip.click();
        builder.pause(3000);
        System.out.println("first price");
        String firstPriceAfterSort = getFirstElementInSortTableFromPriceValue.getText();
        System.out.println("################################" + firstPriceAfterSort);
        double priceParse = utilsMethods.parserForPrice(firstPriceAfterSort);
        boolean bool = Integer.valueOf(PRICE_FROM) <= priceParse;
        System.out.println("first price assert");
        Assert.assertEquals(bool,true);
    }

    public void choseSortFromExpensive() {
        Actions builder = new Actions(driver);
        System.out.println("Assert the most expensive");
        utilsMethods.waitElement(driver,"//div[@class=\"PanelSetUp__SelectionBlock\"]");
        filterForSort.click();
        getFilterForSortFromExpensive.click();
        builder.pause(3000);
        String firstPriceAfterSort = getFirstElementInSortTableFromPriceValue.getText();
        double priceParse = utilsMethods.parserForPrice(firstPriceAfterSort);
        boolean bool = Integer.valueOf(PRICE_TO) >= priceParse;
        Assert.assertEquals(bool,true);
    }

}
