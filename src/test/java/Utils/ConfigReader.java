package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    static Properties configFile;

    static{
        try {
            //
        String path="src\\test\\java\\credantials.properties";
        FileInputStream input=new FileInputStream(path);
        configFile=new Properties();
        configFile.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyName){
        return configFile.getProperty(keyName);
    }

}

//Create the reader try to read the value from prorerties
//Autorized value
//username
//password
//WebsiteAddress
//tokenApiUrl
//basetestUrl