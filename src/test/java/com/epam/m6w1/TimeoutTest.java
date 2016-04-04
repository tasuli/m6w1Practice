package com.epam.m6w1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by NC6400 on 2016.04.01..
 */
public class TimeoutTest {
    private Timeout timeout;

    @BeforeClass
    public void initClass() {
        timeout = new Timeout();
    }

    @Test (timeOut = 10000)
    public void shouldFail() {
        int i = 0;
        while (true) {
            timeout.sleep(1);
            System.out.println(i++);
        }
    }
}
