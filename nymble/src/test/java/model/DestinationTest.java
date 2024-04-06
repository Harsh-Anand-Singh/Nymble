package model;

import com.harshanandsingh.nymble.model.Destination;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationTest {
    @Test
    public void testDestination() {
        Destination destination = new Destination();
        destination.setName("Test Destination");
        assertEquals("Test Destination", destination.getName());

    }
}