package com.TestPackage;

import com.Domain.Payment.CamperFee.PriceCategories;
import com.Domain.Payment.CamperFee.Season;
import org.junit.Test;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-23.38
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class EnumTest {
    @Test
    public void testEnumClassGetValue(){
        System.out.println("LowSeason : " + Season.getPercentage(Season.LowSeason));
        System.out.println("MainSeason : " + Season.getPercentage(Season.MainSeason));

        System.out.println("basic : " + PriceCategories.getPrice(PriceCategories.Basic));
    }
}
