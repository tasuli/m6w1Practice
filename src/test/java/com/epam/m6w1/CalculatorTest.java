package com.epam.m6w1;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

/**
 * Created by Tamas_Suli on 3/31/2016.
 */
public class CalculatorTest {
    private Calculator calc;
    private Timeout timeout;

    @BeforeClass (alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
        calc.clearMemory();
    }

    @AfterMethod
    public void afterMethod() {
        calc.clearMemory();
        timeout.sleep(1);
    }

    @Test
    public void verifyMemoryClearing() {
        calc.clearMemory();
        Assert.assertEquals(calc.getMem(),BigDecimal.ZERO);
    }

    @Test( groups = "memtest")
    public void verifyAddMemoryFunctionWithMock() {
        Calculator mockedCalculator = Mockito.spy(calc);
        when(mockedCalculator.getMem()).thenReturn(BigDecimal.ONE);
        calc.addToMemory(new BigDecimal("1"));
        Assert.assertEquals(calc.getMem(), BigDecimal.ONE, "Memory of the calcualtor" );
    }

       @Test( groups = "memtest")
    public void verifyAddMemoryFunction() {
        calc.addToMemory(new BigDecimal("1"));
        System.out.print(calc.getMem());
        Assert.assertEquals(calc.getMem(), BigDecimal.ONE, "Memory of the calcualtor" );
    }

    @Test( dependsOnMethods = "verifyMemoryClearing")
    public void verifyAddMemoryFunction2() {
         calc.addToMemory(new BigDecimal("1"));
         calc.addToMemory(new BigDecimal("10"));
         Assert.assertEquals(calc.getMem(), new BigDecimal("11"), "Memory of the calcualtor" );
     }

    @Test (expectedExceptions = NumberFormatException.class)
    public void verifyDiv() {
        calc.div(1,0);
    }

    @Test
    public void testSum1() {
        Assert.assertEquals(calc.sum(1,2), 3);
    }

    @Test
    public void testSum2() {
        Assert.assertEquals(calc.sum(4,2),6);
    }

    @DataProvider (name = "sumFeeder")
    public Object [][] fedder() {
        return new Object [][] {{1,2,3}, {4,2,6}, {4,3,7}};
    }

    @Test(dataProvider = "sumFeeder")
    public void testSumWithDataProvider (long a, long b, long expectedValue) {
        Assert.assertEquals(calc.sum(a,b), expectedValue);
    }
}
