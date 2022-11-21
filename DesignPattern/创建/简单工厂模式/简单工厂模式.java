package 创建.简单工厂模式;

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

interface AbsFactory {
    Operation createOperate(String operate, double numberA, double numberB);
}

class Factory implements AbsFactory {
    public Operation createOperate(String operate, double numberA, double numberB) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new PlusOperation(numberA, numberB);
                break;
            case "-":
                operation = new MinusOperation(numberA, numberB);
                break;
        }
        return operation;
    }
}

public class 简单工厂模式 {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Operation operation = factory.createOperate("+", 100, 50);
        operation.getResult();
        operation = factory.createOperate("-", 100, 50);
        operation.getResult();
    }
}
