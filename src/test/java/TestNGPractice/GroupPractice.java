package TestNGPractice;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

public class GroupPractice {
    @Test(groups = {"cars"})
    public void printCars(){
        System.out.println("LEXUS LX 570");
        System.out.println("Porsche - Cayman 718");
        System.out.println("BMW -320");
        System.out.println("Toyota Camry");

    }
    @Test(groups = {"language"})
    public void printLanguages(){
        System.out.println("English");
        System.out.println("Russia");
        System.out.println("Italian");
        System.out.println("Arabic");
        System.out.println("Dutch");
    }
    @Test(groups = {"codelanguages"})
    public void printCodeLanguages(){
        System.out.println("Java");
        System.out.println("Phyton");
        System.out.println("C#");
        System.out.println("C++");
    }
    @Test(groups = {"tools"})
    public void testingTools(){
        System.out.println("Selenium");
        System.out.println("testNG");
        System.out.println("Postman");
        System.out.println("Maven");
        System.out.println("SQL");
    }


}
