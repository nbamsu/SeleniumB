import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWaitPractice {

   private static WebDriver driver;
    @BeforeClass
    public void setUpDriver(){
        driver= Driver.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
//    @Test(description = "Remove btn will display the 'it is gone' contects")
//    public void validateRemoveBtn(){
//        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
//        WebElement button = driver.findElement(By.xpath("//form[@id='checkbox-example']//following-sibling::button"));
//        button.click();
//        WebElement TEXT = driver.findElement(By.id("message"));
//        String actual = TEXT.getText();
//        String expected = "It's gone!";
//        Assert.assertEquals(actual,expected);
//        button.click();
//        WebElement backMsg = driver.findElement(By.xpath("//p[@id='message']"));
//        String expectedText = "It's back!";
//        String actualText = backMsg.getText();
//        Assert.assertTrue(backMsg.isDisplayed());
//        Assert.assertEquals(expectedText,actualText);
//    }
    @Test(description = "explicit wait")
    public void enabled(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement Enabled = driver.findElement(By.xpath("//button[.='Enable']"));
        Enabled.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean loadingButton=wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        Assert.assertTrue(loadingButton);
        WebElement helloWorld=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='message']"))));
        String expected = "It's enabled!";
        String actual =helloWorld.getText();
        Assert.assertEquals(expected,actual);
    }



}
