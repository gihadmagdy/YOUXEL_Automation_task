package pages;

import Utils.LoggerManager;
import io.cucumber.java.en.And;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class CartPage extends BasePage{
    public WebDriver driver;
    String cartlabel="Cart (1)";

    LoggerManager utils = new LoggerManager();
    @FindBy(xpath = "//*[@class='-fs20 -m -phm -pvxs']")
    public WebElement validatecart;
    @FindBy(xpath = "//*[@class='btn _prim _md -fw']")
    public WebElement checkoutbtn;
    @FindBy(id = "input_identifierValue")
    public WebElement email;
    @FindBy(xpath = "//*[@class='mdc-button mdc-button--touch mdc-button--raised access-btn']")
    public WebElement continuebtn;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(id = "loginButton")
    public WebElement loginbtn;
    @FindBy(id = "skipPasskeyButton")
    public WebElement skipbtn;
    @FindBy(xpath = "(//*[@class='prc'])[1]")
    public WebElement cartprice;
    @FindBy(xpath = "//*[@class='-fs20 -plm -tar -ubpt']")
    public WebElement checkoutprice;
    @FindBy(xpath = "(//*[@class='-df -i-ctr _more'])[3]")
    public WebElement selectpayment;







    public CartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }
    public void validatecartpage(){
        Assert.assertEquals(get_txt(validatecart),cartlabel);
    }
    public void clickcheckoout(){
        click(checkoutbtn);
    }
    public void enterlogindata() throws IOException, ParseException {
        JSONParser j = new JSONParser();
        FileReader f = new FileReader("C://Users//Gihad.Magdy//IdeaProjects//YOUXEL_Automation_Task//src//test//resources//TestData//testdata.json");
        Object o = j.parse(f);
        JSONObject detail = (JSONObject)o;
        enter_text(email,(String)detail.get("EMAIL"));
        click(continuebtn);
        enter_text(password,(String)detail.get("PASSWORD") );
        click(loginbtn);
        click(skipbtn);
    }
    public void validateprices(){
        StringBuffer sb=new StringBuffer(cartprice.getText());
        sb.delete(0,4);
        String cartPrice= sb.toString();
        cartPrice=cartPrice.replace(",","");
        StringBuffer sb1=new StringBuffer(checkoutprice.getText());
        sb1.delete(0,4);
        String checkprice=sb1.toString();
        checkprice=checkprice.replace(",","");
        Assert.assertTrue(cartPrice.equals(checkprice));


    }
    public void selectpayment(){
       // click(selectpayment);
        Assert.assertTrue(selectpayment.isDisplayed());
    }



}
