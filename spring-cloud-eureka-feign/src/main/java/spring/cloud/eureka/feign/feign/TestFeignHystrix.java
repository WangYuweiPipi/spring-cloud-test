package spring.cloud.eureka.feign.feign;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @author pipi
 * 熔断机制
 */
@Component
public class TestFeignHystrix implements TestFeign {

    @Override
    @HystrixCommand(fallbackMethod = "")
    public String hello() {
        return "This is a eureka feign hystrix for hello method and port is 8002";
    }
}
