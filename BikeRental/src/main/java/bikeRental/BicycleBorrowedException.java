package bikeRental;

public class BicycleBorrowedException extends Exception {
    public BicycleBorrowedException() {
        super("The bicycle you're trying to rent is already being rented at the moment");
    }
}
