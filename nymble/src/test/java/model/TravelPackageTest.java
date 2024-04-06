package model;

import com.harshanandsingh.nymble.model.TravelPackage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackageTest {
    @Test
    public void testTravelPackage() {
        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setName("Test Package");
        assertEquals("Test Package", travelPackage.getName());
    }
}