package POM;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utils.UiActions;

import java.io.FileNotFoundException;

public class LoginPage {
    UiActions uiActions = new UiActions();

    String[] view;

    {
        try {
            view = PropertiesFile.propertiesFileReader(new String[]{"LoginLinkLocator","LoginUsernameLocator"
                    ,"LoginPasswordLocator","LoginButtonLocator","LoggedInUserNameLocator"});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private final By LoginLinkLocator = By.id(view[0]);
    private final By LoginUsernameLocator = By.id(view[1]);
    private final By LoginPasswordLocator = By.id(view[2]);
    private final By LoginButtonLocator = By.xpath(view[3]);
    private final By LoggedInUserNameLocator = By.xpath(view[4]);

    public void ClickOnLoginLink(){
        uiActions.findElementAndReturn(LoginLinkLocator)
                .takeActionOnElement("click");
    }
    public void LoginWithUsername(){
        uiActions.WaitForElement(LoginUsernameLocator,"clickable")
                .findElementAndReturn(LoginUsernameLocator)
                .ClearTextField(LoginUsernameLocator)
                .sendKeysToElement("Samirr");
    }

    public void LoginWithPassword(){
        uiActions.findElementAndReturn(LoginPasswordLocator)
                .ClearTextField(LoginPasswordLocator)
                .sendKeysToElement("Samirr");
    }

    public void clickOnLogin(){
        uiActions.findElementAndReturn(LoginButtonLocator)
                .takeActionOnElement("click");
    }

    public String CheckNameOfUser(){
        String LoggedInUser =
          uiActions.WaitForElement(LoggedInUserNameLocator,"visible")
                          .findElementAndReturn(LoggedInUserNameLocator)
                                  .getTextOfElement();
     return LoggedInUser;

    }
}
