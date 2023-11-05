package bikeRental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Company company;
    private Customer anton;
    private Customer andrea;
    private ElectricBike electricBike;
    private MountainBike mountainBike;

    @BeforeEach
    void setUp() {
        company = new Company("Erazer");
        anton =  new Customer("Anton", 70.54);
        andrea = new Customer("Andrea", 80.12);
        electricBike = new ElectricBike();
        mountainBike = new MountainBike();
    }

    @Test
    void rentBicycle() {
        company.addBicycle(electricBike);
        company.addBicycle(mountainBike);
        assertFalse(company.getRentedBicycles().containsValue(anton), "The borrowed state of the bike is incorrect");
        assertFalse(company.getRentedBicycles().containsKey(electricBike), "The borrowed state of the bike is incorrect");
        assertTrue(company.getBicycles().contains(mountainBike), "Company does not contain the bicycle");
        company.removeBicycle(mountainBike);
        anton.rentBicycle(mountainBike, company);
        assertFalse(company.getRentedBicycles().containsKey(mountainBike), "Company should not have this bicycle");
        anton.rentBicycle(electricBike, company);
        assertTrue(company.getRentedBicycles().containsValue(anton), "Bicycle should currently be borrowed by the customer");
        assertEquals(50.54, anton.getBalance(), 0.01, "Balance is incorrect");
        andrea.rentBicycle(electricBike, company);
        assertFalse(company.getRentedBicycles().containsValue(andrea), "Bicycle should not currently be borrowed by the customer");
    }

    @Test
    void handBicycleIn() {
        company.addBicycle(electricBike);
        anton.rentBicycle(electricBike, company);
        assertTrue(company.getRentedBicycles().containsValue(anton), "Bicycle should currently be borrowed by the customer");
        anton.handBicycleIn(2, 25, electricBike, company);
        assertEquals(54.04, anton.getBalance(), 0.01, "Balance is incorrect");
        assertFalse(company.getRentedBicycles().containsKey(electricBike), "List still contains the bicycle");
        assertFalse(company.getRentedBicycles().containsValue(anton), "List still contains the customer");
    }
}