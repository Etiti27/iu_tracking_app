package com.example.trackingapp;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class KmUnitTest {
    @Test
    public void CalculateKm_correct(){
        CalculateKilometre calculate= new CalculateKilometre(6,6);
        double result=calculate.calculateTotalKilometre();
        assertEquals(9.0, result);

    }

}
