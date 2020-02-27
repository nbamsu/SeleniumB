import Utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class iFramePractice {
    static WebDriver driver;

    @BeforeTest
    public void setUP() {
        driver = Driver.getDriver("chrom");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void iframe1(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        WebElement textBox=driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Techtorial academy");
    }
    @Test
    public void iframeTest(){
        driver.get("https://www.quirksmode.org/iframetest.html");
        driver.switchTo().frame(0);

        WebElement textInBox=driver.findElement(By.xpath("//h1"));
        System.out.println(textInBox.getText());
        String expected="Test page in iframe";
        String actual=textInBox.getText();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void toolsIframe(){
        driver.get("https://www.toolsqa.com/iframe-practice-page/");
        JavascriptExecutor jes=(JavascriptExecutor)driver;
        jes.executeScript("window.scrollBy(0,500)");

        driver.switchTo().frame("iframe1");
        WebDriverWait wait=new WebDriverWait(driver,12);
        Actions action= new Actions(driver);
//            action.sendKeys(Keys.ARROW_DOWN);
//
            action.sendKeys(Keys.PAGE_DOWN);
        WebElement software=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Software Testing Tutorial']"))));
        software.click();


    }
}
