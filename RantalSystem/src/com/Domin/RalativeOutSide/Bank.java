package com.Domin.RalativeOutSide;

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
    private int bankID;
    private String bankName;

    public Bank() {
    }

    public Bank(int bankID, String bankName) {
        this.bankID = bankID;
        this.bankName = bankName;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return bankID == bank.bankID && Objects.equals(bankName, bank.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankID, bankName);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankID=" + bankID +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
