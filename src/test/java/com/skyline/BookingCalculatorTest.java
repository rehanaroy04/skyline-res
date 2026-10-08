package com.skyline;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingCalculatorTest {

    private BookingCalculator calculator;

    @Before
    public void setUp() {
        calculator = new BookingCalculator();
    }

    @Test
    public void testCalculateBasePrice() {
        double base = calculator.calculateBasePrice(2, 500.0);
        assertEquals(1000.0, base, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateBasePriceZeroPassengers() {
        calculator.calculateBasePrice(0, 500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateBasePriceNegativePrice() {
        calculator.calculateBasePrice(2, -100.0);
    }

    @Test
    public void testCalculateTax() {
        double tax = calculator.calculateTax(1000.0);
        assertEquals(180.0, tax, 0.01);
    }

    @Test
    public void testNoDiscountFor1Passenger() {
        double discounted = calculator.applyDiscount(500.0, 1);
        assertEquals(500.0, discounted, 0.01);
    }

    @Test
    public void testDiscountFor3Passengers() {
        double discounted = calculator.applyDiscount(1000.0, 3);
        assertEquals(900.0, discounted, 0.01);
    }

    @Test
    public void testDiscountFor6Passengers() {
        double discounted = calculator.applyDiscount(1000.0, 6);
        assertEquals(800.0, discounted, 0.01);
    }

    @Test
    public void testCalculateTotal() {
        double total = calculator.calculateTotal(2, 500.0);
        assertEquals(1180.0, total, 0.01);
    }

    @Test
    public void testCalculateTotalWithDiscount() {
        double total = calculator.calculateTotal(4, 500.0);
        assertEquals(2124.0, total, 0.01);
    }
}