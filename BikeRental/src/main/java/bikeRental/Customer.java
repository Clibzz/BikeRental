package bikeRental;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void rentBicycle(Bicycle bicycle, Company company) throws BicycleBorrowedException{
        if (company.getBicycles().contains(bicycle)) {
            if (!company.getRentedBicycles().containsKey(bicycle)) {
                company.addRentedBicycle(bicycle, this);
                this.balance -= bicycle.getDepositAmount();
            } else {
                throw new BicycleBorrowedException();
            }
        } else {
            System.out.println("The company currently doesn't own the selected bicycle, please try again!");
        }
    }

    public void handBicycleIn(int travelledTimeInHours, int travelledDistance, Bicycle bicycle, Company company) {
        double price = 0;
        if (company.getRentedBicycles().containsKey(bicycle) && company.getRentedBicycles().containsValue(this)) {
            price += (bicycle.getPrice() * travelledDistance) + (travelledTimeInHours * 2) - (bicycle.getDepositAmount());
            company.removeRentedBicycle(bicycle);
            this.balance -= price;
            bicycle.addTravelledKilometers(travelledDistance);
        }
    }
}
