package com.Domain.User;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Client extends User implements IF_Client{
    private int clientID;
    private int password;
    private String name;
    private String address;
    private String email;
    private int phoneNo;
    private int driveLicenseNo;
    private boolean driverFullDrivingLicenseStatue;
    private boolean coDriverExist;
    private String coDriverName;
    private int coDriverLicenseNo;
    private int bankID;
    private int accountNo;


    public Client() {
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getDriveLicenseNo() {
        return driveLicenseNo;
    }

    public void setDriveLicenseNo(int driveLicenseNo) {
        this.driveLicenseNo = driveLicenseNo;
    }

    public boolean isDriverFullDrivingLicenseStatue() {
        return driverFullDrivingLicenseStatue;
    }

    public void setDriverFullDrivingLicenseStatue(boolean driverFullDrivingLicenseStatue) {
        this.driverFullDrivingLicenseStatue = driverFullDrivingLicenseStatue;
    }

    public boolean isCoDriverExist() {
        return coDriverExist;
    }

    public void setCoDriverExist(boolean coDriverExist) {
        this.coDriverExist = coDriverExist;
    }

    public String getCoDriverName() {
        return coDriverName;
    }

    public void setCoDriverName(String coDriverName) {
        this.coDriverName = coDriverName;
    }

    public int getCoDriverLicenseNo() {
        return coDriverLicenseNo;
    }

    public void setCoDriverLicenseNo(int coDriverLicenseNo) {
        this.coDriverLicenseNo = coDriverLicenseNo;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientID == client.clientID && password == client.password && phoneNo == client.phoneNo
                && driveLicenseNo == client.driveLicenseNo
                && driverFullDrivingLicenseStatue == client.driverFullDrivingLicenseStatue
                && coDriverExist == client.coDriverExist && coDriverLicenseNo == client.coDriverLicenseNo
                && bankID == client.bankID && accountNo == client.accountNo
                && Objects.equals(name, client.name) && Objects.equals(address, client.address)
                && Objects.equals(email, client.email) && Objects.equals(coDriverName, client.coDriverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, password, name, address, email, phoneNo,
                driveLicenseNo, driverFullDrivingLicenseStatue, coDriverExist,
                coDriverName, coDriverLicenseNo, bankID, accountNo);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", driveLicenseNo=" + driveLicenseNo +
                ", driverFullDrivingLicenseStatue=" + driverFullDrivingLicenseStatue +
                ", coDriverExist=" + coDriverExist +
                ", coDriverName='" + coDriverName + '\'' +
                ", coDriverLicenseNo=" + coDriverLicenseNo +
                ", bankID=" + bankID +
                ", accountNo=" + accountNo +
                "} " + super.toString();
    }
}
