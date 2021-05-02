package com.Domin.Product.Camper;

import java.util.Date;
import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Camper {
    private int camperID;
    private int categoryID;
    private String camperType;
    private Date registerYear;
    private boolean fullTankSituation;
    private double tankAmount;
    private double fullTankAmount;

    private Mile mile;

    public Camper() {
    }

    public Camper(int camperID, int categoryID, String camperType, Date registerYear, boolean fullTankSituation, double tankAmount, double fullTankAmount, Mile mile) {
        this.camperID = camperID;
        this.categoryID = categoryID;
        this.camperType = camperType;
        this.registerYear = registerYear;
        this.fullTankSituation = fullTankSituation;
        this.tankAmount = tankAmount;
        this.fullTankAmount = fullTankAmount;
        this.mile = new Mile();
    }

    public int getCamperID() {
        return camperID;
    }

    public void setCamperID(int camperID) {
        this.camperID = camperID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCamperType() {
        return camperType;
    }

    public void setCamperType(String camperType) {
        this.camperType = camperType;
    }

    public Date getRegisterYear() {
        return registerYear;
    }

    public void setRegisterYear(Date registerYear) {
        this.registerYear = registerYear;
    }

    public boolean isFullTankSituation() {
        return fullTankSituation;
    }

    public void setFullTankSituation(boolean fullTankSituation) {
        this.fullTankSituation = fullTankSituation;
    }

    public double getTankAmount() {
        return tankAmount;
    }

    public void setTankAmount(double tankAmount) {
        this.tankAmount = tankAmount;
    }

    public double getFullTankAmount() {
        return fullTankAmount;
    }

    public void setFullTankAmount(double fullTankAmount) {
        this.fullTankAmount = fullTankAmount;
    }

    public Mile getMile() {
        return mile;
    }

    public void setMile(Mile mile) {
        this.mile = mile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camper camper = (Camper) o;
        return camperID == camper.camperID && categoryID == camper.categoryID && fullTankSituation == camper.fullTankSituation && Double.compare(camper.tankAmount, tankAmount) == 0 && Double.compare(camper.fullTankAmount, fullTankAmount) == 0 && Objects.equals(camperType, camper.camperType) && Objects.equals(registerYear, camper.registerYear) && Objects.equals(mile, camper.mile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(camperID, categoryID, camperType, registerYear, fullTankSituation, tankAmount, fullTankAmount, mile);
    }

    @Override
    public String toString() {
        return "Camper{" +
                "camperID=" + camperID +
                ", categoryID=" + categoryID +
                ", camperType='" + camperType + '\'' +
                ", registerYear=" + registerYear +
                ", fullTankSituation=" + fullTankSituation +
                ", tankAmount=" + tankAmount +
                ", fullTankAmount=" + fullTankAmount +
                ", mile=" + mile +
                '}';
    }
}
