package demo.app;

import java.util.Comparator;
import java.util.List;

public class NumberCruncher {
    
    // Class constructor.
    public NumberCruncher() {
        // Empty constructor.
    }
    
    /**
     * Accepts an array of numeric inputs and performs the following:
     *  - Retains the largest 3 numbers within the array.
     *  - Computes the square root of the sum of the squares of the retained values.
     * This is all done using Java Streams.
     * @param data The input <code>List<Double></code> of values.
     * @return Returns the <code>Double</code> calculation result.
     */
    public Double doCompute(List<Double> data) {
        Double result = Math.sqrt(
            data.stream()
                .sorted(Comparator.reverseOrder()) // Sort numbers in descending order (largest to smallest)
                .limit(3) // Limit the stream to three numbers - effectively now the three largest.
                .mapToDouble(n -> Math.pow(n, 2)) // Calculate the square of each number.
                .sum() // Returns the sum of squares as a primitive.
        );
        return result;
    }

}
