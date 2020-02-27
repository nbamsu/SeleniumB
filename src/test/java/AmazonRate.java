import Pages.AmazonPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonRate extends TestBase{



    @Test
    public void Rate(){


        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone"+ Keys.ENTER);
        AmazonPage amazonPage=new AmazonPage();
        List<WebElement> fiveStar=amazonPage.fiveStar;//driver.findElements(By.xpath("//span[@class='a-size-base']"));

//        List<WebElement> fourStar=driver.findElements(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom']"));
//        List<WebElement> ThreeStar=driver.findElements(By.xpath("//i{@class='a-icon a-icon-star-small a-star-small-3-5 aok-align-bottom']"));
//        List<WebElement> AlmostThreeStar=driver.findElements(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-2-5 aok-align-bottom']"));
        int f=0;
        for (int i=0;i<fiveStar.size();i++) {
            try {
                String five = fiveStar.get(i).getText().replace(",","");
                f = Integer.parseInt(five);
                if (f <= 5) ;
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
        System.out.println(f);
        //driver.close();
    }



    @Test
    public void Rate2(){


        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone"+ Keys.ENTER);

        List<WebElement> voteList=driver.findElements(By.xpath("//span[@class='a-size-base']"));
        List<WebElement> names=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
       // List<WebElement> names=driver.findElements(By.xpath("//h2"));
        System.out.println(voteList.size()+" "+names.size());
        int highest=Integer.parseInt(voteList.get(0).getText());;
        int lowest=Integer.parseInt(voteList.get(0).getText());
        for (int i=0;i<voteList.size();i++){
           try{
               String vote=voteList.get(i).getText().replace(",","");
               int temp=Integer.parseInt(vote);
               if (highest<temp){
                   highest=temp;
               }
               if (lowest>temp){
                   lowest=temp;
               }
           }catch (Exception e){
               System.out.println("caught");
           }

        }
        System.out.println("Highest vote " +highest+"\nLowest vote "+ lowest);
    }



    @Test
    public void NewLocators(){
        driver.get("http://the-internet.herokuapp.com/");

        WebElement button=driver.findElement(By.xpath("//button[@onclick='addElement()']//preceding::h3"));
                                                        ////button[@onclick='addElement()']//ancestor::div/h3
                                                        ////h3//following::button
                                                        ////h3//following-sibling::div/button
                                                        //button/..  ///only one step up( you can go as far as you want
    }


    @Test
    public void iphone(){
     driver.get("https://www.amazon.com");

     WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone"+ Keys.ENTER);


       WebElement box=driver.findElement(By.xpath("//span[.='Apple']//preceding-sibling::div//i"));
       box.click();
       box=driver.findElement(By.xpath("//span[.='Apple']//preceding-sibling::div//input"));
        Assert.assertTrue(box.isSelected());


         WebElement iOs=driver.findElement(By.xpath("//li[@id='p_n_feature_twenty_browse-bin/17881878011']//i"));
           iOs.click();
          iOs=driver.findElement(By.xpath("//li[@id='p_n_feature_twenty_browse-bin/17881878011']//input"));
         Assert.assertEquals(iOs.getAttribute("checked"),"true");
        //System.out.println(iOs.getAttribute("checked"));

        WebElement gb128=driver.findElement(By.xpath("//li[@id='p_n_feature_twelve_browse-bin/14674911011']//following-sibling::i"));
        gb128.click();
        gb128=driver.findElement(By.xpath("//li[@id='p_n_feature_twelve_browse-bin/14674911011']//child::input"));
        Assert.assertEquals(gb128.getAttribute("checked"),"true");


        // 1 Verify apple checkbox is checked by Attribute
        // 2 iOS box
        // 3 128 GB box

    }
}
