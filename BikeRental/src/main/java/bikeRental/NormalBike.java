package bikeRental;

public class NormalBike extends Bicycle {
    private static double price;

    public NormalBike() {
        super();
        this.price = 0.2;
    }

    public double price() {
        return this.price;
    }
}
