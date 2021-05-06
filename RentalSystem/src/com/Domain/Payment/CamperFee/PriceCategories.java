package com.Domain.Payment.CamperFee;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-22.31
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public enum PriceCategories {
    Luxury(2999), Standard(1999), Basic(999);

    private double price;

    PriceCategories(double price) {
        this.price = price;
    }

    public static double getPrice(PriceCategories priceCategories) {
        return priceCategories.price;
    }
}
