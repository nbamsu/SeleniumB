import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitPractice {
    static WebDriver driver;

    @BeforeTest
    public void setUP(){
        driver= Driver.getDriver("chrom");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void fluentWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement enableButton=driver.findElement(By.id("start"));
        enableButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        Boolean invisible=wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        assert (invisible);

        Wait<WebDriver> wait1=  new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement enableMwssage=wait.until(
                new Function<WebDriver,WebElement>(){
                    public WebElement apply(WebDriver driver){
                        return driver.findElement(By.xpath("//h4[.-'Hello world!']"));
                    }
                }
        );
        String expected="Hello world!";
        String actual=enableMwssage.getText();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void dinumicControl(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enable=driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enable.click();

        Wait<WebDriver>wait=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Throwable.class);


        WebElement message=wait.until(
//                new Function<WebDriver, WebElement>(){
//                    @Override
//                    public WebElement apply(WebDriver driver){
//                        return driver.findElement(By.id("message"));
        driver->driver.findElement(By.id("message"))

        );
        String expected ="It's enabled";
        String actual=message.getText();
        Assert.assertEquals(expected,actual);

        System.out.println(message.getText());
    }
}
