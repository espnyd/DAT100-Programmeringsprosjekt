package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import java.util.Arrays;

public class Invoice {

    private Customer c;
    private String month;
    private double[][] usage;
    private double[][] prices;

    private double amount;

    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0;
    }

    public void computeAmount() {
        PowerAgreementType agreement = c.getAgreement();
        double total = 0;

        if (agreement == PowerAgreementType.SPOTPRICE) {
            for (int day = 0; day < usage.length; day++) {
                for (int hour = 0; hour < usage[day].length; hour++) {
                    total += usage[day][hour] * prices[day][hour];
                }
            }

        } else if (agreement == PowerAgreementType.POWERSUPPORT) {
            double sumPrices = 0;
            int count = 0;
            double Threshold = 0.9375;
            double Support = 0.1;
            for (int day = 0; day < prices.length; day++) {
                for (int hour = 0; hour < prices[day].length; hour++) {
                    if(prices[day][hour]>Threshold){
                        sumPrices+=(prices[day][hour]-Threshold)*Support+Threshold;
                    }else {
                        sumPrices += prices[day][hour];

                    }
                    count++;
                }
            }

            double avgPrice = sumPrices / count;

            double totalUsage = 0;
            for (int day = 0; day < usage.length; day++) {
                for (int hour = 0; hour < usage[day].length; hour++) {
                    totalUsage += usage[day][hour];
                }
            }

            total = avgPrice * totalUsage;

        } else if (agreement == PowerAgreementType.NORGESPRICE) {
            double FIXED_PRICE = 0.50;
            double totalUsage = 0;

            for (int day = 0; day < usage.length; day++) {
                for (int hour = 0; hour < usage[day].length; hour++) {
                    totalUsage += usage[day][hour];
                }
            }

            total = FIXED_PRICE * totalUsage;
        }

        amount = total;
    }

    public void printInvoice() {
        double totalUsage = 0;
        for (int day = 0; day < usage.length; day++) {
            for (int hour = 0; hour < usage[day].length; hour++) {
                totalUsage += usage[day][hour];
            }
        }
        System.out.printf("Month: %s\n", month);
        System.out.printf("Usage:   %8.2f kWh\n", totalUsage);
        System.out.printf("Amount:  %8.2f NOK\n", amount);
        System.out.printf("========================\n" + "\n" + "========================\n");
        System.out.printf("Customer number %d\n", c.getCustomer_id());
        System.out.printf("Name  %s\n", c.getName());
        System.out.printf("Email %s\n", c.getEmail());
        System.out.printf("Agreement %s\n", c.getAgreement().toString());
        System.out.println();


    }
}
