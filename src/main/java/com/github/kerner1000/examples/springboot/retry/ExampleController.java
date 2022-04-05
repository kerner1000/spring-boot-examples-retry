package com.github.kerner1000.examples.springboot.retry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("example")
@RestController
public class ExampleController {

    private final ExampleService service;

    public ExampleController(ExampleService service) {
        this.service = service;
    }

    @GetMapping(value="hello", produces = "application/json")
    public String exampleEndpoint() throws Exception {
        service.retryMethod();
        return "this is the end";
    }
}
