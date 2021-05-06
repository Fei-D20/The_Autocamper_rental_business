package com.Domain.RelativeOutSide;

import java.util.Date;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-10.47
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface IF_PostSystem {

    /**
     * this is the send out date for the info.
     *
     * @return the send out date
     */
    public Date getDeliveryDate();

    /**
     * if there have some transfer fee like postage then here return the amount. if it is email then return 0.0 .
     *
     * @return amount
     */
    public double getCost();

    /**
     * if this is the mail then get the real located , otherwise it should be email address.
     *
     * @return address.
     */
    public String getAddress();

    /**
     * the post type normally have mail/email two different type
     * and maybe late we can add method about pop-window for confirm then the post type is pop-window
     *
     * @return mail or email.
     */
    public String getPostType();
}
