package POM;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utils.UiActions;

import java.io.FileNotFoundException;

public class CartPage {

    UiActions uiActions = new UiActions();

     String[] view;

    {
        try {
            view = PropertiesFile.propertiesFileReader(new String[]{"AddedProductLocator","DeleteButtonLocator"
            ,"PlaceOrderButtonLocator","CheckoutUserNameLocator","CreditCardFieldLocator"
            ,"PurchaseButtonLocator","SuccessfulMessageLocator"});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final By AddedProductLocator=By.xpath(view[0]);
    private final By DeleteButtonLocator=By.xpath(view[1]);
    private final By PlaceOrderButtonLocator=By.xpath(view[2]);
    private final By CheckoutUserNameLocator= By.xpath(view[3]);
    private final By CreditCardFieldLocator = By.id(view[4]);
    private final By PurchaseButtonLocator = By.xpath(view[5]);
    private final By SuccessfulMessageLocator = By.xpath(view[6]);

    public void NavigateToCart(){
        uiActions.findElementAndReturn(By.xpath("//button[@onclick='showcart()']"))
                .takeActionOnElement("click");
    }
    public String CheckAddedProduct() throws InterruptedException {
        Thread.sleep(1000);
        return  UiActions.driver.findElement(AddedProductLocator).getText();

    }

    public void DeleteItemAdded(){
        uiActions.WaitForElement(DeleteButtonLocator,"clickable")
                .findElementAndReturn(DeleteButtonLocator)
                .takeActionOnElement("click");
    }

    public void PlaceOrder(){
      uiActions.findElementAndReturn(PlaceOrderButtonLocator)
              .takeActionOnElement("click");
    }

    public void Checkout_AddUsername(){
        uiActions.WaitForElement(CheckoutUserNameLocator,"visible")
                .findElementAndReturn(CheckoutUserNameLocator)
                .sendKeysToElement("Samirr");
    }

    public void Checkout_AddCreditCard(){
        uiActions.findElementAndReturn(CreditCardFieldLocator)
                .sendKeysToElement("1000123020310");
    }

    public void ClickPurchaseButton(){
        uiActions.scrollDownToElement();
       uiActions.findElementAndReturn(PurchaseButtonLocator)
               .takeActionOnElement("click");
    }

    public String VerifyDisplayedMessage(){
      return  uiActions.WaitForElement(SuccessfulMessageLocator,"visible")
              .findElementAndReturn(SuccessfulMessageLocator)
                .getTextOfElement();
    }
}
