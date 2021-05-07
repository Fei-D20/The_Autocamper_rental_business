package com.Domain.User;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Admin extends User implements IF_Administrator {
    private int adminID;
    private int adminPassword;

    public Admin() {
    }

    public Admin(int adminID, int adminPassword) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(int adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminID == admin.adminID && adminPassword == admin.adminPassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, adminPassword);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminPassword=" + adminPassword +
                "} " + super.toString();
    }
}
