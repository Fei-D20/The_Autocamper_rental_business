package com.Domain.Product.Camper;

import java.util.Date;
import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-01-07.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Camper implements IF_Camper{
    private int camperID;
    private int categoryID;
    private String camperType;
    private Date registerYear;


    private Mile mile = null;
    private Tank tank = null;

    public Camper() {
    }

    public Camper(int camperID, int categoryID, String camperType, Date registerYear, Mile mile, Tank tank) {
        this.camperID = camperID;
        this.categoryID = categoryID;
        this.camperType = camperType;
        this.registerYear = registerYear;
        this.mile = mile;
        this.tank = tank;
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

    public Mile getMile() {
        return mile;
    }

    public void setMile(Mile mile) {
        this.mile = mile;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camper camper = (Camper) o;
        return camperID == camper.camperID && categoryID == camper.categoryID && Objects.equals(camperType, camper.camperType) && Objects.equals(registerYear, camper.registerYear) && Objects.equals(mile, camper.mile) && Objects.equals(tank, camper.tank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(camperID, categoryID, camperType, registerYear, mile, tank);
    }

    @Override
    public String toString() {
        return "Camper{" +
                "camperID=" + camperID +
                ", categoryID=" + categoryID +
                ", camperType='" + camperType + '\'' +
                ", registerYear=" + registerYear +
                ", mile=" + mile +
                ", tank=" + tank +
                '}';
    }
}
