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

    public void addTravelledKilometers(int travelledKilometers) {
        this.travelledKilometers += travelledKilometers;
    }

    public double getDepositAmount() {
        return this.depositAmount;
    }
    public abstract double getPrice();
}
