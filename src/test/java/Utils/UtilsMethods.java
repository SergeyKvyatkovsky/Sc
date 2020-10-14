package Utils;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsMethods implements Constant {
    public WebDriver driver;

    public WebDriver checkBannerAndWaitLoadingBanner(WebDriver driver){
        try {
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"top-banner\"]/div"))));
            System.out.println("Banner turned on , wait for loading.");
        }catch (Exception e){
            System.out.println("Banner turned off");
        }
        return driver;
    }

    public double parserForPrice(String inputPrice)  {
        String secondInputPrice = inputPrice.substring(inputPrice.indexOf(" "),inputPrice.indexOf(","));
        System.out.println(secondInputPrice);
        double priceAfterParse = Double.valueOf(secondInputPrice.replace(",",".").replaceAll("\\s",""));
        return priceAfterParse;
    }

    public WebDriver waitElement(WebDriver driver,String nameElement){
        try {
            WebElement dynamicElement = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated((By.xpath(nameElement))));
            System.out.println("Element was find");
        }catch (Exception e){
            System.out.println("Element wasn't find");
        }
        return driver;
    }

    public  String time(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return String.valueOf(date);
    }

}
