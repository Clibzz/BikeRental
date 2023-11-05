package bikeRental;

public abstract class Bicycle {
    private int travelledKilometers;

    public Bicycle() {
        this.travelledKilometers = 0;
    }

    public int getTravelledKilometers() {
        return this.travelledKilometers;
    }

    public void addTravelledKilometers(int travelledKilometers) {
        this.travelledKilometers += travelledKilometers;
    }
}
