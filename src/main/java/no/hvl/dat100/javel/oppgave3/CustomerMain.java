package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();
        Customer c1 = new Customer("Per","Per@gmail.com",2,PowerAgreementType.SPOTPRICE);
        System.out.println(c1);
        c1.setName("Narve");
        System.out.println(c1.getName());

        /*
        TODO

         Write code that creates a Customer object and teste the methods implemented in the class

        */
    }
}
