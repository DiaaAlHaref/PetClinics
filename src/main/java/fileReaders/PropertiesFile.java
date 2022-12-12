package fileReaders;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import utils.HandleExceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    /**
     * Method reads from properties file with array of string key,value
     *
     * @param data key passed to search for in properties file
     * @return value attached to passed data parameter in properties file
     */
    public static String[] propertiesFileReader(String[] data) throws FileNotFoundException {

        String[] datafile = new String[data.length];  //Array of string declaration
        Properties property = new Properties();      //Properties file declaration

        try {
            InputStream input = new FileInputStream("src/test/resources/DataDriven/data.properties");
            //properties file path declaration
            property.load(input);  // load inputs in the file key , value
        } catch (InvalidOperationException e) {
            HandleExceptions.IOExceptionHandling(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < data.length; i++) {
            datafile[i] = property.getProperty(data[i]);
            // loop on the values of the file , get the value in datafile[], get key from data[]
        }
        return datafile; // return value
    }


}
