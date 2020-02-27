import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://etsy.com");

        WebElement search2=driver.findElement(By.id("global-enhancements-search-query"));
        search2.sendKeys("iphone");
        WebElement button2=driver.findElement(By.xpath("//button[@aria-label='Search']"));
        button2.click();
        WebElement casePh= driver.findElement(By.xpath("(//span[.='14.95'])[1]"));
        casePh.click();
        System.out.println(casePh.getText());

    }
}
