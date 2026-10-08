package com.skyline;

public class BookingValidator {

    /**
     * Validates an email address.
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    /**
     * Validates passenger count: 1 to 9 allowed.
     */
    public boolean isValidPassengerCount(int count) {
        return count >= 1 && count <= 9;
    }

    /**
     * Validates a flight number: format "SR-1234" (letters, dash, digits).
     */
    public boolean isValidFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            return false;
        }
        return flightNumber.matches("^[A-Z]{2}-\\d{3,4}$");
    }
}
