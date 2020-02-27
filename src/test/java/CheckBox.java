import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox {
    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void checkbox() {
        driver.get("http://the-internet.herokuapp.com/");

        WebElement click = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        click.click();

        WebElement box1 = driver.findElement(By.xpath("//input[last()-1]"));
        try {
            if (!box1.isSelected()) {
                Thread.sleep(2000);
                box1.click();
            }
        } catch (Exception e) {
            System.out.println("got one");
        }
//        WebElement box2=driver.findElement(By.xpath("//input[last()-1]"));
//        box2.click();

        Assert.assertTrue(box1.isSelected());

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement box3 : boxes) {
            System.out.println(box3.isSelected());
            if (!box3.isSelected()) {
                box3.click();
            }
            Assert.assertTrue(box3.isSelected(), "If not go away");
        }
   /* for(WebElement checkbox:boxes){
        if ((checkbox.isSelected())){
            checkbox.click();
            Assert.assertFalse(checkbox.isSelected());
        }else if (!checkbox.isSelected()){
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());
        }
    }

     */


    }

    @Test
    public void checkboxVerFucation() {
        driver.get("http://the-internet.herokuapp.com/");

        WebElement click = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        click.click();

        WebElement box1 = driver.findElement(By.xpath("//input[last()-1]"));
        box1.click();
        System.out.println(box1.getAttribute("checked"));

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : boxes) {
            if ((checkbox.getAttribute("checked")==null)) {
                checkbox.click();
                Assert.assertFalse(checkbox.isSelected());
                Assert.assertEquals(checkbox.getAttribute("checked"),"true");
            } else if (checkbox.getAttribute("checked").equals("true")) {
                checkbox.click();
                Assert.assertFalse(checkbox.isSelected());
                Assert.assertNull(checkbox.getAttribute("checked"));
//                Boolean.parseBoolean("true");
//                Boolean.parseBoolean("shdgfsdfs");


            }
        }
    }
}
