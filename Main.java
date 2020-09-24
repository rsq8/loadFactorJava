package com.company.disp;

import java.util.Scanner;

public class Main{

    static loadFactor flight =  loadFactor.questions();
    static Scanner inputs = new Scanner(System.in);

    public static void main(String[] args) {

        //choose what to calculate

        System.out.println("Select an option");
        System.out.println("a.Payload, b.Take-off weight");
        String option = inputs.next();

        //calculate payload available

        if (option.equals("a".toLowerCase())) {
            int payload = flight.payloadAvailable();
            System.out.println(payload);
            System.out.println("would you like to calculate your take-off weight? Answer y/n");
            String answer = inputs.next();
            if (answer.equals("y".toLowerCase())) {
                takeOffWeight();
            }
            else if(answer.equals("n".toLowerCase())){
                System.out.println("Enjoy your flight!");
            }else {System.out.println("Sorry, wrong input. Try again");
            }
        }

        if (option.equals("b".toLowerCase())) {
            takeOffWeight();
        }
    }

    /**calculate take off weight and alert excess baggage**/

    public static void takeOffWeight(){

        int baggage = flight.baggageLoad();
        while (baggage > 1000) {
            baggage = baggageException();
        }

        //alert excess weight

        int tOff = flight.takeOffWeight();
        while (tOff > 26500) {
            System.out.println("The take-off weight of " + tOff + "lbs " + " exceeds the maximum 26500lbs for the S92!");
            System.out.println("please take another look at your payload and fuel");
            System.out.println("Enter a new pax weight");
            flight.setPax(inputs.nextInt());
            System.out.println("Enter new baggage weight");
            flight.setBags(inputs.nextInt());
            System.out.println("Enter new freight weight");
            flight.setFrieght(inputs.nextInt());
            baggage = flight.baggageLoad();
            while (baggage > 1000) {
                baggage = baggageException();
            }
            System.out.println("It is strongly recommended that fuel planning as per OMA is strictly followed");
            System.out.println("Enter fuel");
            flight.setFuel(inputs.nextInt());
            tOff = flight.takeOffWeight();

        }
        System.out.println("Take-off weight is " + tOff);
        System.out.println("Enjoy your flight!");

    }
    /**excess baggage handling**/
    public static int baggageException(){

        int baggage = flight.baggageLoad();

        System.out.println("The baggage weight of " + baggage + " exceeds the maximum allowable 1000lbs. Please reduce baggage to proceed");
        System.out.println("Enter corrected baggage weight");
        flight.setBags(inputs.nextInt());
        System.out.println("Enter corrected freight");
        flight.setFrieght(inputs.nextInt());
        baggage = flight.baggageLoad();
        return baggage;

    }

}
