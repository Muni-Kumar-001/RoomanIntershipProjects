package com.vehicleSystem;

public class Vehicle implements Comparable<Vehicle> {

    private String vName;
    private int mfgYear;
    private int price;

    public Vehicle(String vName, int mfgYear, int price) {
        this.vName = vName;
        this.mfgYear = mfgYear;
        this.price = price;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public int getMfgYear() {
        return mfgYear;
    }

    public void setMfgYear(int mfgYear) {
        this.mfgYear = mfgYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Implementing the compareTo method for Comparable<Vehicle>
    @Override
    public int compareTo(Vehicle other) {
        // Default sorting by vName alphabetically
        return this.vName.compareTo(other.vName);
    }

    @Override
    public String toString() {
        return "Vehicle [vName=" + vName + ", mfgYear=" + mfgYear + ", price=" + price + "]";
    }
}
