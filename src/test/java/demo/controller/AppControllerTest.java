package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import demo.app.NumberCruncher;
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
    public void postInputCustom() throws Exception {

        // Randomly generate five numbers to create the input list.
        List<Double> data = new ArrayList<Double>();
        for(Integer i = 0; i < 5; i++) {
            // Restrict numbers to integers between 0 and 9.
            data.add(Double.valueOf(Math.random() % 10));
        }
        InputTemplate body = new InputTemplate(data);

        // Use the normal application function to compute the result.
        // This function has separate unit tests outside of this file.
        NumberCruncher app = new NumberCruncher();
        Double result = app.doCompute(data);
        OutputTemplate expected = new OutputTemplate(result);

        // Hit the endpoint.
        String url = "http://localhost:" + port + "/input";
        ResponseEntity<OutputTemplate> response = this.restTemplate.postForEntity(url, body, OutputTemplate.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getOutput()).isEqualTo(expected.getOutput());

    }

    // Could write a bunch more test cases for expected failure conditions, etc.
}