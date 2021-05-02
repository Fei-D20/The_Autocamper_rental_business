package com.Domin.User;

import com.Domin.Payment.Invoice;
import com.Domin.Payment.Payment;
import com.Domin.Product.Reservation;
import com.Domin.RalativeOutSide.IF_DriveLicenseStatus;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Client extends User implements IF_Client, IF_DriveLicenseStatus {
    private int clientID;
    private int password;
    private String Name;
    private String address;
    private String email;

    public Client() {
    }

    public Client(int clientID, int password, String name, String address, String email) {
        this.clientID = clientID;
        this.password = password;
        Name = name;
        this.address = address;
        this.email = email;
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientID == client.clientID && password == client.password && Objects.equals(Name, client.Name) && Objects.equals(address, client.address) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, password, Name, address, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", password=" + password +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }

}
