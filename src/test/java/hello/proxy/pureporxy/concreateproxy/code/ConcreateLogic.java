package hello.proxy.pureporxy.concreateproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreateLogic {
    
    public String operation(){
        log.info("ConcreateLogic 실행");
        return "data";
    }
}
