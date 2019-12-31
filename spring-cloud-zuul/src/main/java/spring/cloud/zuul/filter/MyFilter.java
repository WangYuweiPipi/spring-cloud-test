package spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * filter类型
     *
     * 'pre': 在请求被路由之前执行。可以实现身份验证、在集群中选择请求的微服务、记录调试信息等
     * 'routing: 将请求路由到微服务时执行。用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务
     * 'post': 在请求路由到微服务后执行。可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等
     * 'error': 其他阶段发生错误时执行。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 优先级，数字越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行此filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体操作
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        // 获取请求的参数
        String token = request.getParameter("token");

        if (token != null && !token.isEmpty()) {
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
