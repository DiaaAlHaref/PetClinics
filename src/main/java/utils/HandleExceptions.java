package utils;
/**
 * This Class Handle most needed exceptions in the framework not all of them
 */

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;

public class HandleExceptions {
    /**
     * Method Handling Input/Output Exception
     *
     * @param e reference to get exception message , cause
     */
    public static void IOExceptionHandling(InvalidOperationException e) {
        System.out.println("IO Exception");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling if file not found
     *
     * @param e reference to get exception message , cause
     */
    public static void FileNotFoundExceptionHandling(FileNotFoundException e) {
        System.out.println("Test Data file Not Found Exception");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling if timeout exceed more time to execute ex. waitforelement to be visible, clickable
     *
     * @param e reference to get exception message , cause
     */
    public static void TimeoutExceptionHandling(TimeoutException e) {
        System.out.println("Timeout Execution Exception");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling if element not found
     *
     * @param e reference to get exception message , cause
     */
    public static void NoSuchElementExceptionHandling(NoSuchElementException e) {
        System.out.println("Element not found , Driver cannot locate the element");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling Invalid path of a locator
     *
     * @param e reference to get exception message , cause
     */
    public static void InvalidSelectorExceptionHandling(InvalidSelectorException e) {
        System.out.println("Invalid Path");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling errors while closing browser
     *
     * @param e reference to get exception message , cause
     */
    public static void NoSuchSessionExceptionHandling(NoSuchSessionException e) {
        System.out.println("Error while closing the browser");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling if driver can't interact with the element locator
     *
     * @param e reference to get exception message , cause
     */
    public static void ElementNotInteractableExceptionHandling(ElementNotInteractableException e) {
        System.out.println("Can't interact with the element");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    /**
     * Method Handling object created and refers to null , ex. not instantiated
     *
     * @param e reference to get exception message , cause
     */
    public static void NullPointerExceptionHandling(NullPointerException e) {
        System.out.println("Null Pointer Exception , Object refers to null");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

    public static void IllegalArgumentExceptionHandling(IllegalArgumentException e){
        System.out.println("Illegal Argument Exception, Object refers to null");
        System.out.println("Error Message is : " + e.getMessage());
        System.out.println("Error Cause is : " + e.getCause());
    }

}
