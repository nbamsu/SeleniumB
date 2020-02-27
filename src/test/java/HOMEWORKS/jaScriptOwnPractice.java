package HOMEWORKS;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jaScriptOwnPractice {
    private static WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        JavascriptExecutor jes=(JavascriptExecutor)driver;
        driver.manage().window().maximize();
    }

    @Test
    public void javascript(){
        driver.get("https://learn.letskodeit.com/p/practice");
        WebElement inputText=driver.findElement(By.id("name"));
        inputText.sendKeys("Go go dance");

        WebElement alertButton=driver.findElement(By.id("alertbtn"));
        alertButton.click();

        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void iframe(){
        driver.get("https://www.quirksmode.org/iframetest.html");
        driver.switchTo().frame(0);

        WebElement iframeBox=driver.findElement(By.xpath("//h1"));
        String expected="Test page in iframe";
        String actual=iframeBox.getText();
        Assert.assertEquals(expected,actual);
    }
}
