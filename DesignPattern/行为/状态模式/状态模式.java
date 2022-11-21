package 行为.状态模式;

class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }

}

interface State {
    void handle(Context context);
}

class ConcreteState implements State {
    public void handle(Context context) {
        System.out.println("当前状态是" + this.getClass().getSimpleName());
    }
}

class ConcreteState1 implements State {
    public void handle(Context context) {
        System.out.println("当前状态是" + this.getClass().getSimpleName());
    }
}

public class 状态模式 {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteState());
        context.request();
        context.setState(new ConcreteState1());
        context.request();
    }
}