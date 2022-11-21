package 行为.观察者模式;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

abstract class Subject {
    List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void inform() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}

class ConcreteSubject extends Subject {
    String state;

    public ConcreteSubject(String state) {
        super();
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class ConcreteObserver implements Observer {
    String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(name + ">>收到消息");
    }
}

public class 观察者模式 {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject("normal");
        ConcreteObserver observer1 = new ConcreteObserver("observer-1");
        ConcreteObserver observer2 = new ConcreteObserver("observer-2");
        subject.attach(observer1);
        subject.attach(observer2);
        subject.inform();
        subject.setState("modify");
        subject.inform();
    }
}