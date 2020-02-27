import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Expedia {
    private static WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
   public void ex(){
         driver.get("https://expedia.com");
        WebElement button=driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']"));
        button.click();
        WebElement departure=driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
        departure.sendKeys("Salt Lake City");

        WebElement destination=driver.findElement(By.id("flight-destination-hp-flight"));
        destination.sendKeys(" Las Vegas");

        WebElement date2=driver.findElement(By.id("flight-returning-hp-flight"));
        date2.sendKeys("02/13/2020");

        WebElement date=driver.findElement(By.id("flight-departing-hp-flight"));
        date.sendKeys("01/29/2020"+ Keys.ENTER);

        WebElement destinationTag=driver.findElement(By.xpath("//span[@class='title-city-text']"));
            System.out.println(destinationTag.getText());

            WebElement homePage=driver.findElement(By.id("header-logo"));
            homePage.click();

            WebElement hotel=driver.findElement(By.id("tab-hotel-tab-hp"));
            hotel.click();
//
//            WebElement departur=driver.findElement(By.id("departure-airport-1"));
//            WebElement depdate=driver.findElement(By.id("departure-date-1"));
//        System.out.println(departur.getText()+" "+depdate.getText());
//
//        WebElement destinatio=driver.findElement(By.id("arrival-airport-1"));
//        WebElement desdate=driver.findElement(By.id("return-date-1"));
//        System.out.println(destinatio.getText()+" "+desdate.getText());


            WebElement searchHotel=driver.findElement(By.id("hotel-destination-hp-hotel"));
            searchHotel.clear();
            searchHotel.sendKeys("Alaska");


            WebElement checkOut=driver.findElement(By.id("hotel-checkout-hp-hotel"));
            //checkOut.clear();
            checkOut.sendKeys("02/13/2020");


            WebElement checkIn=driver.findElement(By.id("hotel-checkin-hp-hotel"));
            checkIn.clear();
            checkIn.sendKeys("01/29/2020"+ Keys.ENTER);

       WebElement hotelAddress=driver.findElement(By.xpath("//button[@aria-label='Going to Alaska, United States of America']"));
        System.out.println(hotelAddress.getText());


    }
}
