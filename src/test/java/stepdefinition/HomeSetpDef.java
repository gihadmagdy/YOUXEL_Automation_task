package stepdefinition;

import Utils.BrowserDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

import java.io.IOException;
import java.util.List;

public class HomeSetpDef extends BrowserDriver {
      private HomePage homePage;
      private BrowserDriver browserDriver;

      @Given("user navigate to home page")
      public void user_navigate_to_home_page() throws IOException {
            browserDriver=new BrowserDriver();
            browserDriver.openurl();


            homePage=new HomePage(driver);
            homePage.validateHomePage();

      }

      @And("user accept cookies")
      public void user_accepts_cookies(){
            homePage.acceptcookies();
      }
      @And("user enter search value")
      public void user_enter_Keyword_search(DataTable searchvalue){
            List<List<String>> svalue = searchvalue.asLists(String.class);
            homePage.enterKeywordToSearch(svalue);
      }
      @And("user click search button")
      public void user_click_search_button() throws InterruptedException {
            homePage.click_search_btn();
      }
      @And("user click sort list")
      public void user_click_sort_list(){
            homePage.click_sort_list();
      }
      @And("user select sort type")
      public void user_select_sort_type(){
            homePage.select_sort_type();
      }
      @Then("validate sortion type")
      public void Validate_Sortion_type(){
            homePage.validate_sort();
      }

      @Given("user click on mobile and tablets from side menu")
      public void user_click_on_mobile_and_tablets_from_side_menu() throws InterruptedException {
             homePage.clickmobileandtablets();
      }

      @Given("user click on desired mobile brand")
      public void user_click_on_desired_mobile_brand() {
            homePage.clickdesiredbrand();
      }

      @Then("validate that mobile brand shown")
      public void validate_that_mobile_brand_shown() {
             homePage.validatebrandname();
      }

      @Then("user click on screen size filter")
      public void user_click_on_screen_size_filter() {
             homePage.filterbycolor();
      }

      @Then("validate that mobile filtered")
      public void validate_that_mobile_filtered() {
             homePage.validatecolor();
      }
      @And("user add item to cart")
      public void user_add_item_to_cart() throws InterruptedException {
            homePage.addToCart();
      }
      @And("user click on cart button in the top right of screen")
      public void user_click_on_cart_button_in_the_top_right_of_screen() throws InterruptedException {
            homePage.clickonCart();
      }


}
