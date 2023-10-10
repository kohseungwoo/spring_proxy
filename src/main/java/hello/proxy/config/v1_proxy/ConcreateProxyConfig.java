package hello.proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v1_proxy.concreate_proxy.OrderControllerConcreateProxy;
import hello.proxy.config.v1_proxy.concreate_proxy.OrderRepositoryConcreateProxy;
import hello.proxy.config.v1_proxy.concreate_proxy.OrderServiceConcreateProxy;
import hello.proxy.trace.logtrace.LogTrace;

@Configuration
public class ConcreateProxyConfig {
    
    @Bean
    public OrderControllerConcreateProxy orderControllerConcreateProxy(LogTrace logTrace){
        OrderControllerV2 controllerImple = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreateProxy(controllerImple, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace){
        OrderServiceV2 serivceImple = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreateProxy(serivceImple, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace){
        OrderRepositoryV2 repositroyImple = new OrderRepositoryV2();
        return new OrderRepositoryConcreateProxy(repositroyImple, logTrace);
    }
}
