package com.epam.m6w1;

import java.math.BigDecimal;

public class Calculator {
    private BigDecimal mem;

    public Calculator() {
        this.clearMemory();
    }

    public long sum(long a, long b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public long mult(long a, long b) {
        return a * b;
    }

    public double mult(double a, double b) {
        return Math.floor(a * b);
    }

    public long div(long a, long b) {
        if(b == 0L) {
            throw new NumberFormatException("Attempt to divide by zero");
        } else {
            return a / b;
        }
    }

    public void clearMemory() {
        mem = BigDecimal.ZERO;
    }

    public void addToMemory(BigDecimal num) {
        mem = mem.add(num);
    }

    public BigDecimal getMem() {
        return mem;
    }
}
