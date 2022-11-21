package 创建.工厂模式;

abstract class Operation {
    public abstract double getResult();

    public Operation(double numA, double numB) {
        this.numberA = numA;
        this.numberB = numB;
    }

    public double numberA;
    public double numberB;
}

// 加法类
class PlusOperation extends Operation {
    public PlusOperation(double numA, double numB) {
        super(numA, numB);
    }

    public double getResult() {
        return numberA + numberB;
    }
}

// 减法类
class MinusOperation extends Operation {
    public MinusOperation(double numA, double numB) {
        super(numA, numB);
    }

    public double getResult() {
        return numberA - numberB;
    }
}

interface Factory {
    Operation createOperate(double numberA, double numberB);
}

class PlusFactory implements Factory {
    public Operation createOperate(double numberA, double numberB) {
        return new PlusOperation(numberA, numberB);
    }
}

class MinusFactory implements Factory {
    public Operation createOperate(double numberA, double numberB) {
        return new MinusOperation(numberA, numberB);
    }
}

class Client {
    public static void main(String[] args) {

        Factory factory = new PlusFactory();
        Operation operation = factory.createOperate(100, 50);
        operation.getResult();

        factory = new MinusFactory();
        operation = factory.createOperate(100, 50);
        operation.getResult();

    }
}
