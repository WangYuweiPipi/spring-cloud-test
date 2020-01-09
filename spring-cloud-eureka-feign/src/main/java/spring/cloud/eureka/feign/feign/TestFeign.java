package spring.cloud.eureka.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pipi
 */
@FeignClient(name = "eureka-client", /*fallback = TestFeignHystrix.class,*/ fallbackFactory = TestFeignFallbackFactory.class)
public interface TestFeign {

    /**
     * 获取spring-cloud-eureka-client模块,TestController类里的test方法内容
     *
     * @return
     */
    @RequestMapping("/test")
    String hello();
}
