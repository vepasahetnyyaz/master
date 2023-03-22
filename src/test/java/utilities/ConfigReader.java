package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * This class is used to get the values from Configuration.properties file.
     * .getProperty(key) method accepts key as String and returns the values of that key from the properties file.
     * @param String key
     * @return String value
     */

    private static FileInputStream input;
    private static Properties properties;

    static {
        String path = System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");
        } finally {
            try {
                assert input != null;
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occurred when trying to close input object");
            }
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
