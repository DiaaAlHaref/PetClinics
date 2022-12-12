package POM;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utils.UiActions;

import java.io.FileNotFoundException;

public class ProductDetailsPage {
 UiActions uiActions = new UiActions();

    private String[] view;

    {
        try {
            view = PropertiesFile.propertiesFileReader(new String[]{"ProductNameLocator","AddToCartButtonLocator"
            ,"CartLinkLocator"});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final By ProductNameLocator = By.xpath(view[0]);
    private final By AddToCartButtonLocator = By.xpath(view[1]);
    private final By CartLinkLocator = By.id(view[2]);

    public String ProductDetails() {

        return  uiActions.WaitForElement(ProductNameLocator,"visible")
                .findElementAndReturn(ProductNameLocator)
                .getTextOfElement();

    }

    public void AddProductToCart(){
        uiActions.WaitForElement(AddToCartButtonLocator,"visible")
                .findElementAndReturn(AddToCartButtonLocator)
                .takeActionOnElement("click");
    }

    public void AcceptAlert(){
        uiActions.HandleAlert("accept");
    }

    public void clickOnCartLink() throws InterruptedException {
        uiActions.findElementAndReturn(CartLinkLocator)
                .takeActionOnElement("click");
        Thread.sleep(1000);
    }
}
