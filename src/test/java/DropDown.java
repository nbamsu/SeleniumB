import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DropDown {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void dropdown(){
        driver.get("https://facebook.com");
        String [] Month={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Select month=new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Dec");
        List<WebElement> options=month.getOptions();
        boolean matching=false;
        for (WebElement choise:options){
            for (int i=0;i<Month.length;i++){
                if (choise.getText().equals(Month[i]))
                matching=true;
            }
        }
        Assert.assertTrue(matching);


        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByValue("15");

        Select year=new Select(driver.findElement(By.id("year")));
        year.selectByIndex(31);

    }
    @Test
    public void dropDown2(){
        driver.get("https://ebay.com");

        Select selectBar=new Select(driver.findElement(By.id("gh-cat")));
        selectBar.selectByVisibleText("eBay Motors");
        selectBar=new Select(driver.findElement(By.xpath("//select//option[.='eBay Motors']")));


    }
    @Test
    public void dropDown3(){
        driver.get("https://guru.com");
try {
    WebElement Morebutton = driver.findElement(By.xpath("//div[@class='c-header__dropdown__menu']//following::span[@class='c-header__link c-header__dropdown__trigger']"));
    Morebutton.click();


   // Morebutton.selectByIndex(1);
}catch (Exception e){
    System.out.println("Got an Exception");
}


    }

    @Test
    public void avito(){
        driver.get("https://avito.ma");

       Select firstDropDown=new Select(driver.findElement(By.xpath("//select[@id='catgroup']")));
        firstDropDown.selectByIndex(2);

      try {
          Assert.assertEquals(firstDropDown.getFirstSelectedOption(), "selected");
          //Assert.assertEquals(firstDropDown,"selected");
      }catch (Exception e){
          System.out.println("Got an Exception");
      }
        }


        @Test
    public void cityOfChicago(){
        driver.get("https://cars.com");
        String option="New Cars";
        WebElement carDropDown=driver.findElement(By.name("stockType"));
        Select dropDD=new Select(carDropDown);

        dropDD.selectByVisibleText(option);
           dropDD.getAllSelectedOptions();
           List<WebElement> allSelectOptions = dropDD.getAllSelectedOptions();
           for (WebElement selectedOptions : allSelectOptions) {
               Assert.assertEquals(selectedOptions.getText(), option);
           }

        }

        @Test
    public void selectClass2(){
        driver.get("https://www.cars.com");
        WebElement carsDD=driver.findElement(By.name("priceMax"));
        Select option=new Select(carsDD);
        option.selectByIndex(10);
        List<WebElement>selectedOption=option.getAllSelectedOptions();
        for (WebElement selected:selectedOption){

            Assert.assertEquals(selected.getText(),"$40,000");
        }

        }


        @Test
    public void selectOption3(){

        driver.get("https://www.cars.com");
            System.out.println(driver.getTitle());
        WebElement option=driver.findElement(By.name("makeId"));
        Select selected=new Select(option);
        selected.selectByValue("20005");

        }


        @Test
    public void AllTest() throws InterruptedException {
        driver.get("https://www.cars.com");
        String mainPage=driver.getTitle();
        Select newUsed=new Select(driver.findElement(By.name("stockType")));
        newUsed.selectByIndex(2);

        Select price=new Select(driver.findElement(By.name("priceMax")));
        price.selectByValue("125000");

        Select make=new Select(driver.findElement(By.name("makeId")));
        make.selectByVisibleText("Lexus");

        Select radiusMiles=new Select(driver.findElement(By.name("radius")));
        radiusMiles.selectByIndex(7);

        Select models=new Select(driver.findElement(By.name("modelId")));
        models.selectByVisibleText("- LX 570");

        WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
        search.click();

        Thread.sleep(3000);
        String name=driver.getTitle();
        Assert.assertNotEquals(mainPage,name);


        }

        @Test
        public void desselect(){
         driver.get("https://www.cars.com");
        String mainPage=driver.getTitle();
        Select newUsed=new Select(driver.findElement(By.name("stockType")));
     try {
         newUsed.selectByIndex(2);

         Thread.sleep(3000);
         newUsed.deselectByValue("Used Cars");
     }catch (Exception e ){
         System.out.println("Caught exception");
     }

        }

        @Test
    public void desselect2(){
        driver.manage().window().maximize();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement option=driver.findElement(By.id("multiple-select-example"));
        Select apple=new Select(option);
        apple.selectByIndex(0);

        if (apple.isMultiple()){
            apple.selectByIndex(0);
            apple.selectByIndex(1);
        }else{
            apple.selectByIndex(2);
        }
        List<WebElement>selectOption=apple.getAllSelectedOptions();
        Assert.assertTrue(selectOption.size()>0);

        if (apple.isMultiple()){
            apple.deselectAll();
        }
        selectOption=apple.getAllSelectedOptions();
        Assert.assertEquals(selectOption.size(),0);
        }
    }

