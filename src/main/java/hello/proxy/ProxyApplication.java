package hello.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import hello.proxy.config.v1_proxy.ConcreateProxyConfig;
import hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;

// @Import(AppV1Config.class)
// @Import({AppV1Config.class, AppV2Config.class}) // AppV3config 가 추가, 등록이 되지 않은 이유는 @RestController로 인하여 스프링 빈에 자동 등록이 되었기에 
// @Import(InterfaceProxyConfig.class)
@Import(ConcreateProxyConfig.class)
//수동적으로 import하여 등록할필요가 없다. 
@SpringBootApplication(scanBasePackages = "hello.proxy.app")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean 
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}

}
