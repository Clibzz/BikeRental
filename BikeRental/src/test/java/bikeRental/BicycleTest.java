package bikeRental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicycleTest {
    private Company company;
    private NormalBike normalBike;
    private Customer peter;
    private Customer pedro;

    @BeforeEach
    void setUp() {
        company = new Company("Erazer");
        normalBike = new NormalBike();
        peter = new Customer("Peter", 75.69);
        pedro = new Customer("Pedro", 100.00);
    }
    @Test
    void getTravelledKilometers() {
        company.addBicycle(normalBike);
        peter.rentBicycle(normalBike, company);
        assertEquals(0, normalBike.getTravelledKilometers(), "Distance is incorrect");
        peter.handBicycleIn(7, 104, normalBike, company);
        assertEquals(104, normalBike.getTravelledKilometers(), "Distance is incorrect");
        peter.rentBicycle(normalBike, company);
        peter.handBicycleIn(3, 52, normalBike, company);
        assertEquals(156, normalBike.getTravelledKilometers(), "Distance is incorrect");
        pedro.rentBicycle(normalBike, company);
        pedro.handBicycleIn(16, 200, normalBike, company);
        assertEquals(356, normalBike.getTravelledKilometers(), "Distance is incorrect");
    }
}