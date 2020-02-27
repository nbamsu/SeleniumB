import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class task {
    @Test
    public void testCase() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement head = driver.findElement(By.xpath("//h3"));
        head.getText();
        Assert.assertEquals(head.getText(), "Add/Remove Elements");


        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i <= 5; i++) {
            button.click();
            button=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        }
        List<WebElement> listOfButton=driver.findElements(By.xpath("//button[@class='deleteElement"));
        WebElement delete = driver.findElement(By.xpath("//div/button[@onclick='deleteElement()']"));
        int count = 0;
        while (count < 5) {
            delete.click();
            delete = driver.findElement(By.xpath("//div/button[@onclick='deleteElement()']"));
            count++;

        }
        Assert.assertTrue(delete.isDisplayed());


    }

    @Test
    public void deleteButton() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        List<WebElement> deleteButton = driver.findElements(By.xpath("//div/button[@onclick='deleteElement()']"));

        Assert.assertEquals(5, deleteButton.size());

        int count = 0;
        while (count < 4) {
            deleteButton.get(count).click();
            count++;
        }
        deleteButton = driver.findElements(By.xpath("//button[@class='added-manually']"));
        Assert.assertEquals(1, deleteButton.size());

    }

    @Test
    public void newTest() {
        //instantiating driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigating to a web page
        driver.get("https://google.com");

        WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
        searchBar.sendKeys("Selenium java" + Keys.ENTER);
            //locating all links by a common tag
        List<WebElement> lists = driver.findElements(By.xpath("//h3"));
                //looping all list of links and printing out
        for (WebElement link : lists) {
            System.out.println(link.getText());
            if (!link.getText().toLowerCase().contains("videos")) {
                Assert.assertTrue(link.getText().toLowerCase().contains("selenium"));
            }
        }
    }
}

