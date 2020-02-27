import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathAdvenced {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/abtest");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());

        if(header.getText().equals("A/B Test Variation 1")){
            System.out.println("My test passed");
        }else{
            System.out.println("My test failed");
        }



        }
        @Test
        public void testHeader(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.get("http://the-internet.herokuapp.com/abtest");
            WebElement header=driver.findElement(By.tagName("h3"));
            Assert.assertEquals(header.getText(),"A/B Test Variation 1");



    }
}
