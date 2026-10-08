package com.skyline;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingValidatorTest {

    private BookingValidator validator;

    @Before
    public void setUp() {
        validator = new BookingValidator();
    }

    @Test
    public void testValidEmail() {
        assertTrue(validator.isValidEmail("user@example.com"));
    }

    @Test
    public void testInvalidEmailNoAt() {
        assertFalse(validator.isValidEmail("userexample.com"));
    }

    @Test
    public void testInvalidEmailEmpty() {
        assertFalse(validator.isValidEmail(""));
    }

    @Test
    public void testInvalidEmailNull() {
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    public void testValidPassengerCount() {
        assertTrue(validator.isValidPassengerCount(5));
    }

    @Test
    public void testPassengerCountTooLow() {
        assertFalse(validator.isValidPassengerCount(0));
    }

    @Test
    public void testPassengerCountTooHigh() {
        assertFalse(validator.isValidPassengerCount(10));
    }

    @Test
    public void testValidFlightNumber() {
        assertTrue(validator.isValidFlightNumber("SR-1234"));
    }

    @Test
    public void testInvalidFlightNumber() {
        assertFalse(validator.isValidFlightNumber("1234"));
    }

    @Test
    public void testInvalidFlightNumberNull() {
        assertFalse(validator.isValidFlightNumber(null));
    }
}
