package OrangeHRM;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orange {
    private static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void beforetest(){

        driver= Driver.getDriver("ff");
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
        WebElement login=driver.findElement(By.id("btnLogin"));
        login.click();
    }



    @Test(groups = {"url"})
    public void verifyURL(){
        String expectedUrl="https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);
    }
    @Test(groups = {"title"})
    public void verifyTitle(){
        String expectedTitle="OrangeHRM";
        String actula=driver.getTitle();
        Assert.assertEquals(expectedTitle,actula);
    }
}
