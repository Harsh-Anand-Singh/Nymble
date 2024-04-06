package model;

import com.harshanandsingh.nymble.model.Activity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest {
    @Test
    public void testActivity() {
        Activity activity = new Activity();
        activity.setName("Test Activity");
        assertEquals("Test Activity", activity.getName());

    }
}