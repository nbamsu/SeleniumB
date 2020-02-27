import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitPractice  {
    private static WebDriver driver;
    @BeforeTest
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        driver= Driver.getDriver("chrome");
    }

    @Test(description = "Remove button will display its gone text")

    public void DynumicControll(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage();
        //PageLoadTiemOut method will wait untill webpage will loaded fully
        WebElement remove= driver.findElement(By.xpath("//button[.='Remove']"));
        remove.click();

        WebElement verify=driver.findElement(By.id("//p[@id='message']"));
        Assert.assertTrue(verify.isDisplayed());
    }
}
