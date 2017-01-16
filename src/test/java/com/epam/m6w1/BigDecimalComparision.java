package com.epam.m6w1;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.testng.Assert.fail;

/**
 * Created by Tamas_Suli on 1/13/2017.
 */
public class BigDecimalComparision {

    @Test
    public void bigDecimalNotEquals() {
        Assert.assertNotEquals(new BigDecimal("1.0000"),new BigDecimal(1.0000));
    }

    @Test
    public void bigDecimalEqaulsShouldFails() {
        MatcherAssert.assertThat("1.000005d != 1.000005f", new BigDecimal(1.000005d), Matchers.equalTo(new BigDecimal(1.000005f)));
    }

    @Test
    public void bigDescimalcloseTo() {
        assertThat("1 closeTo 1.000005, because the verified precision: 0.0001", BigDecimal.ONE, closeTo( new BigDecimal(1.000005f), new BigDecimal(0.0001)));
    }

    @Test(enabled = false)
    public void disabledTest() {
        fail("Test fail!");
    }
}
