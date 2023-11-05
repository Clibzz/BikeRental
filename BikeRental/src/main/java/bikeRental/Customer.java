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

    public double getBalance() {
        return this.balance;
    }

    public void rentBicycle(Bicycle bicycle, Company company) {
        if (company.getBicycles().contains(bicycle)) {
            if (!company.getRentedBicycles().containsKey(bicycle) && !company.getRentedBicycles().containsValue(this)) {
                company.addRentedBicycle(bicycle, this);
                this.balance -= bicycle.getDepositAmount();
            } else {
                System.out.println("The bicycle has already been borrowed by an other customer");
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
            if (this.balance >= price) {
                this.balance -= price;
            }
            else {
                System.out.println("The customer does not have enough balance to pay for renting the bicycle");
            }
            bicycle.addTravelledKilometers(travelledDistance);
        }
    }
}
