import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassIntro {
    @Test
    public void select(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        WebElement click=driver.findElement(By.xpath("//a[@href='/dropdown']"));
        click.click();

        WebElement droppDown=driver.findElement(By.id("dropdown"));
        Select drop=new Select(droppDown);
        drop.selectByVisibleText("Option 1");

    }
}
