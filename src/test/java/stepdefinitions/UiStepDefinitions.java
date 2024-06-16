package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.UiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class UiStepDefinitions {


        UiPage uiPage=new UiPage();
        @Given("The user goes to the {string}")
        public void the_user_goes_to_the(String url) throws IOException {

            Driver.getDriver().get(ConfigReader.getProperty("automationPracticeUrl"));
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("firstStep"));}


          @And("Search by typing a {string} in the search box.")
          public void searchByTypingAInTheSearchBox(String productName) throws IOException {
            uiPage.searchProduct();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("secondStep"));}


           @Then("Sort products from A to Z")
           public void sortProductsFromAToZ() throws IOException {
            uiPage.sortProduct();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("thirdStep"));}

           @And("Clicks on the {string} product")
           public void clicksOnTheProduct(String index) throws IOException {

            uiPage.clickProduct();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("fourthStep"));}

           @And("Selects the {string} size of the product")
            public void selectsTheSizeOfTheProduct(String size) throws IOException {
            uiPage.selectSize();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("fifthStep"));}

           @And("Adds {int} items to the cart")
           public void addsItemsToTheCart(int items) throws IOException {
            uiPage.addToCart();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("sixthStep"));}
           @And("Verifies the products is successfully added to the cart")
            public void verifiesTheProductsIsSuccessfullyAddedToTheCart() throws IOException {
            uiPage.verifyText();
            ReusableMethods.takeScreenshot(ConfigReader.getProperty("seventhStep"));}


           @And("Close Browser")
           public void closeBrowser() {
            Driver.closeDriver();}

}

