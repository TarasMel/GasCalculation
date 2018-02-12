package com.example.taras.gascalculation;

import java.util.ArrayList;

/**
 * Created by Taras on 06.02.2018.
 */

public class Utils {
    //TODO probably need to delete private method's, and stay them in static
    //private GasDescription gasDescription;
    // ArrayList<String> list = new ArrayList<>();
/*
    // gas calorific value
    private static double gasCalorificValue (GasDescription gasDescription){
        double gasCalorificValue;
        double a=100, b = 100, c = 100; //the values from the database for calorific value
        gasCalorificValue = ((gasDescription.getGasCO()/100)*a+(gasDescription.getGasCH4()/100)*b+
                (gasDescription.getGasH2()/100)*c);
        return gasCalorificValue;
    }

    public static String getGasCalorificValue (GasDescription gasDescription){
        return Double.toString(gasCalorificValue(gasDescription));
    }
    // gas density
    private static double gasDensity (GasDescription gasDescription) {
        double gasDensity;
        double a = 0, b = 0, c = 0, d = 0, e = 0; //the values from the database for density value
        gasDensity = ((gasDescription.getGasCO()/100)*a+(gasDescription.getGasCH4()/100)*b+
                (gasDescription.getGasH2()/100)*c + (gasDescription.getGasCO2()/100)*d+
                (gasDescription.getGasN2()/100)*e);
        return gasDensity;
    }

    public static double getGasDensity (GasDescription gasDescription) {
        return gasDensity(gasDescription);
    }

    // theoretical consumption of air when the excess air ratio equal to one
    private static double gasTheoreticalAirConsumption (GasDescription gasDescription){
        double gasTheoreticalAirConsumption;
        double a = 0, b = 0; //the values from the database for density value
        gasTheoreticalAirConsumption = (1/21)*(a*(gasDescription.getGasCO()+
                gasDescription.getGasH2())+b*gasDescription.getGasCH4());
        return gasTheoreticalAirConsumption;
    }

    public static double getGasTheoreticalAirConsumption (GasDescription gasDescription){
        return gasTheoreticalAirConsumption(gasDescription);
    }

    // the normal rate of flame propagation
    private static double gasNormalRate (GasDescription gasDescription){
        double gasNormalRate;
        double a = 0, b = 0, c = 0, d = 0, e = 0; //the values from the database for density value

        gasNormalRate = ((gasDescription.getGasCO()*a+gasDescription.getGasCH4()*b+
                gasDescription.getGasH2()*c+gasDescription.getGasCO2()*d+gasDescription.getGasN2()*e)
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
        double a = 0, b = 0, c = 0, d = 0, e = 0; //the values from the database for density value

        gasLowerFT = ((gasDescription.getGasCO()+gasDescription.getGasCH4()+
                gasDescription.getGasH2()+gasDescription.getGasCO2()+gasDescription.getGasN2())
                /(gasDescription.getGasCO()/a+gasDescription.getGasCH4()/b+
                gasDescription.getGasH2()/c));

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
        double a = 0, b = 0, c = 0, d = 0, e = 0; //the values from the database for density value

        gasHigherFL = ((gasDescription.getGasCO()+gasDescription.getGasCH4()+
                gasDescription.getGasH2()+gasDescription.getGasCO2()+gasDescription.getGasN2())
                /(gasDescription.getGasCO()/a+gasDescription.getGasCH4()/b+
                gasDescription.getGasH2()/c));

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
    //TODO
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

    //TODO Перевірити дану хуйню в Інтелідж Ідеї
    //Перевод стринго в объект классаа
    private static  ArrayList<String> gasDescriptionToString (GasDescription gasDescription){
        ArrayList<String> list = new ArrayList<>();
        list.add(Double.toString(gasDescription.getGasCH4()));
        list.add(Double.toString(gasDescription.getGasCO()));
        list.add(Double.toString(gasDescription.getGasH2()));
        list.add(Double.toString(gasDescription.getGasCO2()));
        list.add(Double.toString(gasDescription.getGasN2()));
        return list;
    }
    public static ArrayList<String> getGasDescriptionToString (GasDescription gasDescription){
        return gasDescriptionToString(gasDescription);
    }*/
}
