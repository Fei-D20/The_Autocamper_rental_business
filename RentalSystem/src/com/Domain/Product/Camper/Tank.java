package com.Domain.Product.Camper;

import java.util.Objects;

/**
 * @ author Fei Gu
 * @ create 2021-05-02-16.11
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Tank implements IF_Tank{
    private double tankAmount;
    private final double FULL_TANK_AMOUNT;

    public Tank(double FULL_TANK_AMOUNT) {
        this.FULL_TANK_AMOUNT = FULL_TANK_AMOUNT;
    }

    public Tank(double tankAmount, double FULL_TANK_AMOUNT) {
        this.tankAmount = tankAmount;
        this.FULL_TANK_AMOUNT = FULL_TANK_AMOUNT;
    }

    public double getTankAmount() {
        return tankAmount;
    }

    public void setTankAmount(double tankAmount) {
        this.tankAmount = tankAmount;
    }

    public double getFULL_TANK_AMOUNT() {
        return FULL_TANK_AMOUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tank tank = (Tank) o;
        return Double.compare(tank.tankAmount, tankAmount) == 0 && Double.compare(tank.FULL_TANK_AMOUNT, FULL_TANK_AMOUNT) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tankAmount, FULL_TANK_AMOUNT);
    }

    @Override
    public String toString() {
        return "Tank{" +
                "tankAmount=" + tankAmount +
                ", FULL_TANK_AMOUNT=" + FULL_TANK_AMOUNT +
                '}';
    }

    @Override
    public boolean checkFullTank() {
        if(getFULL_TANK_AMOUNT() - getTankAmount() == 0){
            return true;
        }
        return false;
    }
}
