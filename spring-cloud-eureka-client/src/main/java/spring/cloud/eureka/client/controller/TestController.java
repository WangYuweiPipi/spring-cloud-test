package spring.cloud.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pipi
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "This is a eureka client";
    }
}
