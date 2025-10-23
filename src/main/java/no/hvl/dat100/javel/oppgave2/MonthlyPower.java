package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {

        for (int i = 0;i<usage.length;i++){
            System.out.print("Day"+(i+1)+": ");
            for (int j = 0;j<usage[i].length;j++){
                System.out.print(usage[i][j]+" kWh ");
            }
            System.out.println();
        }

    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {

        for (int i = 0;i<prices.length;i++){
            System.out.print("Day"+(i+1)+": ");
            for (int j = 0;j<prices[i].length;j++){
                System.out.print(prices[i][j]+" kr ");
            }
            System.out.println();
        }
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

        for (int i = 0;i<usage.length;i++){
            for (int j = 0;j<usage[i].length;j++){
                sum += usage[i][j];
            }
        }
        System.out.println(sum +" kWh");
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = 0;
        int i = 0;
        int j = 0;
        while (usage < threshold && i < powerusage.length) {
            usage += powerusage[i][j];
            if(usage>threshold){
                exceeded = true;
            }
            if (j<powerusage[i].length-1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
            System.out.println(exceeded);
            return exceeded;
        }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;

        for (int i = 0;i<usage.length;i++){
            for (int j = 0;j<usage[i].length;j++){
                price += usage[i][j]*prices[i][j];
            }
        }
        System.out.println(price + "kr");
        return price;
    }
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;
    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;
        for (int i = 0;i<usage.length;i++){
            for (int j = 0;j<usage[i].length;j++){
                if (THRESHOLD<prices[i][j]) {
                    support += usage[i][j] * (prices[i][j] - THRESHOLD) * PERCENTAGE;
                }
            }
        }
        System.out.println(support + "kr");


        return support;
    }
    private static final double NORGESPRIS_KWH = 0.5;
    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;
        for (int i = 0;i<usage.length;i++){
            for (int j = 0;j<usage[i].length;j++){
                    price += usage[i][j] * NORGESPRIS_KWH;
            }
        }
        System.out.println(price + "kr");


        return price;
    }
}
