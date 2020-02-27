package HOMEWORKS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonChangeColore {
    @Test
    public void changeColore(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");
        String singColoreActual="#111";
        String singColore=driver.findElement(By.id("")).getCssValue("colore");

    }
}
