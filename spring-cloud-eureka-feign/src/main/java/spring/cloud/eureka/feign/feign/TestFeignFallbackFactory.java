package spring.cloud.eureka.feign.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author pipi
 * 熔断机制：可在日志中打印发生熔断的异常信息
 */
@Component
public class TestFeignFallbackFactory implements FallbackFactory<TestFeign> {

    private Logger log = LoggerFactory.getLogger(TestFeignFallbackFactory.class);

    @Override
    public TestFeign create(Throwable e) {

        log.error("TestFeign error message -> ", e);

        return new TestFeign() {
            @Override
            public String hello() {
                return "This is a eureka feign hystrix Factory for hello method and port is 8002";
            }
        };
    }
}
