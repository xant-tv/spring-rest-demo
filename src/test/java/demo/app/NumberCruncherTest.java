package demo.app;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit testing of the application logic.
public class NumberCruncherTest {
    
    @Test
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

    @Test
    public void doComputeTestWithDuplicates() throws Exception {

        // Similar input list to before but this time a quadruple with duplicate numbers.
        // Expected behaviour is that this will evaluate to (6, 6, 17).
        List<Double> data = Arrays.asList(4D, 6D, 6D, 6D, 17D);

        // Output for (6, 6, 17) should be 19 exactly.
        Double expected = 19D;

        // Call function and evaluate.
        NumberCruncher app = new NumberCruncher();
        Double result = app.doCompute(data);
        assertEquals(result, expected);

    }

    @Test
    public void doComputeTestWithNegatives() throws Exception {

        // Another input list, this time with negative numbers that have higher absolute values.
        // Expectation is that these numbers will be ignored resolving to (8, 11, 16) quadruple again.
        List<Double> data = Arrays.asList(-15D, 7D, 8D, 11D, 16D, -27D);

        // Expected output for (8, 11, 16) should be 21 exactly.
        Double expected = 21D;

        // Call function and evaluate.
        NumberCruncher app = new NumberCruncher();
        Double result = app.doCompute(data);
        assertEquals(result, expected);
        
    }

    // Probably a bunch more test cases we could evaluate here but this should be sufficient for this demonstration.

}
