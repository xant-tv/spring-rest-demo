package demo.rest;

import java.util.Arrays;
import java.util.List;

/**
 * Skeleton for input JSON.
 * Class properties will be present as keys.
 * @param input <code>List<Double></code> of numbers to process.
 */
public class InputTemplate {
    
    // Internal properties.
    private final List<Double> data;

    // Class constructors.
    public InputTemplate() {
        this.data = Arrays.asList(0D);
    }

    public InputTemplate(List<Double> data) {
        this.data = data;
    }

    // Getter functions.
    public List<Double> getData() {
        return data;
    }

}
