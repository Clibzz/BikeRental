package bikeRental;

import java.util.HashMap;
import java.util.HashSet;

public class Company {
    private HashSet<Bicycle> bicycles;
    private HashMap<Bicycle, Customer> rentedBicycles;

    public Company() {
        this.bicycles = new HashSet<>();
        this.rentedBicycles = new HashMap<>();
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

    /**
     * Check the amount of bicycles that's currently available
     * @return The current amount of available bicycles
     */
    public int checkAvailableBicyclesAmount() {
        int bicycleAmount = 0;
        // Loop through all the bicycles of the company
        for (Bicycle bicycle : this.bicycles) {
            // Check if the current selected bicycle is in the list of rented bicycles
            if (!getRentedBicycles().containsKey(bicycle)) {
                bicycleAmount++;
            }
        }
        return bicycleAmount;
    }

    /**
     * Get the total amount of travelled kilometers
     * @return The total travelled distance of all bikes of the company in kilometers
     */
    public int getTotalTravelledKilometers() {
        int totalTravelledKilometers = 0;
        for (Bicycle bicycle : this.bicycles) {
            totalTravelledKilometers += bicycle.getTravelledKilometers();
        }
        return totalTravelledKilometers;
    }
}
