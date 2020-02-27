import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {

    static SoftAssert sa;

   static WebDriver driver;
   @Parameters("DriverName")
   @BeforeTest(alwaysRun = true)
    public void setUpDriver(String DriverName){
        driver= Driver.getDriver(DriverName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sa=new SoftAssert();

    }
}
