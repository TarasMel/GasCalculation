package com.example.taras.gascalculation.logic;


public class Utils {

    // gas calorific value
    private static double gasCalorificValue (GasDescription gasDescription){
        return ((gasDescription.getGasCO()/100)* Constants.CO_GAS_CALORIFIC_VALUE+
                (gasDescription.getGasCH4()/100)*Constants.CH4_GAS_CALORIFIC_VALUE+
                (gasDescription.getGasH2()/100)*Constants.H2_GAS_CALORIFIC_VALUE);
    }

    public static String getGasCalorificValue (GasDescription gasDescription){
        return doubleToString(gasCalorificValue(gasDescription));
    }
    // gas density
    private static double gasDensity (GasDescription gasDescription) {
        return ((gasDescription.getGasCO()/100)*Constants.CO_GAS_DENSITY+(gasDescription.getGasCH4()/100)*Constants.CH4_GAS_DENSITY+
                (gasDescription.getGasH2()/100)*Constants.H2_GAS_DENSITY + (gasDescription.getGasCO2()/100)*Constants.CO2_GAS_DENSITY+
                (gasDescription.getGasN2()/100)*Constants.N2_GAS_DENSITY);
    }

    public static String getGasDensity (GasDescription gasDescription) {
        return doubleToString(gasDensity(gasDescription));
    }

    // theoretical consumption of air when the excess air ratio equal to one
    private static double gasTheoreticalAirConsumption (GasDescription gasDescription){
        return (1/21)*(Constants.CO_AND_H2_GAS_THEORETICAL_AIR_CONSUMPTION*
                (gasDescription.getGasCO()+
                gasDescription.getGasH2())+Constants.CH4_GAS_THEORETICAL_AIR_CONSUMPTION*
                gasDescription.getGasCH4());
    }

    public static String getGasTheoreticalAirConsumption (GasDescription gasDescription){
        return doubleToString(gasTheoreticalAirConsumption(gasDescription));
    }

    // the normal rate of flame propagation
    private static double gasNormalRate (GasDescription gasDescription){
        double gasNormalRate;
        gasNormalRate = ((gasDescription.getGasCO()*Constants.CO_GAS_NORMAL_RATE+
                gasDescription.getGasCH4()*Constants.CH4_GAS_NORMAL_RATE+
                gasDescription.getGasH2()*Constants.H2_GAS_NORMAL_RATE)
                /(gasDescription.getGasCO()+gasDescription.getGasCH4()+
                gasDescription.getGasH2()+gasDescription.getGasCO2()+gasDescription.getGasN2()));
        if(gasDescription.getGasBallast(gasDescription)) return gasNormalRate;
        else {
            return gasNormalRate*(1-0.01*gasDescription.getGasN2()
                    -0.012*gasDescription.getGasCO2());
        }
    }

    public static String getGasNormalRate (GasDescription gasDescription){
        return doubleToString(gasNormalRate(gasDescription));
    }

    // lower flammable limit
    private static double gasLowerFL (GasDescription gasDescription){
        double gasLowerFT;
        gasLowerFT = ((gasDescription.getGasCO()+gasDescription.getGasCH4()+
                gasDescription.getGasH2()+gasDescription.getGasCO2()+gasDescription.getGasN2())
                /(gasDescription.getGasCO()/Constants.CO_GAS_LOWER_FLAMMABLE_LIMIT+
                gasDescription.getGasCH4()/Constants.CH4_GAS_LOWER_FLAMMABLE_LIMIT+
                gasDescription.getGasH2()/Constants.H2_GAS_LOWER_FLAMMABLE_LIMIT));
        if(gasDescription.getGasBallast(gasDescription)) return gasLowerFT;
        else{
            return gasLowerFT *((1+(gasDescription.getSumBallast(gasDescription)/
                    (1-gasDescription.getSumBallast(gasDescription)))*100)/(100+gasLowerFT*
                    (gasDescription.getSumBallast(gasDescription)/
                            (1-gasDescription.getSumBallast(gasDescription)))));
        }
    }

    public static String  getGasLowerFL (GasDescription gasDescription){
        return doubleToString(gasLowerFL(gasDescription));
    }

    // higher flammable limit
    private static double gasHigherFL (GasDescription gasDescription){
        double gasHigherFL;
        gasHigherFL = ((gasDescription.getGasCO()+gasDescription.getGasCH4()+
                gasDescription.getGasH2()+gasDescription.getGasCO2()+gasDescription.getGasN2())
                /(gasDescription.getGasCO()/Constants.CO_GAS_HIGHER_FLAMMABLE_LIMIT+
                gasDescription.getGasCH4()/Constants.CH4_GAS_HIGHER_FLAMMABLE_LIMIT+
                gasDescription.getGasH2()/Constants.H2_GAS_HIGHER_FLAMMABLE_LIMIT));
        if(gasDescription.getGasBallast(gasDescription)) return gasHigherFL;
        else{
            return gasHigherFL *((1+(gasDescription.getSumBallast(gasDescription)/
                    (1-gasDescription.getSumBallast(gasDescription)))*100)/(100+gasHigherFL*
                    (gasDescription.getSumBallast(gasDescription)/
                            (1-gasDescription.getSumBallast(gasDescription)))));
        }
    }

    public static String getGasHigherFL (GasDescription gasDescription){
        return doubleToString(gasHigherFL(gasDescription));
    }

    //From Double to String
    private static  String doubleToString (double value){
        return Double.toString(value);
    }

    //From String to Double
    private static double stringToDouble (String string){
        return Double.parseDouble(string);
    }

    public static double getStringToDouble (String string){
        return stringToDouble(string);
    }

    private static double sumOfAllComponents (GasDescription gasDescription){
        return  gasDescription.getGasCH4()+gasDescription.getGasCO()+gasDescription.getGasH2()+
                gasDescription.getGasCO2()+gasDescription.getGasN2();
    }

    public static boolean checkingAdding (GasDescription gasDescription){
        return  sumOfAllComponents(gasDescription) == 100.0;
    }
    class A{}
    class B extends A{}

    public void sd(){
        A a = new A();
        B b =new B();

    }
}
