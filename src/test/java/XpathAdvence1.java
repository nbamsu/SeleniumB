import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathAdvence1 {


    @Test
    public void testHeader2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/abtest");
        WebElement test=driver.findElement(By.xpath("//p"));
   // Assert.assertTrue(test.getText().startsWith("Also"));
    Assert.assertFalse(!test.getText().startsWith("Also"));

    }
}
