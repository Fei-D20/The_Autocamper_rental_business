package com.Domain.Product.Camper;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-14.41
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Mile implements IF_Mile{
    private final double FREE_MILEAGE = 1000;
    private double mileAmount;
    private final String UNIT = "Km";


    public Mile() {
    }

    public Mile(double mileAmount) {
        this.mileAmount = mileAmount;
    }

    public double getFREE_MILEAGE() {
        return FREE_MILEAGE;
    }

    public String getUNIT() {
        return UNIT;
    }

    public double getMileAmount() {
        return mileAmount;
    }

    public void setMileAmount(double mileAmount) {
        this.mileAmount = mileAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mile mile = (Mile) o;
        return Double.compare(mile.FREE_MILEAGE, FREE_MILEAGE) == 0 && Double.compare(mile.mileAmount, mileAmount) == 0 && Objects.equals(UNIT, mile.UNIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FREE_MILEAGE, mileAmount, UNIT);
    }

    @Override
    public String toString() {
        return "Mile{" +
                "FREE_MILEAGE=" + FREE_MILEAGE +
                ", mileAmount=" + mileAmount +
                ", UNIT='" + UNIT + '\'' +
                '}';
    }

    @Override
    public boolean checkFreeMile() {
        if(getMileAmount() - getFREE_MILEAGE() > 0){
            return true;
        }
        return false;
    }

    @Override
    public double getRestAmount() {
        return mileAmount - FREE_MILEAGE;
    }
}
