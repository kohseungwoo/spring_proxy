package hello.proxy.pureporxy.concreateproxy;

import org.junit.jupiter.api.Test;

import hello.proxy.pureporxy.concreateproxy.code.ConcreateClient;
import hello.proxy.pureporxy.concreateproxy.code.ConcreateLogic;
import hello.proxy.pureporxy.concreateproxy.code.TimeProxy;

public class ConcreateProxyTest {
    
    @Test
    void noProxy(){
        ConcreateLogic concreateLogic = new ConcreateLogic();
        ConcreateClient client = new ConcreateClient(concreateLogic);
        client.execute();
    }

    @Test
    void proxy(){
        ConcreateLogic concreateLogic = new ConcreateLogic();
        TimeProxy timeProxy = new TimeProxy(concreateLogic);
        ConcreateClient client = new ConcreateClient(timeProxy);
        client.execute();
    }
}
