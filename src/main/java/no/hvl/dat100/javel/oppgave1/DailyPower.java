package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {

        for(double price: prices){
            System.out.print(price + " kr/kWh ");
        }

    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {

        for(double use: usage){
            System.out.print(use + " kWh ");
        }
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {

        double sum = 0;

        for(double use: usage){
            sum += use;

        }
        System.out.print(sum + " kWh");
        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;

        for (int i = 0;i<usage.length;i++){
            price += usage[i]*prices[i];
        }
        System.out.print(price + " kr");
        return price;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    private static double getSupport(double usage, double price) {

        double support = 0;

        if (price>THRESHOLD){
            support = usage*(price-THRESHOLD)*PERCENTAGE;
        }
        System.out.print(support + " kr");
        return support;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {

        double support = 0;

        for(int i = 0;i<usage.length;i++){
            if (prices[i]>THRESHOLD){
                support += usage[i]*(prices[i]-THRESHOLD)*PERCENTAGE;
            }
        }
        System.out.print(support + " kr");
        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {

        double price = 0;

        for(double use : usage){
            price+= use*NORGESPRIS_KWH;
        }
        System.out.print(price + " kr");
        return price;
    }

    // g) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        double temp_max = 0;

        for(int i = 0;i<usage.length-1;i++){
            if(usage[i]<usage[i+1]){
                temp_max=usage[i+1];
            }
        }
        System.out.print(temp_max + " kWh");
        return temp_max;
    }

    public static double findAvgPower(double[] usage) {

        double average = 0;
        for(int i = 0;i<usage.length;i++){
           average +=usage[i];
        }
        average = average/usage.length;

        System.out.print(average + " kWh");
        return average;
    }
}