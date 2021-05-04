package com.Domain.User;


import com.Domain.Payment.Invoice;
import com.Domain.Payment.Payment;
import com.Domain.Product.Reservation;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-11.03
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface IF_User {
    public boolean login();
    public boolean logout();
    public User register();
    public User modifyInfo();
    public Reservation reserve();
    public boolean cancelReservation();
    public Payment getPayment();
    public Invoice getInvoice();
    public Reservation extendReservation();

}
