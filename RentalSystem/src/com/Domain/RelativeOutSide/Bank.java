package com.Domain.RelativeOutSide;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.58
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */

import java.util.Objects;

/**
 * this is the information about the bank which the client choose to trans the payment.
 */
public class Bank {
    private int fld_BankID;
    private String fld_BankName;

    public Bank() {
    }

    public Bank(int bankID, String fld_BankName) {
        this.fld_BankID = bankID;
        this.fld_BankName = fld_BankName;
    }

    public int getFld_BankID() {
        return fld_BankID;
    }

    public void setFld_BankID(int fld_BankID) {
        this.fld_BankID = fld_BankID;
    }

    public String getFld_BankName() {
        return fld_BankName;
    }

    public void setFld_BankName(String fld_BankName) {
        this.fld_BankName = fld_BankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return fld_BankID == bank.fld_BankID && Objects.equals(fld_BankName, bank.fld_BankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fld_BankID, fld_BankName);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankID=" + fld_BankID +
                ", bankName='" + fld_BankName + '\'' +
                '}';
    }
}
