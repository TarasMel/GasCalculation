package com.example.taras.gascalculation.logic;


import java.util.ArrayList;



public class Utils {
    //TODO Check that all method works correctly, and maybe some of them we don't need to use


    // gas calorific value
    private static double gasCalorificValue (GasDescription gasDescription){
        double gasCalorificValue;
        gasCalorificValue = ((gasDescription.getGasCO()/100)* Constants.CO_GAS_CALORIFIC_VALUE+
                (gasDescription.getGasCH4()/100)*Constants.CH4_GAS_CALORIFIC_VALUE+
                (gasDescription.getGasH2()/100)*Constants.H2_GAS_CALORIFIC_VALUE);
        return gasCalorificValue;
    }

    public static String getGasCalorificValue (GasDescription gasDescription){
        return Double.toString(gasCalorificValue(gasDescription));
    }
    // gas density
    private static double gasDensity (GasDescription gasDescription) {
        double gasDensity;
        gasDensity = ((gasDescription.getGasCO()/100)*Constants.CO_GAS_DENSITY+(gasDescription.getGasCH4()/100)*Constants.CH4_GAS_DENSITY+
                (gasDescription.getGasH2()/100)*Constants.H2_GAS_DENSITY + (gasDescription.getGasCO2()/100)*Constants.CO2_GAS_DENSITY+
                (gasDescription.getGasN2()/100)*Constants.N2_GAS_DENSITY);
        return gasDensity;
    }

    public static double getGasDensity (GasDescription gasDescription) {
        return gasDensity(gasDescription);
    }

    // theoretical consumption of air when the excess air ratio equal to one
    private static double gasTheoreticalAirConsumption (GasDescription gasDescription){
        double gasTheoreticalAirConsumption;
        
        gasTheoreticalAirConsumption = (1/21)*(Constants.CO_AND_H2_GAS_THEORETICAL_AIR_CONSUMPTION*
                (gasDescription.getGasCO()+
                gasDescription.getGasH2())+Constants.CH4_GAS_THEORETICAL_AIR_CONSUMPTION*
                gasDescription.getGasCH4());
        return gasTheoreticalAirConsumption;
    }

    public static double getGasTheoreticalAirConsumption (GasDescription gasDescription){
        return gasTheoreticalAirConsumption(gasDescription);
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
            double gasNR;
            gasNR= gasNormalRate*(1-0.01*gasDescription.getGasN2()
                    -0.012*gasDescription.getGasCO2());
            return gasNR;
        }
    }

    public static double getGasNormalRate (GasDescription gasDescription){
        return gasNormalRate(gasDescription);
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
            double gasLFT;
            gasLFT = gasLowerFT *((1+(gasDescription.getSumBallast(gasDescription)/
                    (1-gasDescription.getSumBallast(gasDescription)))*100)/(100+gasLowerFT*
                    (gasDescription.getSumBallast(gasDescription)/
                            (1-gasDescription.getSumBallast(gasDescription)))));
            return gasLFT;
        }
    }

    public static double getGasLowerFL (GasDescription gasDescription){
        return gasLowerFL(gasDescription);
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
            double gasHFT;
            gasHFT = gasHigherFL *((1+(gasDescription.getSumBallast(gasDescription)/
                    (1-gasDescription.getSumBallast(gasDescription)))*100)/(100+gasHigherFL*
                    (gasDescription.getSumBallast(gasDescription)/
                            (1-gasDescription.getSumBallast(gasDescription)))));
            return gasHFT;
        }
    }

    public static double getGasHigherFL (GasDescription gasDescription){
        return gasHigherFL(gasDescription);
    }


    private static  double listToGasDescription (String list){
        double gasComp;
        gasComp = Double.parseDouble(list);
        return gasComp;
    }
    public static double getGasDescriptions (String list){
        return listToGasDescription(list);
    }

    private static double sumOfAllComponents (GasDescription gasDescription){
        double sum;
        return sum = gasDescription.getGasCH4()+gasDescription.getGasCO()+gasDescription.getGasH2()+
                gasDescription.getGasCO2()+gasDescription.getGasN2();
    }

    public static boolean checkingAdding (GasDescription gasDescription){
        if (sumOfAllComponents(gasDescription) != 100.0) return false;
        else return true;
    }


    //Перевод в объекта Эррей лист
    private static  ArrayList<String> gasDescriptionToString (GasDescription gasDescription){
        ArrayList<String> list = new ArrayList<>();
        list.add(Double.toString(gasDescription.getGasCH4()));
        list.add(Double.toString(gasDescription.getGasCO()));
        list.add(Double.toString(gasDescription.getGasH2()));
        list.add(Double.toString(gasDescription.getGasCO2()));
        list.add(Double.toString(gasDescription.getGasN2()));
        return list;
    }
    public static ArrayList<String> getGasDescriptionToString (GasDescription gasDescription) {
        return gasDescriptionToString(gasDescription);
    }
}
