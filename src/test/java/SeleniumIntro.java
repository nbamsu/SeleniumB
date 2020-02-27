import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {
public static void main(String []args){

    WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   
//
//    driver.get("https://www.google.com");
//    driver.get("https://www.amazon.com");
//    driver.get("https://www.codingbat.com");
 //   driver.get("https://www.ok.ru");
  //  driver.get("https://www.NBA.com");
    driver.get("https://expedia.com");

    WebElement bundleButton =driver.findElement(By.xpath("//button[@id='tab-package-tab-hp']"));
    bundleButton.click();
    WebElement originField= driver.findElement(By.xpath("//input[@id='package-origin-hp-package']"));
    originField.sendKeys("Chicago");
   WebElement destination= driver.findElement(By.xpath("//input[@id='package-destination-hp-package']"));
   destination.sendKeys("New York");
   WebElement search=driver.findElement(By.xpath("//button[@id='search-button-hp-package']"));
   search.click();
}
}
