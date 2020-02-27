import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonIntro {
    @Test
    public void RadioButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");


//        WebElement maleButton=driver.findElement(By.xpath("//button[@id='buttoncheck']//..//preceding::input[last()]"));
//        maleButton.click();
//        Assert.assertTrue(maleButton.isSelected());
//        WebElement femaleButton=driver.findElement(By.xpath("//button[@id='buttoncheck']//..//preceding::input[last()-1]"));
//        Assert.assertFalse(femaleButton.isSelected());
//        femaleButton.click();
//        Assert.assertTrue(femaleButton.isSelected());
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> list = driver.findElements(By.xpath("//p[.='Click on button to get the selected value']/following-sibling::label/input"));
        int elementIndex = 1;
        list.get(elementIndex).click();
        checkradioButton(elementIndex,list);
        elementIndex=0;
        list.get(elementIndex).click();
        checkradioButton(elementIndex, list);



        }



private static void checkradioButton(int elementIndex, List<WebElement> radioBattuon){
        for (int i=0;i<radioBattuon.size();i++){
            if (i==elementIndex){
                Assert.assertTrue(radioBattuon.get(i).isSelected());
            }else{
                Assert.assertFalse(radioBattuon.get(i).isSelected());
            }
        }
}

    }

