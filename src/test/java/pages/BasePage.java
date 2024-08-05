package pages;

import Utils.BrowserDriver;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage extends BrowserDriver {


    private static final long WAIT = 50;
//    public BasePage(WebDriver driver){
//        this.driver=driver;
//        PageFactory.initElements(driver,this);
 public static    WebDriverWait  wait=new WebDriverWait(driver, Duration.ofSeconds(WAIT));
//    }
    public  void click(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void enter_text(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    public static String get_txt(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public static void waitt(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
