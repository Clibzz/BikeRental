package bikeRental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private ElectricBike electricBike;
    private MountainBike mountainBike;

    @BeforeEach
    void setUp() {
        company = new Company();
        electricBike = new ElectricBike();
        mountainBike = new MountainBike();
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
}