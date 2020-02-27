package HOMEWORKS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDownMenuAssert {
    @Test
    public void Amazon(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();



        //And verify it was selected
        WebElement allMenu=driver.findElement(By.id("searchDropdownBox"));
        Select allselect=new Select(allMenu);
        allselect.selectByIndex(10);


        WebElement selected=driver.findElement(By.xpath("//option[.='Baby']"));
        Assert.assertTrue(selected.isSelected());
            //Verify that all other options are not selected
        List<WebElement> allElements=driver.findElements(By.xpath("//select[@id='searchDropdownBox']//following::option"));
try {
    for (WebElement all : allElements) {
        Select all2 = new Select(all);
        Assert.assertEquals(all2.getAllSelectedOptions(),selected);
    }
}catch (Exception e){
    System.out.println("Exception");
}


    }
}
