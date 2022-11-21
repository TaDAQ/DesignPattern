package 行为.模板模式;

abstract class AbstractClass {
    public abstract void operation();

    public void templateMethod() {
        System.out.print("templateMethod");
        operation();
    }
}

class ConcreteClass extends AbstractClass {
    public void operation() {
        System.out.print("子类实现方案1");
    }
}

class Client {
    public static void main(String[] args) {
        AbstractClass c = new ConcreteClass();
        c.templateMethod();
    }
}