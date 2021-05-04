package com.Domain.Payment.CamperFee;

import java.util.Date;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-22.47
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface IF_Week {
    public int getWeekAmount(Date startDate, Date endDate);
    public Date transToStartSaturday(Date startDate);
    public Date transToEndSaturday(Date endDate);
}