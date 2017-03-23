package com.app.koreq.commlistview.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * project : CommListView
 * author : YanBin on 3/22/17
 * version : v
 * description :
 */
public class CalculatorTest {
    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sum() throws Exception {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(1d, mCalculator.subtract(5d, 4d), 0);
    }

    @Test
    public void divide() throws Exception {
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }

}