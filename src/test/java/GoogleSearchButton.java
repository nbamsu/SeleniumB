import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchButton {

    private static WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void google(){
        driver.get("https://google.com");

        try {
            WebElement search=driver.findElement(By.name("q"));
            search.sendKeys("selenium java" + Keys.ESCAPE);
          Thread.sleep(4000);
      }catch (Exception e){
          System.out.println("caught");
      }
        driver.getTitle();
//        WebElement searchButton=driver.findElement(By.id("//input[@id='gbqfbb']"));
//        searchButton.click();
}
}
