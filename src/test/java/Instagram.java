import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Instagram {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void Insta() {
        driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
try {
    WebElement pressLogIn = driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']"));
    pressLogIn.click();


//
//    WebElement fullNmae = driver.findElement(By.xpath("//input[@aria-label='Full Name']"));
//    fullNmae.sendKeys("Kevin De Bruyne");
//
//    WebElement userName = driver.findElement(By.xpath("//input[@aria-label='Username']"));
//    userName.sendKeys("DeBruyneTechtorial");
//
//    WebElement password = driver.findElement(By.xpath("//input[@aria-label='Password']"));
//    password.sendKeys("Manchestercity17");
//
//    WebElement singUp = driver.findElement(By.xpath("//button[@type='submit']"));
//    singUp.click();
}catch (Exception e){
 System.out.println("got Exception");
}
    }
}
