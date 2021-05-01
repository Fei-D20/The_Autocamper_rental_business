package com.Domin.Payment;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-08.02
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */

/**
 * this is the interface can be implemented by payment class and its subclass
 * to reach method create invoice etc.
 */
public interface Invoice {
    public void createInvoice();
    public void sendInvoice();
}
