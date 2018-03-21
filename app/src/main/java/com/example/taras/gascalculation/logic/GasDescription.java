package com.example.taras.gascalculation.logic;



class GasDescription {
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

/*    private double sumOfAllComponents (GasDescription gasDescription){
        double sum;
        return sum = gasDescription.getGasCH4()+gasDescription.getGasCO()+gasDescription.getGasH2()+
                gasDescription.getGasCO2()+gasDescription.getGasN2();
    }

    public boolean checkingAdding (GasDescription gasDescription){
        if (sumOfAllComponents(gasDescription) != 100.0) return false;
        else return true;
    }*/

    double getGasCO() {
        return gasCO;
    }

    public void setGasCO(double gasCO) {
        this.gasCO = gasCO;
    }

    double getGasCH4() {
        return gasCH4;
    }

    public void setGasCH4(double gasCH4) {
        this.gasCH4 = gasCH4;
    }

    double getGasH2() {
        return gasH2;
    }

    public void setGasH2(double gasH2) {
        this.gasH2 = gasH2;
    }

    double getGasCO2() {
        return gasCO2;
    }

    public void setGasCO2(double gasCO2) {
        this.gasCO2 = gasCO2;
    }

    double getGasN2() {
        return gasN2;
    }

    public void setGasN2(double gasN2) {
        this.gasN2 = gasN2;
    }
}
