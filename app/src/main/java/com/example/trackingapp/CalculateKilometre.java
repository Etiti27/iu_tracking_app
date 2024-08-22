package com.example.trackingapp;

public class CalculateKilometre {
    double tuesday_distance, thursday_distance, totalKilometre;
    public CalculateKilometre(double tuesday_distance, double thursday_distance){
        this.tuesday_distance=tuesday_distance;
        this.thursday_distance=thursday_distance;
    }


    public double calculateTotalKilometre() {
        double tues= this.tuesday_distance * 1.5;
        double thur= this.thursday_distance *1.5;
        this.totalKilometre = (tues + thur)/2;
        return totalKilometre;
    }

//    calculate the distance

}
