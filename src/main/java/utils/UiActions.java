package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UiActions {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;



    public UiActions sendKeysToElement(String Text){
        try {
            element.sendKeys(Text);
        }catch (NullPointerException e){
            HandleExceptions.NullPointerExceptionHandling(e);
        }
        return this;
    }

    public UiActions findElementAndReturn(By Locator){
        try {
            element = driver.findElement(Locator);
        } catch (InvalidSelectorException e) {
           HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        }
        return this;
    }

    public UiActions findListOfElements(By locator) {
        try {
            elements = driver.findElements(locator);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        }
        return this;
    }

    public UiActions ClearTextField(By Locator){
        try {
            driver.findElement(Locator).clear();
        }catch (NullPointerException e){
           HandleExceptions.NullPointerExceptionHandling(e);
        }
        return this;
    }

    public void takeActionOnElement(String action){
        try {
            switch (action){
                case "click":
                    element.click();
                    break;
                case"submit":
                    element.submit();
                    break;
            }
        }catch (NullPointerException e){
            HandleExceptions.NullPointerExceptionHandling(e);
        }catch (ElementNotInteractableException e){
           HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }

    }

    public UiActions WaitForElement(By Locator, String typeOfWait){
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(400));
            switch (typeOfWait){
                case "visible":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                    break;
                case "clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(Locator));
                    break;
            }
        }catch (ElementNotInteractableException e){
           HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }catch (IllegalArgumentException e){
            HandleExceptions.IllegalArgumentExceptionHandling(e);
        }
        return this;
    }



    public UiActions HandleAlert(String type){
        try {
            Alert alert = driver.switchTo().alert();
            switch (type){
                case "accept":
                    alert.accept();
                    break;
                case"dismiss":
                    alert.dismiss();
                    break;
            }
        }catch (NoAlertPresentException e){
            e.getMessage();
        }
        return this;
    }

    public String getTextOfElement() {
            return element.getText();
    }

    public void scrollDownToElement() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,700);");
    }



}
