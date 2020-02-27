import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Attributevalue {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void getAttributes(){
        driver.get("https://www.amazon.com/s?k=iphone&ref=nb_sb_noss");
        List<WebElement> ratingList=driver.findElements(By.xpath("//span[contains(@aria-label,'out of 5 stars')]"));

        for (WebElement rating:ratingList){
            for (int i=0;i<ratingList.size();i++){
          //find lowest and highest rating
                System.out.println(ratingList.get(i).getText());
            }
            System.out.println();
        }
    }
}
