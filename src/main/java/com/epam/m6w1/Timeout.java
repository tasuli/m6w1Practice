package com.epam.m6w1;


public class Timeout {
        public Timeout() {
        }

        public static void sleep(int sec) {
            try {
                Thread.sleep((long)(sec * 1000));
            } catch (InterruptedException e) {
                System.err.println(e);
            }

        }
}
