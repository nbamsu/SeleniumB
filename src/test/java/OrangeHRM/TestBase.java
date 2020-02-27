package OrangeHRM;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

   static WebDriver driver;
   @Parameters("DriverName")
   @BeforeTest(alwaysRun = true)
    public void setUpDriver(String DriverName){
        driver= Driver.getDriver(DriverName);
        driver.manage().window().maximize();

    }
}
