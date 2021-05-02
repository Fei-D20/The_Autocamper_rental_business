package com.Domin.Payment.CamperFee;

import com.Domin.Product.Camper.Camper;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-22.32
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class CamperFee implements IF_CamperFee {

    @Override
    public double calculateCamperFee(int weekAmount, double milefee, double fuelMissing, PriceCategories priceCategories, Season season) {
        double feeAmount = PriceCategories.getPrice(priceCategories) * Season.getPercentage(season) * weekAmount + milefee + fuelMissing;
        return feeAmount;
    }


}
