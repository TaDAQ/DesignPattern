package 行为.责任链模式;

abstract class Handler {
    Handler handler;

    public void setHandler(Handler nextHandler) {
        handler = nextHandler;
    }

    abstract void handleRequest(int requet);
}

class ConcreteHandler1 extends Handler {
    void handleRequest(int requet) {
        if (requet > 0 && requet < 10) {

        } else if (handler != null) {
            handler.handleRequest(requet);
        }
    }
}

class ConcreteHandler2 extends Handler {
    void handleRequest(int requet) {
        if (requet > 10 && requet < 100) {

        } else if (handler != null) {
            handler.handleRequest(requet);
        }
    }
}

public class 责任链模式 {
    public static void main(String[] args) {

        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setHandler(h2);
        int request = 10;
        h1.handleRequest(request);

    }
}
