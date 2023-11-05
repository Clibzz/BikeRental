package bikeRental;

public abstract class Bicycle {
    private int travelledKilometers;
    private double depositAmount;

    public Bicycle() {
        this.travelledKilometers = 0;
        this.depositAmount = 20.00;
    }

    public int getTravelledKilometers() {
        return this.travelledKilometers;
    }

    /**
     * Add the travelled amount of kilometers of a bicycle to the current amount
     * @param travelledKilometers The travelled distance in kilometers
     */
    public void addTravelledKilometers(int travelledKilometers) {
        this.travelledKilometers += travelledKilometers;
    }

    public double getDepositAmount() {
        return this.depositAmount;
    }

    /**
     * An abstract method to get the price per kilometer of the different kinds of bicycles
     * @return The price per kilometer of renting a specific kind of bicycle
     */
    public abstract double getPrice();
}
