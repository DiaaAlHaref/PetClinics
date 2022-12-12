package storeTest;

import POM.CartPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UiActions;

import java.util.List;

public class TestScenario extends BaseTest{

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage = new CartPage();

    @Test
    public void Test_01Registration_With_ANewUser() throws InterruptedException {
        homePage.clickOnSignUpLink();
        homePage.InputUsername();
        homePage.InputUserPassword();
        homePage.ClickOnSignUpButton();
        homePage.VerifyMessageDisplayed();
       Assert.assertEquals( homePage.VerifyMessageDisplayed(),"Sign up successful.");
    }

    @Test
    public void Test_02Registration_With_ExistUser() throws InterruptedException {
        homePage.clickOnSignUpLink();
        homePage.InputUsername();
        homePage.InputUserPassword();
        homePage.ClickOnSignUpButton();
        homePage.VerifyMessageDisplayed();
        Assert.assertEquals(homePage.VerifyMessageDisplayed(),"This user already exist.");
    }
    @Test
    public void Test_03Login(){
        loginPage.ClickOnLoginLink();
        loginPage.LoginWithUsername();
        loginPage.LoginWithPassword();
        loginPage.clickOnLogin();
        Assert.assertEquals(loginPage.CheckNameOfUser(),"Welcome Samirr");

    }
    @Test(dependsOnMethods = {"Test_03Login"})
    public void Test_04Categories(){
        List<WebElement> CategoriesList = UiActions.driver.findElements(By.xpath("//div[@class='list-group']/a[@class='list-group-item']"));
        for (WebElement Categories:CategoriesList) {
            Categories.getSize();
            System.out.println(Categories.getText());
            Assert.assertTrue(Categories.isDisplayed());
        }
    }


    @Test(dependsOnMethods = {"Test_03Login"})
    public void Test_05AddRandomProductToTheCartAndVerifyProductAdded()throws InterruptedException{
        homePage.ChooseProduct();
        Assert.assertEquals(productDetailsPage.ProductDetails(),"Samsung galaxy s6");
        productDetailsPage.AddProductToCart();
        Assert.assertEquals(homePage.GetAlertMessage(),"Product added.");
        productDetailsPage.AcceptAlert();
        productDetailsPage.clickOnCartLink();
        Assert.assertEquals(cartPage.CheckAddedProduct(),"Samsung galaxy s6");

    }

    @Test(dependsOnMethods = {"Test_03Login"})
    public void Test_06RemoveProductFromTheCart()throws InterruptedException{
        homePage.ChooseProduct();
        productDetailsPage.AddProductToCart();
        productDetailsPage.AcceptAlert();
        productDetailsPage.clickOnCartLink();
        cartPage.DeleteItemAdded();
    }

    @Test(dependsOnMethods = {"Test_03Login"})
    public void Test_07CompleteSuccessfulCheckoutWithRandomItem()throws InterruptedException{
        homePage.ChooseProduct();
        Assert.assertEquals(productDetailsPage.ProductDetails(),"Samsung galaxy s6");
        productDetailsPage.AddProductToCart();
        Assert.assertEquals(homePage.GetAlertMessage(),"Product added.");
        productDetailsPage.AcceptAlert();
        productDetailsPage.clickOnCartLink();
        Assert.assertEquals(cartPage.CheckAddedProduct(),"Samsung galaxy s6");
        cartPage.PlaceOrder();
        cartPage.Checkout_AddUsername();
        cartPage.Checkout_AddCreditCard();
        cartPage.ClickPurchaseButton();
        Assert.assertEquals(cartPage.VerifyDisplayedMessage(),"Thank you for your purchase!");
    }
}
