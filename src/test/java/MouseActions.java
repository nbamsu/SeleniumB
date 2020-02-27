import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseActions extends TestBase {
   // private static WebDriver driver;

    @BeforeTest
    public void setup(){

        driver.get("http://the-internet.herokuapp.com/");
//       driver.manage().window().maximize();
    }

    @Test
    public void rightClick() throws InterruptedException {
        //driver.get("http://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();

        Actions actions=new Actions(driver);



        WebElement hover=driver.findElement(By.xpath("//a[@href='/hovers']"));
        hover.click();
            //mouse on picture of user 1
        WebElement user1=driver.findElement(By.xpath("//h5[.='name: user1']//parent::div//preceding-sibling::img[@src='/img/avatar-blank.jpg']"));
        actions.moveToElement(user1).perform(); //build() need to use!
        Thread.sleep(3000);
            // pop-out profile user1
        WebElement User1Profile=driver.findElement(By.xpath("//h5//following::a[@href='/users/1']"));
        Assert.assertTrue(User1Profile.isDisplayed());

        /*
        Verfy that User 2 and User 3 profiles are not shown
        we could assert both in one system out, but ....
         */
        WebElement  User2Profile=driver.findElement(By.xpath("//h5//following::a[@href='/users/2']"));
        Assert.assertFalse(User2Profile.isDisplayed());

        WebElement User3Profile=driver.findElement(By.xpath("//h5//following::a[@href='/users/3']"));
        Assert.assertFalse(User3Profile.isDisplayed());



    }
    @Test
    public void User2(){
        driver.get("http://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();

        Actions action=new Actions(driver);
        /*
        Navigate to http://the-internet.herokuapp.com/hovers
	Hover over User 2 and verify the User name shown
	 */
        WebElement ClickOnHovers=driver.findElement(By.xpath("//a[@href='/hovers']"));
        ClickOnHovers.click();

        WebElement user2=driver.findElement(By.xpath("//h5[.='name: user2']//parent::div//preceding-sibling::img[@src='/img/avatar-blank.jpg']"));
        action.moveToElement(user2).perform();

        WebElement User2Profile =driver.findElement(By.xpath("//h5[.='name: user2']//following-sibling::a"));
        Assert.assertTrue(User2Profile.isDisplayed());

        //And Verify that User 1 and User 3 UserNames are not shown
        WebElement User1Profile=driver.findElement(By.xpath("//h5//following::a[@href='/users/1']"));
        Assert.assertFalse(User1Profile.isDisplayed());
        WebElement User3Profile=driver.findElement(By.xpath("//h5//following::a[@href='/users/3']"));
        Assert.assertFalse(User3Profile.isDisplayed());




    }

    @Test
    public void Deselect(){
        driver.get("https://learn.letskodeit.com/p/practice");

        ////div[@id='checkbox-example']//following::legend[.='Checkbox Example']
        WebElement BMW=driver.findElement(By.xpath("//input[@id='bmwcheck']"));
        BMW.click();
        Select actions=new Select(BMW);
        WebElement Benz=driver.findElement(By.id("benzcheck"));
        //Benz.click();
        WebElement Honda=driver.findElement(By.id("hondacheck"));
        //Honda.click();


    }
    }

