package bikeRental;

public class MountainBike extends Bicycle {
    private static double price;

    public MountainBike() {
        super();
        this.price = 0.25;
    }

    public double price() {
        return this.price;
    }
}
