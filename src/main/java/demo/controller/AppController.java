package demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.app.NumberCruncher;
import demo.rest.InputTemplate;
import demo.rest.OutputTemplate;

@SpringBootApplication
@RestController
public class AppController {

    // Initialise class elements.
    private static NumberCruncher app = new NumberCruncher();

    // Entrypoint main.
    public static void main(String[] args) {
        SpringApplication.run(AppController.class, args);
    }

    // Specify routes.
    @PostMapping("/input")
    @ResponseBody
    public OutputTemplate postInput(@RequestBody InputTemplate input) {
        Double result = app.doCompute(input.getData());
        return new OutputTemplate(result);
    }
}