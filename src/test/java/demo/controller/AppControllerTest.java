package demo.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import demo.rest.InputTemplate;
import demo.rest.OutputTemplate;

import org.springframework.http.HttpStatus;

// Effectively integration testing of the whole API.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test // Default return on route.
    public void postInputDefault() throws Exception {

        // Set up expected inputs and outputs.
        InputTemplate body = new InputTemplate();
        OutputTemplate expected = new OutputTemplate();

        // Hit the endpoint.
        String url = "http://localhost:" + port + "/input";
        ResponseEntity<OutputTemplate> response = this.restTemplate.postForEntity(url, body, OutputTemplate.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getOutput()).isEqualTo(expected.getOutput());

    }

    @Test // Functional return on route.
    public void postInputActual() throws Exception {

        // Use the same six numbers to create the input list.
        List<Double> data = Arrays.asList(2D, 4D, 7D, 8D, 11D, 16D);
        InputTemplate body = new InputTemplate(data);

        // Prepare expected result.
        Double result = 21D;
        OutputTemplate expected = new OutputTemplate(result);

        // Hit the endpoint.
        String url = "http://localhost:" + port + "/input";
        ResponseEntity<OutputTemplate> response = this.restTemplate.postForEntity(url, body, OutputTemplate.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getOutput()).isEqualTo(expected.getOutput());

    }

    // Could write a bunch more test cases for expected failure conditions:
    //  - when incorrect or no body is provided (expect fail)
    //  - when non-integer inputs are provided (expect fail)
    //  - may want a /ping or /health route in the future too

}