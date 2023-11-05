package bikeRental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private ElectricBike electricBike;
    private MountainBike mountainBike;
    private NormalBike normalBike;
    private Customer peter;

    @BeforeEach
    void setUp() {
        company = new Company();
        electricBike = new ElectricBike();
        mountainBike = new MountainBike();
        normalBike = new NormalBike();
        peter = new Customer("Peter", 75.69);
    }
    @Test
    void getTotalTravelledKilometers() {
        company.addBicycle(electricBike);
        assertEquals(0, company.getTotalTravelledKilometers(), "Can't currently get the total travelled kilometers");
        electricBike.addTravelledKilometers(20);
        assertEquals(20, company.getTotalTravelledKilometers(), "Can't currently get the total travelled kilometers");
        mountainBike.addTravelledKilometers(5);
        assertEquals(20, company.getTotalTravelledKilometers(), "Can't currently get the total travelled kilometers");
        company.addBicycle(mountainBike);
        assertEquals(25, company.getTotalTravelledKilometers(), "Can't currently get the total travelled kilometers");
    }

    @Test
    void checkAvailableBicyclesAmount() {
        assertEquals(0, company.checkAvailableBicyclesAmount(), "Amount is incorrect");
        company.addBicycle(mountainBike);
        assertEquals(1, company.checkAvailableBicyclesAmount(), "Amount is incorrect");
        company.addBicycle(electricBike);
        company.addBicycle(normalBike);
        assertEquals(3, company.checkAvailableBicyclesAmount(), "Amount is incorrect");
        company.removeBicycle(normalBike);
        assertEquals(2, company.checkAvailableBicyclesAmount(), "Amount is incorrect");
        peter.rentBicycle(electricBike, company);
        assertEquals(1, company.checkAvailableBicyclesAmount(), "Amount is incorrect");
    }
}