import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Amazon {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("https://amazon.com");
        driver.get("https://etsy.com");
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
    search.sendKeys("iphone");
    WebElement searchButton=driver.findElement(By.xpath("//div[@id='nav-search']//input[@type='submit']"));
    searchButton.click();
    WebElement product=driver.findElement(By.xpath("//h2//span[.='Simple Mobile Prepaid - Apple iPhone XS (64GB) - Gold']"));
        product.click();
        WebElement iphonePrice=driver.findElement(By.id("//td//span[@id='priceblock_ourprice']"));
        System.out.println("Price "+iphonePrice.getText());


    }


}
