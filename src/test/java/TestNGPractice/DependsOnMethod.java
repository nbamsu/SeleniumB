package TestNGPractice;

import org.testng.annotations.Test;

public class DependsOnMethod {
    @Test(dependsOnMethods = {"secondMethod"})
    public void  firstMethod(){
        System.out.println("This is first method");
    }

    @Test
    public void secondMethod(){
        System.out.println("This is second method");
    }
}
