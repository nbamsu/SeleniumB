import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mentoring {
    @Test
    public void testXpath(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://uscis.gov");

        WebElement fileOnline=driver.findElement(By.xpath("//a[@class='file-online-btn']"));
        //fileOnline.click();
        WebElement text=driver.findElement(By.cssSelector("div.sep-line-title"));
        System.out.println("New and Events: "+ text.getText());

    }
}
