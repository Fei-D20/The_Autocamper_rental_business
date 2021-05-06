package com.Domain.Payment.CamperFee;

import java.util.Date;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-22.36
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Week implements IF_Week {
    Date startDate;
    Date endDate;
    int weekAmount;


    @Override
    public int getWeekAmount(Date startDate, Date endDate) {
        Date startWeekSaturday = transToStartSaturday(startDate);
        Date endWeekSaturday = transToEndSaturday(endDate);
        /*
         * right here should use the function following to get the week amount
        int weekAmount = (endWeekSaturday - startWeekSaturday)/7;
         */
        return weekAmount;
    }

    @Override
    public Date transToStartSaturday(Date startDate) {
        /*
         * right here the start date should trans to the earlier saturday as the start week date
         */
        Date startWeekSaturday = null;
        return startWeekSaturday;
    }

    @Override
    public Date transToEndSaturday(Date endDate) {
        /*
         * right here the end date should trans to the later saturday as the end week date
         */
        Date endWeekSaturday = null;
        return endWeekSaturday;
    }


}
