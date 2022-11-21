package 行为.迭代器模式;

import java.util.*;

abstract class Iterator {
    public abstract Object first();

    public abstract Object next();

    public abstract boolean isDone();
}

abstract class Aggregate {
    public abstract Iterator createIterator();
}

class ConcreteAggregate extends Aggregate {
    List<Object> items = new ArrayList<>();

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count() {
        return items.size();
    }

    public Object get(int index) {
        return items.get(index);
    }

    public void add(Object item) {
        this.items.add(item);
    }
}

class ConcreteIterator extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    public Object first() {
        return aggregate.get(0);
    }

    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.count()) {
            return aggregate.get(current);
        }
        return ret;
    }

    public boolean isDone() {
        return current >= aggregate.count() ? true : false;
    }
}

public class 迭代器模式 {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.add("XXX");

        Iterator iterator = new ConcreteIterator(a);
        Object object = iterator.first();
    }
}