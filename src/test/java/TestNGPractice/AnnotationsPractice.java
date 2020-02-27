package TestNGPractice;

import org.testng.annotations.*;

public class AnnotationsPractice {
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before class Annotation");
    }

   @BeforeMethod
   public void beforMethod(){
       System.out.println("Before test Annotation");
   }

    @Test
    public void Test2(){
        System.out.println("This is prom test 2");
    }
     @Test
    public void Test1(){
        System.out.println("This is prom test 1");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("After method Annotation");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("After class Annotation");
    }


}
