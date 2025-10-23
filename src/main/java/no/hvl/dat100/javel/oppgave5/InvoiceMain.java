package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();
        double[][] usageCustomer1 = CustomerPowerUsageData.usage_month_customer1;
        double[][] usageCustomer2 = CustomerPowerUsageData.usage_month_customer2;
        double[][] usageCustomer3 = CustomerPowerUsageData.usage_month_customer3;

        Customer customer1 = new Customer("Kari Nordmann", "kari.nordmann@gmail.com", 100, PowerAgreementType.SPOTPRICE);
        Customer customer2 = new Customer("Per Hansen", "per.hansen@gmail.com", 102, PowerAgreementType.POWERSUPPORT);
        Customer customer3 = new Customer("Ola Nordmann", "OlaNordmann@gmail.com",101,PowerAgreementType.NORGESPRICE);

        Invoice invoice1 = new Invoice(customer1, "juli",usageCustomer1,CustomerPowerUsageData.priser);
        Invoice invoice2 = new Invoice(customer2, "juli", usageCustomer2, CustomerPowerUsageData.priser);
        Invoice invoice3 = new Invoice(customer3, "juli", usageCustomer3, CustomerPowerUsageData.priser);

        invoice1.computeAmount();
        invoice1.printInvoice();

        invoice2.computeAmount();
        invoice2.printInvoice();

        invoice3.computeAmount();
        invoice3.printInvoice();

    }
}
