package stepdefinition;

import Utils.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import pages.CartPage;

import java.io.IOException;

public class CartStepDef extends BrowserDriver {

    public CartPage cartPage=new CartPage(driver) ;

    @Then("validate that user navigated to cart page")
    public void validate_that_user_navigated_to_cart_page() {
        cartPage.validatecartpage();
    }
    @Then("validate that the price add right in checkout")
    public void validate_that_the_price_add_right_in_checkout() {
        cartPage.validateprices();
    }
    @And("user click checkout button")
    public void user_click_checkout_button() {
        cartPage.clickcheckoout();
    }
    @And("user enter his data to login")
    public void user_enter_his_data_to_login() throws IOException, ParseException {
        cartPage.enterlogindata();
    }
    @Then("user can choose payment method")
    public void usercanchoosepaymentmethode(){
        cartPage.selectpayment();
    }



}
