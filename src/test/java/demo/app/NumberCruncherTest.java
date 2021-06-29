package demo.app;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit testing of the application logic.
public class NumberCruncherTest {
    
    @Test // Default return on route.
    public void doComputeTest() throws Exception {

        // Manually generate input list. 
        // To make this easy, just use a known pythagorean quadruple.
        // https://en.wikipedia.org/wiki/Pythagorean_quadruple
        List<Double> data = Arrays.asList(2D, 4D, 7D, 8D, 11D, 16D); // Want the three largest numbers to be (8, 11, 16).

        // Expected output for (8, 11, 16) should be 21 exactly.
        Double expected = 21D;

        // Call function and evaluate.
        NumberCruncher app = new NumberCruncher();
        Double result = app.doCompute(data);
        assertEquals(result, expected);

    }

    // Ommitted numerous other cases we probably want to test: 
    //  - handling duplicate numbers
    //  - negative numbers
    //  - non-integers

}
