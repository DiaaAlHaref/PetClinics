package POM;

import fileReaders.PropertiesFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.HandleExceptions;
import utils.UiActions;

import java.io.FileNotFoundException;

public class HomePage {
    UiActions uiActions = new UiActions();

    private String[] view;
    {
        try {
            view = PropertiesFile.propertiesFileReader(new String[]{"SignInLinkLocator","SignInUsernameLocator"
            ,"SignInPasswordLocator","SignUpButtonLocator","SelectedProductLocator"});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final By SignInLinkLocator = By.id(view[0]);
    private final By SignInUsernameLocator = By.id(view[1]);
    private final By SignInPasswordLocator = By.id(view[2]);
    private final By SignUpButtonLocator = By.xpath(view[3]);
    private final By SelectedProductLocator = By.xpath(view[4]);
    public void clickOnSignUpLink(){
        uiActions.findElementAndReturn(SignInLinkLocator)
                .takeActionOnElement("click");
    }
    public void InputUsername() {
        uiActions.WaitForElement(SignInUsernameLocator, "visible")
                .findElementAndReturn(SignInUsernameLocator)
                .sendKeysToElement("Nour8959");
    }
    public void InputUserPassword() {
        uiActions.findElementAndReturn(SignInPasswordLocator)
                .sendKeysToElement("Nour8959");

    }

    public void ClickOnSignUpButton(){
        uiActions.findElementAndReturn(SignUpButtonLocator)
                .takeActionOnElement("click");
    }
    public String GetAlertMessage() {
        return UiActions.wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    public String VerifyMessageDisplayed() {
       String GetAlertMessage=  UiActions.wait.until(ExpectedConditions.alertIsPresent()).getText();
        try {
            if (GetAlertMessage.equals("Sign up successful.")) {
                uiActions.HandleAlert("accept");
            } else if (GetAlertMessage.equals("This user already exist.")) {
                uiActions.HandleAlert("dismiss");
                uiActions.findElementAndReturn(SignInUsernameLocator)
                        .ClearTextField(SignInUsernameLocator)
                        .sendKeysToElement("Samirr");

                uiActions.findElementAndReturn(SignInPasswordLocator)
                        .ClearTextField(SignInPasswordLocator)
                        .sendKeysToElement("Samirr");

                uiActions.findElementAndReturn(SignUpButtonLocator)
                        .takeActionOnElement("click");

            }
        }catch (NullPointerException e){
            HandleExceptions.NullPointerExceptionHandling(e);
        }
        return GetAlertMessage;
        }

    public void ChooseProduct() throws InterruptedException {
        Thread.sleep(1000);
            uiActions.findElementAndReturn(SelectedProductLocator)
                    .getTextOfElement();
            uiActions.WaitForElement(SelectedProductLocator,"clickable")
                    .takeActionOnElement("click");

    }
}
