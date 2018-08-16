package com.example.taras.gascalculation.logic;


import android.os.Parcel;
import android.os.Parcelable;

public class GasDescription{
    private double gasCO;
    private double gasCH4;
    private double gasH2;
    private double gasCO2;
    private double gasN2;

    public GasDescription(){}

    public GasDescription(double gasCH4, double gasCO, double gasH2, double gasCO2, double gasN2) {
        this.gasCH4 = gasCH4;
        this.gasCO = gasCO;
        this.gasH2 = gasH2;
        this.gasCO2 = gasCO2;
        this.gasN2 = gasN2;
    }

    private boolean gasBallast (GasDescription gasDescription){
        return gasDescription.getGasCO2() == 0 && gasDescription.gasN2 == 0;
    }

    boolean getGasBallast (GasDescription gasDescription) {
        return gasBallast(gasDescription);
    }

    private double sumBallast (GasDescription gasDescription){
        return (gasDescription.getGasCO2()+gasDescription.getGasN2())/100;
    }

    double getSumBallast (GasDescription gasDescription){
        return gasDescription.sumBallast(gasDescription);
    }

    public double getGasCO() {
        return gasCO;
    }

    public void setGasCO(double gasCO) {
        this.gasCO = gasCO;
    }

    public double getGasCH4() {
        return gasCH4;
    }

    public void setGasCH4(double gasCH4) {
        this.gasCH4 = gasCH4;
    }

    public double getGasH2() {
        return gasH2;
    }

    public void setGasH2(double gasH2) {
        this.gasH2 = gasH2;
    }

    public double getGasCO2() {
        return gasCO2;
    }

    public void setGasCO2(double gasCO2) {
        this.gasCO2 = gasCO2;
    }

    public double getGasN2() {
        return gasN2;
    }

    public void setGasN2(double gasN2) {
        this.gasN2 = gasN2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GasDescription that = (GasDescription) o;

        if (Double.compare(that.gasCO, gasCO) != 0) return false;
        if (Double.compare(that.gasCH4, gasCH4) != 0) return false;
        if (Double.compare(that.gasH2, gasH2) != 0) return false;
        if (Double.compare(that.gasCO2, gasCO2) != 0) return false;
        return Double.compare(that.gasN2, gasN2) == 0;

    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(gasCO);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gasCH4);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gasH2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gasCO2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gasN2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
