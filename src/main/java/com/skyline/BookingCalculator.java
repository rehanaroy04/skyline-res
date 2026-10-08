package com.skyline;

public class BookingCalculator {

    private static final double TAX_RATE = 0.18; // 18%% GST

    /**
     * Calculates base price = passengers * pricePerTicket
     */
    public double calculateBasePrice(int passengers, double pricePerTicket) {
        if (passengers <= 0) {
            throw new IllegalArgumentException("Passengers must be positive");
        }
        if (pricePerTicket <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        return passengers * pricePerTicket;
    }

    /**
     * Calculates tax on base price.
     */
    public double calculateTax(double basePrice) {
        return basePrice * TAX_RATE;
    }

    /**
     * Applies discount based on passengers:
     *   1-2 passengers: no discount
     *   3-5 passengers: 10%% off
     *   6+ passengers: 20%% off
     */
    public double applyDiscount(double basePrice, int passengers) {
        double discountRate = 0.0;
        if (passengers >= 6) {
            discountRate = 0.20;
        } else if (passengers >= 3) {
            discountRate = 0.10;
        }
        return basePrice * (1 - discountRate);
    }

    /**
     * Calculates final total = (base - discount) + tax
     */
    public double calculateTotal(int passengers, double pricePerTicket) {
        double base = calculateBasePrice(passengers, pricePerTicket);
        double discounted = applyDiscount(base, passengers);
        double tax = calculateTax(discounted);
        return discounted + tax;
    }
}
