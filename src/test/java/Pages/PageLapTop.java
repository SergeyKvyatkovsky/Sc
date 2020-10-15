package Pages;

import Utils.UtilsMethods;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    private WebElement getFirstElementInSortTable;

    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    UtilsMethods utilsMethods = new UtilsMethods();


    public void clickFilterLenovoInSubMenuLaptop(){
        Assert.assertEquals(utilsMethods.decodeString("Ноутбуки"),pageTitle.getText());
        utilsMethods.waitElement(driver,utilsMethods.getXpath(filterByCreate.toString()));
        filterByCreate.click();
        Assert.assertEquals(utilsMethods.decodeString("Ноутбуки Lenovo"),pageTitle.getText());
    }

    public void enterFilterPrice(){
        Actions builder = new Actions(driver);
        utilsMethods.waitElement(driver,utilsMethods.getXpath(filterPriceBefore.toString()));
        builder.sendKeys(filterPriceBefore, PRICE_FROM).pause(500).build().perform();
        builder.sendKeys(filterPriceAfter, PRICE_TO).pause(100).build().perform();
        builder.click(showFilterChose).pause(500).build().perform();
    }

    public void choseSortFromСheap(){
        utilsMethods.waitElement(driver,utilsMethods.getXpath(filterForSort.toString()));
        filterForSort.click();
        utilsMethods.waitElement(driver,utilsMethods.getXpath(getFilterForSortFromChip.toString()));
        getFilterForSortFromChip.click();
        utilsMethods.waitElement(driver,utilsMethods.getXpath(getFirstElementInSortTable.toString()));
        String firstPriceAfterSort = getFirstElementInSortTable.getText();
        double priceParse = utilsMethods.parserForPrice(firstPriceAfterSort);
        Assert.assertEquals(Integer.valueOf(PRICE_FROM) <= priceParse,true);
    }

    public void choseSortFromExpensive() {
        utilsMethods.waitElement(driver,utilsMethods.getXpath(filterForSort.toString()));
        filterForSort.click();
        utilsMethods.waitElement(driver,utilsMethods.getXpath(getFilterForSortFromExpensive.toString()));
        getFilterForSortFromExpensive.click();
        utilsMethods.waitElement(driver,utilsMethods.getXpath(getFirstElementInSortTable.toString()));
        String firstPriceAfterSort = getFirstElementInSortTable.getText();
        double priceParse = utilsMethods.parserForPrice(firstPriceAfterSort);
        Assert.assertEquals(Integer.valueOf(PRICE_TO) >= priceParse,true);
    }
}
