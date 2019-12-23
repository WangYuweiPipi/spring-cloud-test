package spring.cloud.eureka.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.eureka.feign.feign.TestFeign;

import javax.annotation.Resource;

/**
 * @author pipi
 */
@RestController
public class TestController {

    @Resource
    private TestFeign testFeign;

    @GetMapping("/hello")
    public String hello() {
        return testFeign.hello();
    }
}
