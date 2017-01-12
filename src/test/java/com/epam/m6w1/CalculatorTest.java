package com.epam.m6w1;

import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;

/**
 * Created by Tamas_Suli on 3/31/2016.
 */
public class CalculatorTest {
    Calculator calc;

    @BeforeClass
    public void beforeClass() {
        calc = new Calculator();
        calc.clearMemory();
    }

    @AfterMethod
    public void afterMethod() {
        calc.clearMemory();
    }

    @Test
    public void firstTest() {
        System.out.println("First 'test'");
    }

    @Test
    public void verifyAddMemoryFunction() {

        calc.addToMemory(new BigDecimal("1"));
        System.out.print(calc.getMem());
        Assert.assertEquals(calc.getMem(), BigDecimal.ONE, "Memory of the calcualtor" );
    }

     @Test
    public void verifyAddMemoryFunction2() {
         calc.addToMemory(new BigDecimal("1"));
         calc.addToMemory(new BigDecimal("10"));
         System.out.print(calc.getMem());
         Assert.assertEquals(calc.getMem(), new BigDecimal("11"), "Memory of the calcualtor" );
     }

    @Test (expectedExceptions = NumberFormatException.class)
    public void verifyDiv() {
        calc.div(1,0);
    }

    @Test
    public void test1() {
        Assert.assertEquals(calc.sum(1,2), 3);
    }

    @Test
    public void test2() {
        Assert.assertEquals(calc.sum(4,2),6);
    }

    @DataProvider (name = "sumFeeder")
    public Object [][] fedder() {
        return new Object [][] {{1,2,3}, {4,2,6}, {4,2,7}};
    }

    @Test(dataProvider = "sumFeeder")
    public void testSumWithDataProvider (long a, long b, long expectedValue) {
        Assert.assertEquals(calc.sum(a,b), expectedValue);
    }
}
