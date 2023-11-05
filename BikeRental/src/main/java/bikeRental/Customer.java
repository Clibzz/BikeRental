package bikeRental;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rentBicycle(Bicycle bicycle, Company company) throws BicycleBorrowedException{
        if (company.getBicycles().contains(bicycle)) {
            if (!company.getRentedBicycles().containsKey(bicycle)) {
                company.addRentedBicycle(bicycle, this);
                //Pay 20$
            } else {
                throw new BicycleBorrowedException();
            }
        } else {
            System.out.println("The company currently doesn't own the selected bicycle, please try again!");
        }
    }

    public void handBicycleIn(int travelledDistance, Bicycle bicycle) {
        double price = 0;
        Company company = new Company();
        if (company.getRentedBicycles().containsKey(bicycle))

    }


    //Rent bicycle

    //Hand in bicycle + pay

}
