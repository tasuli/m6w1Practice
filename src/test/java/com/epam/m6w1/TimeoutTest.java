package com.epam.m6w1;

import org.testng.annotations.Test;

/**
 * Created by Tamas_Suli on 1/13/2017.
 */
public class TimeoutTest {

    private Timeout timeout = new Timeout();

    @Test (timeOut = 10000)
    public void testTimeout() {
        timeout.sleep(9);
    }

}
