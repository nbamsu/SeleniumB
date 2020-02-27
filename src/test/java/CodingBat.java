import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.crypto.KeySelector;
import java.util.concurrent.TimeUnit;

public class CodingBat {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        WebElement searchButton=driver.findElement(By.name("q"));
        searchButton.sendKeys("codingbat"+ Keys.ENTER);

        WebElement coding=driver.findElement(By.xpath("//h3[.='CodingBat Java']"));
        coding.click();

        WebElement logIn=driver.findElement(By.xpath("//input[@type='text']"));
        logIn.sendKeys("nbamsu@gmail.com");

        WebElement password=driver.findElement(By.name("pw"));
        password.sendKeys("codingbat");

        WebElement logInButton=driver.findElement(By.name("dologin"));
        logInButton.click();
        //input[@type='submit']
        WebElement warmup=driver.findElement(By.xpath("//a[.='Warmup-1']"));
        warmup.click();

        WebElement task=driver.findElement(By.xpath("//a[@href='/prob/p140449']"));
        task.click();

        WebElement textLocation=driver.findElement(By.xpath("//div[@style='margin-top: 0px; width: 600px; height: 402.8px; margin-left: 0px;']"));
        textLocation.click();
        textLocation.sendKeys("return (talking && (hour < 7 || hour > 20));");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement solution=driver.findElement(By.xpath("//html/body/div[4]/div//table/tbody/tr/td/form/p/button[@class='go']"));
        solution.click();




//return (talking && (hour < 7 || hour > 20));
//html/body/div/div[5]/form/div[2]/div/div/div/div[2]/input[@name='q']
    }
}
