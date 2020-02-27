import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExpediaAdults {
    private static WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void Expedia() {

        driver.get("https://expedia.com");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']"));
        button.click();
        WebElement departure = driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
        departure.sendKeys("Salt Lake City");

        WebElement destination = driver.findElement(By.id("flight-destination-hp-flight"));
        destination.sendKeys(" Las Vegas");

        WebElement date2 = driver.findElement(By.id("flight-returning-hp-flight"));
        date2.sendKeys("03/15/2020");

        WebElement date = driver.findElement(By.id("flight-departing-hp-flight"));
        date.sendKeys("02/28/2020");


        WebElement close = driver.findElement(By.xpath("//button[@class='datepicker-close-btn close btn-text']"));
        close.click();

        WebElement plus = driver.findElement(By.xpath("//div[@id='traveler-selector-hp-flight']/child::div"));
        plus.click();


        WebElement adults = driver.findElement(By.xpath("//div[@id='traveler-selector-hp-flight']//span[.='Add Adult']//preceding-sibling::span/.."));
        try {
            for (int i = 0; i <= 1; i++) {
                adults.click();
                Thread.sleep(1000);
            }

            WebElement childs = driver.findElement(By.xpath("//div[@id='traveler-selector-hp-flight']//span[.='Add Child']//preceding-sibling::span/.."));

            for (int i = 0; i < 3; i++) {
                childs.click();
                Thread.sleep(1000);
            }



        Select child1 = new Select(driver.findElement(By.id("flight-age-select-1-hp-flight")));
        child1.selectByVisibleText("12");
//        List<WebElement> age=driver.findElements(By.id("flight-age-select-1-hp-flight"));
//        System.out.println(age.size());
//        for (int i=0;i<=age.size();i++){
//            age.get(i).sendKeys("12");
//        }
        Select child2 = new Select(driver.findElement(By.id("flight-age-select-2-hp-flight")));
        child2.selectByVisibleText("5");
        Select child3 = new Select(driver.findElement(By.id("flight-age-select-3-hp-flight")));
        child3.selectByVisibleText("9");
//           Select sortDrop4=new Select(driver.findElement(By.id("flight-age-select-4-hp-flight")));
//            sortDrop4.selectByVisibleText("15");
//            Select sortDrop5=new Select(driver.findElement(By.id("flight-age-select-5-hp-flight")));
//            sortDrop5.selectByVisibleText("16");
//            Select sortDrop6=new Select(driver.findElement(By.id("flight-age-select-6-hp-flight")));
//            sortDrop6.selectByVisibleText("17");

            WebElement close2 = driver.findElement(By.xpath("//fieldset[@id='flightlegs-list-fieldset-2-hp-flight']//..//..//.//preceding::button[@class='close btn-text']"));
            close2.click();
            Thread.sleep(1000);



        WebElement search = driver.findElement(By.xpath("//div[@id='f-fh-msg-tooltip-hp-flight']//preceding-sibling::label//button"));
        search.click();
        Thread.sleep(10000);


//
//        WebElement warning = driver.findElement(By.xpath("//div[@class='alert alert-error validation-alert']"));
//        System.out.println(warning.getText());

        List<WebElement> flights=driver.findElements(By.xpath("//li[@class='flight-module segment offer-listing']"));
        int count=0;
        for (WebElement flightsNumber:flights){
            count++;
            //System.out.println(flightsNumber.getText());
        }
            System.out.println( count);
    }catch (Exception e){
            System.out.println("Got an Exception");
        }

    }
}
