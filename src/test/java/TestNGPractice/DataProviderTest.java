package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
   @DataProvider(name="states")
   public Object[][] getData(){
       return new Object[][]{
               {"IL","Chicago","60657"},
               {"AZ","Phoenix","66667"},
               {"NJ","CherryHills","09878"},
               {"NY","Gotham","0001"}
       };
   }
    @Test(dataProvider = "states")
    public void printStates(String states,String city,String zipCode){
        System.out.println("State is: "+ states + "City name is : "+ city + "ZipCode is : "+ zipCode);
    }
    @DataProvider(name="student")
    public Object [][] getData2(){
       return new Object [][]{
               {"Baha","Nur","02.02.2020"},
               {"Ari","Stamov","01.01.2011"},
               {"Diman","Ke","03.03.2023"}

       };

    }
    @Test(dataProvider = "student")
    public void printInfo(String name,String lastName,String DOB){
        System.out.println("first name is: "+name+" Last name is: "+lastName+ " date of birth is: "+DOB);
    }

}
