package com.company.disp;

import  java.util.Scanner;

/**create the fields to be used**/

public class loadFactor {
   private int aps;
   private int pilot;
   private int coPilot;
   private int fuel;
   private int pax;
   private int bags;
   private  int frieght;

   /**make the constructor**/

    public loadFactor(int aps, int pilot, int coPilot, int fuel, int pax, int bags, int frieght){
        this.aps = aps;
        this.pilot = pilot;
        this.coPilot = coPilot;
        this.fuel = fuel;
        this.pax = pax;
        this.bags = bags;
        this.frieght = frieght;
    }

    /**create getters and setters (for private fields)**/

    public int getAps() {
        return aps;
    }

    public void setAps(int aps) {
        this.aps = aps;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(int coPilot) {
        this.coPilot = coPilot;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public int getFrieght() {
        return frieght;
    }

    public void setFrieght(int frieght) {
        this.frieght = frieght;
    }

    /**define functions**/
    public static loadFactor questions(){
        Scanner inputs = new Scanner(System.in);

        System.out.println("Enter the APS weight");
        int aps = inputs.nextInt();
        System.out.println("Enter Pilot weight");
        int pilot = inputs.nextInt();
        System.out.println("Enter C0-pilot weight");
        int coPilot = inputs.nextInt();
        System.out.println("Enter fuel weight");
        int fuel = inputs.nextInt();
        System.out.println("Enter pax weight");
        int pax = inputs.nextInt();
        System.out.println("Enter baggage weight");
        int bags = inputs.nextInt();
        System.out.println("Enter freight weight");
        int frieght = inputs.nextInt();

        return new loadFactor(aps, pilot, coPilot, fuel, pax, bags, frieght);
    }

    public int crew(){
        return this.pilot + this.coPilot;
    }
    public int disposableLoad(){
        return 26500 - crew() - this.aps;
    }
    public int payloadAvailable(){
        return disposableLoad() - this.fuel;
    }
    public int baggageLoad(){
        return this.bags + this.frieght;
    }
    public int dryWeight(){
        return this.aps + crew();
    }
    public int takeOffWeight(){
        return dryWeight() + baggageLoad() + this.pax + this.fuel;
    }
}

