package Utils;

import Constant.Constant;
import org.apache.tika.parser.txt.CharsetDetector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsMethods implements Constant {

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
        String secondInputPrice = inputPrice.substring(inputPrice.indexOf(" "),inputPrice.indexOf(decodeString("до")));
        System.out.println(secondInputPrice);
        double priceAfterParse = Double.valueOf(secondInputPrice.replace(",",".").replaceAll("\\s",""));
        return priceAfterParse;
    }

    public WebDriver waitElement(WebDriver driver,String nameElement){
        try {
            WebElement dynamicElement = (new WebDriverWait(driver, MAX_TIME_WAIT_FOR_ELEMENT))
                    .until(ExpectedConditions.presenceOfElementLocated((By.xpath(nameElement))));
            System.out.println("Element was find");
        }catch (Exception e){
            System.out.println("Element wasn't find");
        }
        return driver;
    }

    public String time(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return String.valueOf(date);
    }

    public String decodeString(String stringForDecode){
        CharsetDetector detector = new CharsetDetector();
        String decodedString = detector.getString(stringForDecode.getBytes(), ENCODING);
        return decodedString;
    }

    public String getXpath(String xPath){
        String[] parseXpathStepOne = xPath.split("xpath:");
        String parseXpath = parseXpathStepOne[1].substring(0,parseXpathStepOne[1].length()-1).replaceAll("\\s","");
        return parseXpath;
    }

}
