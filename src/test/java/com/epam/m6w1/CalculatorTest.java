package com.epam.m6w1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * Created by Tamas_Suli on 3/31/2016.
 */
public class CalculatorTest {
    private Calculator calc;

    @BeforeClass
    public void beforeClass() {
        calc = new Calculator();
    }

    @AfterMethod
    public void afterMethod() {
        calc.clearMemory();
    }

    @Test (expectedExceptions = NumberFormatException.class )
    public void firstTest() {
        long result = calc.div(10,0);
        Assert.assertEquals(result,3);
    }

    @Test
    public void secTest() {
        long result = calc.div(10,2);
        Assert.assertEquals(result,5);
    }

    @Test(groups = "memtest")
    public void addToMemory() {
        calc.addToMemory(BigDecimal.ONE);
        Assert.assertEquals(calc.getMem(),BigDecimal.ONE);
    }

    @Test( groups = "memtest")
    public void addToMemory2() {
        calc.addToMemory(BigDecimal.ONE);
        Assert.assertEquals(calc.getMem(),BigDecimal.ONE);
    }

    @Test(dependsOnGroups = "memtest")
    public void addToMemory3() {
        calc.addToMemory(BigDecimal.ONE);
        Assert.assertEquals(calc.getMem(),BigDecimal.ONE);
    }




}
