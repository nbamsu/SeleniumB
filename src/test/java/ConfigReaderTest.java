import Utils.ConfigReader;
import org.testng.annotations.Test;

public class ConfigReaderTest {
    @Test
    public void testConfig(){
        String username= ConfigReader.getProperty("username");
        System.out.println(username);
        String password=ConfigReader.getProperty("password");
        System.out.println(password);
    }
    @Test
    public void testCrefdantial(){
        System.out.println(ConfigReader.getProperty("TokenUrl"));
         System.out.println(ConfigReader.getProperty("ApiUrl"));
          System.out.println(ConfigReader.getProperty("DevEnv"));
    }
}
