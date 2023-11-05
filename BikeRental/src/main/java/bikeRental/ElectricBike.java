package bikeRental;

public class ElectricBike extends Bicycle {
    private static double price;

    public ElectricBike() {
        super();
        this.price = 0.5;
    }

    public double getPrice() {
        return this.price;
    }
}
