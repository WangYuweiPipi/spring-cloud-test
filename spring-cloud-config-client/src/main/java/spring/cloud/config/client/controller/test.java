package spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @Value("${user.dev}")
    String name;

    @GetMapping("/test")
    public String hello() {
        return this.name;
    }
}
