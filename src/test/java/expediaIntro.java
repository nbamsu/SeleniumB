import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class expediaIntro {
     public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://google.com");
      //navigate to expedia.com
      //click on Bundle and Save button
      //enter some text in Original
      //enter some text

    }
}
