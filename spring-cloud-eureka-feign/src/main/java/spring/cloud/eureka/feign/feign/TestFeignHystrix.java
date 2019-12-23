package spring.cloud.eureka.feign.feign;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @author pipi
 */
@Component
public class TestFeignHystrix implements TestFeign {

    @Override
    @HystrixCommand(fallbackMethod = "")
    public String hello() {
        return "This is a hystrix for hello method";
    }
}
