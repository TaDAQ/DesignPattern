package 行为.策略模式;

interface Strategy {
    void algorithmInterface();
}

class ConcreteStrategyA implements Strategy {
    public void algorithmInterface() {
        System.out.println("算法A实现");
    }
}

class ConcreteStrategyB implements Strategy {
    public void algorithmInterface() {
        System.out.println("算法B实现");
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        this.strategy.algorithmInterface();
    }
}

public class 策略模式 {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

    }
}