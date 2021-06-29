package demo.rest;

/**
 * Skeleton for output JSON.
 * Class properties will be present as keys.
 * @param data Result output.
 */
public class OutputTemplate {
    
    // Internal properties.
    private final Double output;

    // Class constructors.
    public OutputTemplate() {
        this.output = 0D;
    }

    public OutputTemplate(Double output) {
        this.output = output;
    }

    // Getter functions.
    public Double getOutput() {
        return output;
    }

}
