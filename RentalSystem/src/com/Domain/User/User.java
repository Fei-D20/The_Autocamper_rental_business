package com.Domain.User;

import com.Domain.Payment.Invoice;
import com.Domain.Payment.Payment;
import com.Domain.Product.Reservation;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-14.10
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class User implements IF_User {
    @Override
    public boolean login() {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public User register() {
        return null;
    }

    @Override
    public User modifyInfo() {
        return null;
    }

    @Override
    public Reservation reserve() {
        return null;
    }

    @Override
    public boolean cancelReservation() {
        return false;
    }

    @Override
    public Payment getPayment() {
        return null;
    }

    @Override
    public Invoice getInvoice() {
        return null;
    }

    @Override
    public Reservation extendReservation() {
        return null;
    }
}
