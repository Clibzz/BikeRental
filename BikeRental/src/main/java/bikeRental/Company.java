package bikeRental;

import java.util.HashMap;
import java.util.HashSet;

public class Company {
    private HashSet<Bicycle> bicycles;
    private HashMap<Bicycle, Customer> rentedBicycles;
    private double balance;

    public Company() {
        this.bicycles = new HashSet<>();
        this.rentedBicycles = new HashMap<>();
        this.balance = 0.00;
    }

    public void addBicycle(Bicycle bicycle) {
        this.bicycles.add(bicycle);
    }

    public HashSet<Bicycle> getBicycles() {
        return this.bicycles;
    }

    public void removeBicycle(Bicycle bicycle) {
        this.bicycles.remove(bicycle);
    }

    public void addRentedBicycle(Bicycle bicycle, Customer customer) {
        this.rentedBicycles.put(bicycle, customer);
    }

    public HashMap<Bicycle, Customer> getRentedBicycles() {
        return this.rentedBicycles;
    }

    public void removeRentedBicycle(Bicycle bicycle) {
        this.rentedBicycles.remove(bicycle);
    }

    public void addBalance(double amount)
    {
        this.balance += amount;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public int getTotalTravelledKilometers() {
        int totalTravelledKilometers = 0;
        for (Bicycle bicycle : this.bicycles) {
            totalTravelledKilometers += bicycle.getTravelledKilometers();
        }
        return totalTravelledKilometers;
    }
}
