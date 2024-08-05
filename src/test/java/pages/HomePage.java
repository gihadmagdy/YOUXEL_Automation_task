package pages;

import Utils.LoggerManager;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{

    public WebDriver driver;
    WebDriverWait wait;
    private static final long WAIT = 50;
    LoggerManager utils = new LoggerManager();

    @FindBy(id = "fi-q")
    private WebElement search_field;
    @FindBy(xpath = "//*[@class='-m -fs14 -elli']")
    public WebElement homepage_assert;
    @FindBy(xpath = "//*[@class='cls']")
    public WebElement close_popup;
    @FindBy(xpath = "//*[@class='btn _prim -df -mla']")
    public WebElement acceptcookies_btn;
    @FindBy(xpath = "//*[@class='btn _prim _md -mls -fsh0']")
    public WebElement search_btn;
    @FindBy(xpath = "//*[@class='trig -df -i-ctr -fs16'][@for='dpdw-sort']")
    public WebElement sortlist;
    @FindBy(xpath = "//a[text()='Price: High to Low']")
    public WebElement sort_type_1;
    @FindBy(xpath = "//*[@class='text'][text()='Phones & Tablets']")
    public WebElement mobileandtabletbtn;
    @FindBy(xpath = "(//*[@class='-rad4'][@alt='Samsung'])[1]")
    public WebElement desiredbrandbtn;
    @FindBy(xpath = "//*[@class='fk-cb -me-start -fsh0'][@data-eventlabel='Gold']")
    public WebElement goldcolor;
    @FindBy(xpath = "//*[@class='name']")
    public WebElement itemtoaddtocart;
    @FindBy(xpath = "(//*[@class='add btn _prim -pea _md'])[1]")
    public WebElement addtoCartbtn;
    @FindBy(xpath = "//*[@class='-df -i-ctr -gy9 -hov-or5 -phs -fs16']")
    public WebElement cartbtn;




    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(WAIT));
    }

    public void validateHomePage(){
        click(close_popup);
        Assert.assertEquals(get_txt(homepage_assert),"Join Jumia");
    }
    public void enterKeywordToSearch(List<List<String>> search_value){

        enter_text(search_field,search_value.getFirst().getFirst());
    }
    public void acceptcookies(){
        click(acceptcookies_btn);
    }
    public void click_search_btn(){
        click(search_btn);
    }
    public void click_sort_list(){
        click(sortlist);
    }
    public void select_sort_type(){
        click(sort_type_1);
    }
    public void validate_sort(){
        List<WebElement> amount=(List<WebElement>) driver.findElements(By.xpath("//*[@class='prc']"));
        List<String> amountwithoutegp= new ArrayList<String>();
        List<String> amountwithoutegpwithotcoma= new ArrayList<String>();


        int j=0;
        for (int i=0; i<amount.size() ; i++)
        {
            StringBuffer sb=new StringBuffer(amount.get(i).getText());
            sb.delete(0,4);
            amountwithoutegp.add(sb.toString());
        }
        for (int i=0; i<amountwithoutegp.size();i++)
        {
            amountwithoutegpwithotcoma.add(amountwithoutegp.get(i).replace(",",""));

        }



        for (int i=0 ; i<amountwithoutegpwithotcoma.size()-1 ; i++)
        {
            try {
            Assert.assertTrue(Float.parseFloat(amountwithoutegpwithotcoma.get(i))>=Float.parseFloat(amountwithoutegpwithotcoma.get(i+1)));
                System.out.println(amountwithoutegpwithotcoma.get(i));
            }
            catch (Exception e)
            {
                System.out.println(amountwithoutegpwithotcoma.get(i));
                System.out.println(amountwithoutegpwithotcoma.get(i+1));
                utils.log().info("Sorting defect");
                System.out.println("Sorting defect");
                Reporter.log("sorting defect");
            }
        }

    }
    public void clickmobileandtablets() throws InterruptedException {
        Thread.sleep(1000);
        click(mobileandtabletbtn);
    }
    public void clickdesiredbrand(){
        click(desiredbrandbtn);
    }
    public void validatebrandname(){
        List<WebElement> brandname=(List<WebElement>) driver.findElements(By.xpath("//*[@class='name']"));
        for (int i=0 ;i<brandname.size();i++)
        {
            Assert.assertTrue(brandname.get(i).getText().contains("Samsung"));
        }
    }
    public void filterbycolor(){
        scrolldown();
        click(goldcolor);
    }
    public void validatecolor(){
        List<WebElement> brandname=(List<WebElement>) driver.findElements(By.xpath("//*[@class='name']"));
        for (int i=0 ;i<brandname.size();i++)
        {
            Assert.assertTrue(brandname.get(i).getText().contains("Gold"));
        }
    }
    public void scrolldown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(itemtoaddtocart).perform();
        click(addtoCartbtn);

    }
    public void clickonCart() throws InterruptedException {
        Thread.sleep(2000);
        click(cartbtn);
    }


}
