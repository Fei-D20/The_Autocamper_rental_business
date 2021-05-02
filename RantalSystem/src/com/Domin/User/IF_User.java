package com.Domin.User;


import com.Domin.Payment.Invoice;
import com.Domin.Payment.Payment;
import com.Domin.Product.Reservation;

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
