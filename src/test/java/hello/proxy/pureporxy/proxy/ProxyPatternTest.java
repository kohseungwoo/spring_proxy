package hello.proxy.pureporxy.proxy;

import org.junit.jupiter.api.Test;

import hello.proxy.pureporxy.proxy.code.CacheProxy;
import hello.proxy.pureporxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureporxy.proxy.code.RealSubject;

public class ProxyPatternTest {
    
    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

       client.execute(); 
       client.execute(); 
       client.execute(); 
    }

    @Test
    void cachePorxyTest(){
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

       client.execute(); 
       client.execute(); 
       client.execute(); 
    }
}
