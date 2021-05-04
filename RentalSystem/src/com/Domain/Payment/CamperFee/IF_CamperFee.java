package com.Domain.Payment.CamperFee;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-11.33
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface IF_CamperFee {
    public double calculateCamperFee(int weekAmount, double milefee, double fuelMissing, PriceCategories priceCategories, Season season);

}
