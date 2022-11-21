package 行为.中介者模式;

abstract class Colleague {
    Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String msg) {
        mediator.send(msg, this);
    }

    abstract void response(String msg);

}

interface Mediator {
    void send(String msg, Colleague colleague);
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void response(String msg) {
        System.out.println("同事1收到消息:" + msg);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void response(String msg) {
        System.out.println("同事2收到消息:" + msg);
    }
}

class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setConcreteColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setConcreteColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void send(String msg, Colleague colleague) {
        if (colleague1 == colleague) {
            colleague2.response(msg);
        } else if (colleague2 == colleague) {
            colleague1.response(msg);
        }
    }

}
public class 中介者模式  {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(m);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(m);
        m.setConcreteColleague2(colleague2);
        m.setConcreteColleague1(colleague1);
        colleague1.send("你好");

    }
}