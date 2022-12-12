package storeTest;

import fileReaders.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.HandleExceptions;
import utils.UiActions;

import java.io.FileNotFoundException;

public class BaseTest {

    String[] view;

    {
        try {
            view = PropertiesFile.propertiesFileReader(new String[]{"baseUrl"});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected final String baseUrl= view[0];

    @BeforeMethod
    @Parameters({"browser"}) //To Run Test From parallelTest.xml file used with Selenium Grid
    public void startupDrivers(@Optional("edge") String browser) {
        //@optional used to run test by default value passed to it ex. ("chrome")
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                UiActions.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                UiActions.driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                UiActions.driver= new EdgeDriver();
                break;
        }

        UiActions.driver.navigate().to(baseUrl);   //Navigate to target url
        UiActions.driver.manage().window().maximize();  //Maximize browser window size

    }
    @AfterMethod
    public void TearDown(){
        try {
            UiActions.driver.quit();
        } catch (NoSuchSessionException e) {
            HandleExceptions.NoSuchSessionExceptionHandling(e);
        }
    }
}
