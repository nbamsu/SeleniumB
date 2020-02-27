import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DragAndDrop {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @Test
    public void DrugAndDro(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement drugDrop=driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
        drugDrop.click();
        Actions action=new Actions(driver);
        WebElement boxA=driver.findElement(By.id("column-a"));
        WebElement boxB=driver.findElement(By.id("column-b"));

      // action.dragAndDrop(boxA,boxB).build().perform();
        action.clickAndHold(boxB).build().perform();

    }
    @Test
    public void Slider(){
//        driver.get("http://the-internet.herokuapp.com/");
//
//        WebElement horizontal=driver.findElement(By.xpath("//a[@href='/horizontal_slider']"));
//        horizontal.click();
//        Actions action=new Actions(driver);
//        WebElement but=driver.findElement(By.xpath("//input"));
//       action.clickAndHold(but).moveByOffset(4,0).release().build().perform();
//       WebElement range=driver.findElement(By.xpath("//span[@id='range']"));
//       Assert.assertTrue(range.isEnabled());

     sliderHelper(3,0);
     WebElement range=driver.findElement(By.xpath("//span[@id='range']"));
     Double r=Double.parseDouble(range.getText());
     Assert.assertNotEquals(r,0.0, "Failed to verify if double not equals");
     Assert.assertTrue(!range.getText().equals("0"),"failed to verify string value");
     Assert.assertTrue(r>0.0,"Failed to verify if double is larger than 0.0");

    }
    public static void sliderHelper(int xNum,int yNum){
        driver.get("http://the-internet.herokuapp.com/");

        WebElement horizontal=driver.findElement(By.xpath("//a[@href='/horizontal_slider']"));
        horizontal.click();
        Actions action=new Actions(driver);
        WebElement but=driver.findElement(By.xpath("//input"));
        action.clickAndHold(but).moveByOffset(xNum,yNum).release().build().perform();
    }
    @Test
    public void mouseHoverOver() throws InterruptedException {
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
        Actions action=new Actions(driver);
        WebElement mouse=driver.findElement(By.id("mousehover"));
        action.moveByOffset(0,-8);
        Thread.sleep(3000);
        action.moveToElement(mouse).build().perform();


        WebElement reload=driver.findElement(By.xpath("//a[.='Reload']"));
      action.click(reload);
    }

    @Test
    public void Clicks(){
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
       Actions action=new Actions(driver);
        //WebElement  doubleClick=driver.findElement(By.id("puff_content"));
        //action.doubleClick(doubleClick).build().perform();

      //  WebElement blind=driver.findElement(By.id("blind_content"));
        //action.click(blind).build().perform();

        List<WebElement> allElements=driver.findElements(By.xpath("//tbody//div[contains(@id,'header')]//following-sibling::div"));
        for (WebElement all:allElements){
            //System.out.println(all.getText());
            switch (all.getText()){
                case "click":
                    action.click(all).build().perform();
                    break;
                case"doubleclick":
                    action.doubleClick(all).build().perform();
                    break;
        }
            Assert.assertFalse(all.isDisplayed());

        }
    }
}
