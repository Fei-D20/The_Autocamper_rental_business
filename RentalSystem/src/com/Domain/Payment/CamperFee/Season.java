package com.Domain.Payment.CamperFee;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-22.37
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public enum Season {
    LowSeason(0.8), MainSeason(1.0);

    private double percentage;

    Season(double percentage) {
        this.percentage = percentage;
    }

    public static double getPercentage(Season season){
        return season.percentage;
    }
}
