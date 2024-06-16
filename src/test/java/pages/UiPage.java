package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;




public class UiPage {

    Actions actions = new Actions(Driver.getDriver());
    Select select;

        public UiPage(){
            PageFactory.initElements(Driver.getDriver(),this);}



        //AutomationPracticeMainPage/SearchTextBox
         @FindBy(id ="search_query_top")
         private WebElement searchTextBox;

        public void searchProduct(){

            searchTextBox.sendKeys("Dress"+Keys.ENTER);
        }

         //ProductListPage/SortByDropDown
         @FindBy(xpath ="//select[@class='selectProductSort form-control']")
         private WebElement sortDropDown;

         public void sortProduct(){

             select=new Select(sortDropDown);
             select.selectByVisibleText(ConfigReader.getProperty("selectVisibleSortText"));}

         //ProductListPage/ProductsDinamicXpath
          private WebElement Product(String index){
          String dinamikXpath = "(//div[@class='right-block'])["+index+"]";
          WebElement product=Driver.getDriver().findElement(By.xpath(dinamikXpath));

          return product;}

         //ProductListPage/Products
          @FindBy(xpath ="(//span[text()='More'])[3]")
          private WebElement moreButton;


         public void clickProduct(){
              ReusableMethods.bekle(2);
              JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
              js.executeScript("window.scrollTo(0, 350);");
              Product("3").click();
              moreButton.click();
              ReusableMethods.bekle(2);
          }
         //ProductDetailPage/SizeDropDown
          @FindBy(xpath ="//select[@class='form-control attribute_select no-print']")
          private WebElement sizeDropDown;

          public void selectSize(){

              select=new Select(sizeDropDown);
              select.selectByVisibleText("M");}

          //ProductDetailPage/PlusIcon
          @FindBy(xpath ="//i[@class='icon-plus']")
          private WebElement plusIcon;


          //ProductDetailPage/AddToCartButton
          @FindBy(id ="add_to_cart")
          private WebElement addToCartButton;

          public void addToCart(){
              plusIcon.click();
              JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
              js.executeScript("window.scrollTo(0, 300);");
              addToCartButton.click();
              ReusableMethods.bekle(5);}


          //ProductDetailPage//Cart
           @FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']")
           private WebElement Cart;

           public void verifyText(){
               String expectedText=ConfigReader.getProperty("successAddText");
               Assert.assertTrue(Cart.getText().contains(expectedText));
               ReusableMethods.bekle(2);
           }

}












