package com.Domin.Product.Camper;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-14.41
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Mile {
    private final double FREE_MILEAGE = 1000;
    private double mileAmount;
    private String unit;


    public Mile() {
    }

    public Mile(double mileAmount, String unit) {
        this.mileAmount = mileAmount;
        this.unit = unit;
    }

    public double getFREE_MILEAGE() {
        return FREE_MILEAGE;
    }

    public double getMileAmount() {
        return mileAmount;
    }

    public void setMileAmount(double mileAmount) {
        this.mileAmount = mileAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mile mile = (Mile) o;
        return Double.compare(mile.FREE_MILEAGE, FREE_MILEAGE) == 0 && Double.compare(mile.mileAmount, mileAmount) == 0 && Objects.equals(unit, mile.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FREE_MILEAGE, mileAmount, unit);
    }

    @Override
    public String toString() {
        return "Mile{" +
                "FREE_MILEAGE=" + FREE_MILEAGE +
                ", mileAmount=" + mileAmount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
