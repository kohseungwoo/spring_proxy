package hello.proxy.pureporxy.concreateproxy.code;

public class ConcreateClient {
    private ConcreateLogic concreateLogic;

    public ConcreateClient(ConcreateLogic concreateLogic) {
        this.concreateLogic = concreateLogic;
    }
    
    public void execute(){
        concreateLogic.operation();
    }
}
