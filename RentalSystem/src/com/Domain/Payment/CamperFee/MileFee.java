package com.Domain.Payment.CamperFee;

import com.Domain.Product.Camper.Mile;

/**
 * @ author Fei Gu
 * @ create 2021-05-07-00.24
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class MileFee implements IF_MileFee{
    @Override
    public double calculateCamperFee(int weekAmount, double milefee, double fuelMissing, PriceCategories priceCategories, Season season) {
        return 0;
    }

    @Override
    public Mile checkMile() {
        return null;
    }
}
