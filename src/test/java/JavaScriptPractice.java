import Utils.Driver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptPractice{
    static WebDriver driver;
    @BeforeTest
    public void setup(){
        driver= Driver.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void javaScriptAlert(){
        JavascriptExecutor jes=(JavascriptExecutor)driver;
        jes.executeScript("alert('This is javascript alert')");
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void test2(){
        JavascriptExecutor jes=(JavascriptExecutor)driver;
        jes.executeScript("window.location='https://www.amazon.com/'");
        //jes.executeScript("window.scrollBy(1000,0)");

        long width=(Long)jes.executeScript("return window.innerWidth");
        long height=(Long)jes.executeScript("return window.innerHeight");
        System.out.println(width+" width of the page");
        System.out.println(height+" height of the page");
//        jes.executeScript("window.scrollBy(0,4500)");
//        jes.executeScript("window.scrollBy(0,-3000)");
        WebElement stopPoint=driver.findElement(By.xpath("//a[@id='navBackToTop']//following::a[.='Careers']"));
        jes.executeScript("arguments[0].scrollIntoView(true)",stopPoint);
        jes.executeScript("arguments[0].click()",stopPoint);

            //if you want to find the element using LinkText your tag needs to be <a href="https://www.amazon.jobs"></a>
    }
}
