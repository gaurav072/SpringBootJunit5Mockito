package mypack;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
	
 @BeforeClass		
    public static void m1() {							
        System.out.println("Using @BeforeClass , executed before all test cases ");					
    }	
	 
   @Test(expected=NullPointerException.class)
   public void testSum() {
	   Calc c = new Calc();
	   
	   //Positive Scenario
	   assertEquals(30, c.sum(10, 20));
	   
	   //Negative Scenario
	  // assertEquals(20, c.sum(null, 20));
   }
   
   @After		
   public void m4() {							
       System.out.println("Using @After ,executed after each test cases");					
   }	
}
