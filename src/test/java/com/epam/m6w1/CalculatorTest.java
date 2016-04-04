package com.epam.m6w1;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

/**
 * Created by Tamas_Suli on 3/31/2016.
 */
public class CalculatorTest {
    private Calculator calc;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        calc.clearMemory();
    }

    @Test (expectedExceptions = NumberFormatException.class )
    public void firstTest() {
        long result = calc.div(10,0);
    }

    @Test
    public void secTest() {
        long result = calc.div(10,2);
        Assert.assertEquals(result,5,"Div result:");
    }

    @Test(groups = {"memtest","a"})
    public void addToMemory() {
        Calculator calc2 = Mockito.spy(calc);
when(calc2.getMem()).thenReturn(BigDecimal.TEN);
        Assert.*(calc2.getMem(), BigDecimal.ONE);
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

    @Test
    public void bigDecimalTest() {
        BigDecimal bigDecimal = new BigDecimal("1.5001");
        MatcherAssert.assertThat("Bigdecimal closeTo",bigDecimal, Matchers.closeTo(new BigDecimal(1.5001f),new BigDecimal("0.0000000000000000000000000000001")));
    }

    @DataProvider(name = "feeder")
    public Object[][] sumfeeder() {
        return new Object[][] {{1,2,3},{10,10,7},{2,3,5}};
    }

    @Test(dataProvider = "feeder")
    public void sumTest(long a, long b, long expected) {
        Timeout timeout = new Timeout();
        timeout.sleep(1);
        MatcherAssert.assertThat(calc.sum(a,b), Matchers.equalTo(expected));
    }


}
