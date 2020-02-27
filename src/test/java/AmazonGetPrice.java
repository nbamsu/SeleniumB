import Pages.AmazonPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.List;

public class AmazonGetPrice extends TestBase{


     /*   1. Navigate to amazon.com
        2. Search for iphone
        3. Get all prices for iphone results
        4. Sum them up
        5. Get total price*/

    @Test
    public void priceOfIphones(){


        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone"+ Keys.ENTER);

        List<WebElement> text=driver.findElements(By.xpath("//h2"));
        List<WebElement> prices=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        List<WebElement> fractionPrices=driver.findElements(By.xpath("//span[@class='a-price-fraction']"));

        double sum=0;
        for(int i=0;i<prices.size();i++){
            if(text.get(i).getText().toLowerCase().contains("case") || text.get(i).getText().toLowerCase().contains("earbuds")){
                sum+=0;
            }
            else {
                System.out.println(text.get(i).getText());
                String str=prices.get(i).getText();
                String str1=fractionPrices.get(i).getText();
                System.out.println(str+"  "+str1);
                str=str.replace(",","");
                try{double decimal=Double.valueOf(str);
                    double fraction = Double.valueOf(str1) / 100;
                    sum+=decimal;
                    sum+=fraction;
                }
                catch (NumberFormatException e){
                }
            }
        }System.out.println(sum);
    }


    @Test
    public void AmazonIphone(){

        driver.get("https://amazon.com");
        WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("iphone"+Keys.ENTER);

        AmazonPage amazonPage=new AmazonPage();
        List<WebElement> allPrice=amazonPage.allPrice; // driver.findElements(By.xpath("//span[@class='a-price']"));
        double totalPrice=0;
        for (int i=0;i<allPrice.size();i++){
        try {
            String doublePrice = allPrice.get(i).getText().substring(1).replace("\n", ".");
            totalPrice += Double.parseDouble(doublePrice);
        }catch (NumberFormatException e){
            System.out.println("Number format exception caught");
        }catch (StringIndexOutOfBoundsException e1){
            System.out.println("second exception");
        }
        }
        System.out.println("Total price for iphone: $"+totalPrice);


    }
}












