import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.management.jdp.JdpPacketReader;

import java.util.concurrent.TimeUnit;

public class Ebay {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://ebay.com");

        WebElement searchBar=driver.findElement(By.id("gh-ac"));
        searchBar.sendKeys("headlights");
        WebElement searchButton=driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement searchBarAgain=driver.findElement(By.id("gh-ac"));
        searchBarAgain.sendKeys("  for Toyota Camry LE"+ Keys.ENTER);

//        WebElement searchButton2=driver.findElement(By.xpath("//input[@id='gh-btn']"));
//        searchButton2.click();
        WebElement buy=driver.findElement(By.xpath("//ul/li[4][@class='fake-tabs__item btn']"));
        buy.click();

        WebElement product= driver.findElement(By.xpath("//h3[.='For 99-02 Silverado Tahoe LED DRL Black Housing Clear Lens Headlights Assembly']"));
        product.click();

        WebElement addToCard=driver.findElement(By.id("isCartBtn_btn"));
        addToCard.click();

        WebElement noThanks=driver.findElement(By.xpath("//button[.='No thanks']"));
        noThanks.click();

        WebElement checkOut=driver.findElement(By.xpath("//button[contains(@class,'call-to-action btn btn--large btn--primary')]"));
        checkOut.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement continueCh=driver.findElement(By.id("gxo-btn"));
        continueCh.click();


    }
}
