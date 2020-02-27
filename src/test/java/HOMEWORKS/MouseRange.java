package HOMEWORKS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseRange {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void MoveRange(){
    HelperMethod(40);
   // WebElement range=driver.findElement(By.xpath("//input[@id='range']"));
   // double r=Double.parseDouble(range.getText());

    }
    public static void HelperMethod(int numberX){

        driver.get("http://the-internet.herokuapp.com/horizontal_slider");


        WebElement range=driver.findElement(By.xpath("//input[@type='range']"));
        Actions action=new Actions(driver);
        action.clickAndHold(range).moveByOffset(numberX,0).build().perform();


    }
}
