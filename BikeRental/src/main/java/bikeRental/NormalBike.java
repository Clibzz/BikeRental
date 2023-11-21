package bikeRental;

public class NormalBike extends Bicycle {
    private static final double price = 0.2;

    public NormalBike() {
        super();
    }

    public double getPrice() {
        return this.price;
    }
}
