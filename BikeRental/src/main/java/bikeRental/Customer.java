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

    /**
     * Rent a bicycle from a company
     * @param bicycle The bicycle that the customer would like to rent
     * @param company The company the customer would like to rent a bicycle from
     */
    public void rentBicycle(Bicycle bicycle, Company company) {
        // Check if the company has the bicycle that the customer wants to rent
        if (company.getBicycles().contains(bicycle)) {
            // Check if the bicycle has already been rented or if the customer is currently renting a bicycle
            if (!company.getRentedBicycles().containsKey(bicycle) && !company.getRentedBicycles().containsValue(this)) {
                company.addRentedBicycle(bicycle, this);
                // Take the deposit amount of the customer's balance
                this.balance -= bicycle.getDepositAmount();
            } else {
                System.out.println("The bicycle has already been borrowed by an other customer");
            }
        } else {
            System.out.println("The company currently doesn't own the selected bicycle, please try again!");
        }
    }

    /**
     * Hand in the bicycle that the customer has rented
     * @param travelledTimeInHours The time the customer has rented the bicycle for
     * @param travelledDistance The distance the customer has travelled with the rented bicycle
     * @param bicycle The rented bicycle
     * @param company The company of which the customer is renting the bicycle
     */
    public void handBicycleIn(int travelledTimeInHours, int travelledDistance, Bicycle bicycle, Company company) {
        double price = 0;
        // Check if the bicycle is currently rented by the customer
        if (company.getRentedBicycles().containsKey(bicycle) && company.getRentedBicycles().containsValue(this)) {
            // Calculate the total price the customer has to pay for renting the bicycle
            price += (bicycle.getPrice() * travelledDistance) + (travelledTimeInHours * 2) - (bicycle.getDepositAmount());
            company.removeRentedBicycle(bicycle);
            // Check if the customer has enough money to pay for renting the bicycle
            if (this.balance >= price) {
                this.balance -= price;
            }
            else {
                System.out.println("The customer does not have enough balance to pay for renting the bicycle");
            }
            // Add the total travelled distance in kilometers to the total travelled distance of the bicycle
            bicycle.addTravelledKilometers(travelledDistance);
        }
    }
}
