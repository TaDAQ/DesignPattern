# DesignPattern
设计模式实践指南
使用Java语言实现经典设计模式
[Design Pattern.pdf](https://github.com/TaDAQ/DesignPattern/files/10055924/Design.Pattern.pdf)
设计模式是在特定环境下人们解决某类重复出现问题的一套成功或有效的解决方案
1. 创建型模式
        提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象。这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活；根据创建的不同方式，划分为简单工厂模式，工厂模式，抽象工厂模式，原型模式，单例模式，建造者模式。创建型模式重点强调对象的创建。
暂时无法在飞书文档外展示此内容
1.1简单工厂
结构图
- 简易图
暂时无法在飞书文档外展示此内容
示例代码
[图片]
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

class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Operation operation = factory.createOperate("+", 100, 50);
        operation.getResult();
        operation = factory.createOperate("-", 100, 50);
        operation.getResult();
    }
}
使用场景
1.三方数据接入
2.三方登录
1.2工厂模式
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
[图片]
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
使用场景
1.加速对象创建过程，隐藏创建细节，规范对象创建行为
2.SDK初始化场景，自动采集优化
1.3抽象工厂
抽象工厂模式（Abstract Factory），提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
interface Computer {
    void powerOn();

    void powerOff();
}

interface Phone {
    void call();
}

class HuaweiComputer implements Computer {
    @Override
    public void powerOn() {
        System.out.println("HuaweiDesktopComputer power on");
    }

    @Override
    public void powerOff() {
        System.out.println("HuaweiDesktopComputer power off");
    }
}

class HuaweiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("使用华为手机打电话");
    }

}

class XiaomiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("使用小米手机打电话");
    }

}

class XiaomiComputer implements Computer {
    @Override
    public void powerOn() {
        System.out.println("XMDesktopComputer power on");
    }

    @Override
    public void powerOff() {
        System.out.println("XMDesktopComputer power off");
    }
}

abstract class Factory {

    public abstract Computer createComputer();

    public abstract Phone createPhone();

}

class HuaweiFactory extends Factory {

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

}

class XiaomiFactory extends Factory {

    @Override
    public Computer createComputer() {
        return new XiaomiComputer();
    }

    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

}

class Client {
    public static void main(String[] args) {
        Factory factory = new HuaweiFactory();
        Computer computer = factory.createComputer();
        computer.powerOn();
        computer.powerOff();
        Phone phone = factory.createPhone();
        phone.call();
    }
}
使用场景
1.4原型模式
原型模式（Prototype），用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
结构图
- 详细图
[图片]
示例代码
 class Person implements Cloneable {
    private String name;
    private String sex;
    private Integer age;
    public Person friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() {
        Person person= null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }
}

class Client {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("www");

        Person newPerson = (Person) person.clone();
        System.out.println("newPerson name = " + newPerson.getName());
    }
}
使用场景
1.SDK创建过程
2.数据备份
1.5单例模式
单例模式（Singleton），保证一个类仅有一个实例，并提供一个访问它的全局访问点
结构图
[图片]
示例代码
class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void printLog() {

    }
}
class Client {
    public static void main(String[] args) {
        Singleton.getInstance().printLog();
    }
}
使用场景

1.工具类（文件，网络请求。。）
2.SDK封装
1.6建造者模式
建造者模式（Builder），将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
结构图
[图片]
示例代码
package 创建.建造者模式;
class Person
{
    public void setHead(String head) {
        this.head = head;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    String head;
    String foot;
    String name;
    public Person(String name)
    {
        this.name = name;
    }
    public void print()
    {
        System.out.println("姓名："+name+"  头:"+head+"  脚:"+foot);
    }
}
abstract class Builder
{
    public Person getPerson() {
        return person;
    }
    Person person;
    public Builder(String name)
    {
        person = new Person(name);
    }
    abstract  void buildHead();
    abstract  void buildFoot();
}
class PersonBuilder extends    Builder
{
    public PersonBuilder(String name) {
        super(name);
    }
    @Override
    public void buildHead() {
        getPerson().setHead("大头");
    }
    @Override
    public void buildFoot() {
        getPerson().setFoot("大脚");
    }
}
class Director
{
    public void build(Builder builder)
    {
        builder.buildHead();
        builder.buildFoot();
    }
}
public class 建造者模式 {
    public static void main(String[] args)
    {
        Director director = new Director();
        PersonBuilder builder = new PersonBuilder("超人");
        director.build(builder);
        builder.getPerson().print();
    }
}
使用场景
2. 结构型模式
        描述如何将类或者对象结合在一起形成更大的结构，就像搭积木， 可以通过简单积木的组合形成复杂的、功能更为强大的结构。结构型模式可以分为类结构型模式和对象结构型模式，也可分为代理模式（Proxy）、适配器模式（Adapter）、桥接模式（Bridge）、装饰模式 （Decorator ）、外观模式（Facade）、享元模式（Flyweight）和组合模式（Composite）等 7 类。结构型模式强调类结构的扩展。
暂时无法在飞书文档外展示此内容
2.1 代理模式
代理模式（Proxy），为其他对象提供一种代理以控制对这个对象的访问。[DP]
结构图
[图片]
示例代码
package 结构.代理模式;

interface Subject
{
    public void request();
}
class RealSubject implements  Subject
{
    @Override
    public void request() {
        System.out.println("真實請求");
    }
}
class Proxy implements Subject
{
    Subject subject;
    @Override
    public void request() {
        if(subject == null)
        {
            subject = new RealSubject();
        }
        subject.request();
    }

}

public class 代理模式 {
    public  static void main(String args[])
    {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
使用场景

2.2 适配器模式
适配器模式（Adapter），将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。[DP]
结构图
[图片]
示例代码
package 结构.适配器模式;

class Target
{
    public void request()
    {
        System.out.println("普通请求");
    }
}
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("特殊请求");
    }
}
class  Adapter extends Target
{
    Adaptee adaptee = new Adaptee();
    public void request()
    {
        adaptee.specificRequest();
    }
}
public class 适配器模式 {
    public static void main(String[] args){
        Target target = new Adapter();
        target.request();
    }
}
使用场景
2.3 桥接模式
桥接模式（Bridge），将抽象部分与它的实现部分分离，使它们都可以独立地变化。[DP]
结构图
[图片]
示例代码
package 结构.桥接模式;

interface Operator
{
    void operate();
}
class Model
{
    Operator operator;
    public void setOperator(Operator operator)
    {
        this.operator = operator;
    }
    public void show()
    {
        System.out.println("开始操作拉");
        operator.operate();
    }
}
class  ConcreteOperator implements  Operator
{

    @Override
    public void operate() {
        System.out.println("A步骤开始实施");
    }
}
class  ConcreteOperator1 implements  Operator
{

    @Override
    public void operate() {
        System.out.println("B步骤开始实施");
    }
}
public class 桥接模式 {
    public static void main(String[] args){
        Model model = new Model();
        model.setOperator(new ConcreteOperator());
        model.show();
        model.setOperator(new ConcreteOperator1());
        model.show();
    }
}
使用场景
2.4 装饰模式
动态的给一个对象添加一些额外的职责。
就扩展功能来说，装饰模式相比生成子类更加灵活。
结构图
[图片]
示例代码
package 结构.装饰模式;

interface IThirdParty {
    String sayMsg();
}
class ThirdParty implements IThirdParty {
    public String sayMsg() {
        return "hello";
    }
}
class Decorator1 implements IThirdParty {
    private IThirdParty thirdParty;
    public Decorator1(IThirdParty thirdParty){
        this.thirdParty= thirdParty;
    }
    public String sayMsg(){
        return "##1"+ thirdParty.sayMsg() + "##1";
    }
}
class Decorator2 implements IThirdParty {
    private IThirdParty thirdParty;
    public Decorator2(IThirdParty thirdParty){
        this.thirdParty= thirdParty;
    }
    public String sayMsg(){
        return "##2"+ thirdParty.sayMsg() + "##2";
    }
}
public class 装饰模式 {
    public static void main(String[] args)
    {
        IThirdParty thirdPartyOne =new ThirdParty();
        IThirdParty decorator1 =new Decorator1(thirdPartyOne);
        IThirdParty decorator2 =new Decorator2(decorator1);
        System.out.println(decorator2.sayMsg());
    }
}
使用场景
2.5 外观模式
外观模式（Facade），为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
结构图
[图片]
示例代码
package 结构.外观模式;

class SystemOne
{
    public void methodA()
    {
        System.out.println("System One Work");
    }
}
class SystemTwo
{
    public void methodB()
    {
        System.out.println("System Two Work");
    }
}
class Facade
{
    SystemOne systemOne;
    SystemTwo systemTwo;
    public Facade(){
        systemOne = new SystemOne();
        systemTwo = new SystemTwo();
    }
    public void methodA()
    {
        System.out.println("A系统开始工作");
        systemOne.methodA();
    }
    public void methodB()
    {
        System.out.println("A系统开始工作");
        systemTwo.methodB();
    }

}
public class 外观模式 {
    public static void main(String[] args)
    {
        Facade facade = new Facade();
        facade.methodA();
    }

}
使用场景
SDK对外接口
2.6 享元模式
利用共享技术有效的支持大量细粒度的对象。
结构图
[图片]
示例代码
package 结构.享元模式;

import java.util.HashMap;

abstract class Fly
{
    String name;
    abstract  void operation(int state);
}
class ConcreteFly extends Fly
{
    public ConcreteFly(String name)
    {
        this.name = name;
    }
    @Override
    public void operation(int state) {
        System.out.println(name+" 飞起来了，当前状态"+state);
    }
}
class FlyFactory
{
    private static  HashMap flys = new HashMap<String,Fly>(){{
        put("a",new ConcreteFly("大飞机"));
        put("b",new ConcreteFly("小飞机"));
    }};
    public static Fly getFly(String key)
    {
        return (Fly) flys.get(key);
    }
}
public class 享元模式 {
    public static void main(String[] args)
    {
        Fly fly = FlyFactory.getFly("a");
        fly.operation(100);
    }
}
使用场景
2.7 组合模式
组合模式（Composite），将对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
结构图
[图片]
示例代码
package 结构.组合模式;

import java.util.ArrayList;
import java.util.List;

abstract class Component
{
    String name;
    public Component(String name)
    {
        this.name = name;
    }
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}
class Leaf extends Component
{

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("cannot add a leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(depth+name);
    }
}
class  Composite extends Component
{
    List<Component>  children = new ArrayList<Component>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(depth + name);
        for(Component component:children)
        {
            component.display(depth + 2);
        }
    }


}
public class 组合模式 {
    public static  void main(String[] args)
    {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.display(2);
    }
}
使用场景
3. 行为型模式
       行为型设计模式目的是将多个类或对象相互协作，共同完成单个类或对象无法单独完成的任务。行为型设计模式共11种，分别为解释器模式、模板方法模式、责任链模式、命令模式、迭代器模式、中介者模式、备忘录模式、观察者模式、状态模式、策略模式、访问者模式。行为型模式重点强调是类和类之间的分工以及协作。
暂时无法在飞书文档外展示此内容
单个类和其他类的分工和协作，主要有一对一，一对多两种关系，整个设计模式的分类大多也是基于这种关系进行拆分.
- 一对一
继承关系
单向关系
双向关系
- 一对多
1.一个类和多个类直接协作，一共两个大类
一个类我们命名A类，多个类我们简称B类，主要关系有:
- A类持有B类
- B类中每个类关联A，且关联同类
- B类中每个类关联A
2.一个类和多个类间接协作,一共三个大类
一个类我们命名A类，中间类我们称之为M类，另外一个简称B类，主要关系有:
- M类持有A,B，A,B持有M
- A类持有M，M持有B
3.1 解释器模式
解释器模式（interpreter），给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。[DP]
结构图
[图片]
示例代码
package 行为.解释器模式;

class Context
{
    String name;
    int age;
    public  Context(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
}
interface Expression
{
    void expect(Context context);
}
class AdultExpression implements  Expression
{
    @Override
    public void expect(Context context) {
        if(context.age >= 16)
        {
            System.out.println(context.name+"是一个成年人");
        }
    }
}
class  MinorExpression implements  Expression
{
    @Override
    public void expect(Context context) {
        if(context.age < 16)
        {
            System.out.println(context.name+"是一个未成年人");
        }
    }
}
public class 解释器模式 {
    public static  void main(String[] args)
    {
        Context context = new Context("张三",10);
        AdultExpression adultExpression = new AdultExpression();
        MinorExpression minorExpression = new MinorExpression();
        minorExpression.expect(context);
        adultExpression.expect(context);
    }
}
使用场景
正则表达式
3.2 模板方法模式
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
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
使用场景
3.3 责任链模式
        职责链模式（Chain of Responsibility）：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
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

class Client {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setHandler(h2);
        int request = 10;
        h1.handleRequest(request);

    }
}
使用场景
- SDK属性采集
3.4 命令模式
命令模式（Command），将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
class Receiver {
    public void doAction() {
        System.out.println("执行请求");
    }
}

abstract class Command {
    Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}

class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    public void execute() {
        receiver.doAction();
    }
}

class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
使用场景

3.5 迭代器模式
迭代器模式（Iterator），提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
mport java.util.*;

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

class Client {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.add("XXX");
        Iterator iterator = new ConcreteIterator(a);
        Object object = iterator.first();
    }
}
使用场景
3.6 中介者模式
中介者模式（Mediator），用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
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

class Client {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(m);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(m);
        m.setConcreteColleague2(colleague2);
        m.setConcreteColleague1(colleague1);
        colleague1.send("你好");

    }
}
使用场景
- 路由
3.7 备忘录模式
备忘录（Memento）：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。[DP]
结构图
[图片]
示例代码
package 行为.备忘录模式;
class  Memento
{
    private int state;
    public Memento(int state)
    {
        this.state = state;
    }
    public int getState()
    {
        return  this.state;
    }
}
class Originator
{
    public void setState(int state) {
        this.state = state;
    }

    private  int state;
    public Originator(int state)
    {
        this.state = state;
    }
    public Memento createMemento()
    {
       return new Memento(state);
    }
    public void setMemento(Memento memento)
    {
        state = memento.getState();
    }
    public void show()
    {
        System.out.println("State="+state);
    }
}
class  Caretaker
{
    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    private  Memento memento;

}
public class 备忘录模式 {
   public static void main(String[] args)
   {
       Originator originator = new Originator(100);
       originator.show();
       Caretaker caretaker = new Caretaker();
       caretaker.setMemento(originator.createMemento());
       originator.setState(1000);
       originator.show();
       originator.setMemento(caretaker.getMemento());
       originator.show();
   }
}
使用场景
游戏关卡数据
3.8 观察者模式
观察者模式又叫做发布-订阅（Publish/Subscribe）模式
观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使 它们能够自动更新自己。
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
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

class Client {
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
使用场景
1.内容观察者
2.KVO
3.9 状态模式
状态模式（State），当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码
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

class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteState());
        context.request();
        context.setState(new ConcreteState1());
        context.request();
    }
}
使用场景
3.10 策略模式
策略模式（Strategy）：它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户
结构图
- 简易图
暂时无法在飞书文档外展示此内容
- 详细图
[图片]
示例代码

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

class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

    }
}
使用场景
3.11 访问者模式
访问者模式（Visitor），表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
结构图
[图片]
示例代码
使用场景
4. 六大原则
4.1.单一职责原则（Single Responsibility Principle, SRP）
定义：一个类应只包含单一的职责。
一个类职责过大的话，首先引起的问题就是这个类比较大，显得过于臃肿，同时其复用性是比较差的。
其次就是如果修改某个职责，有可能引起另一个职责发生错误。这是我们极力所避免的，因此设计一个类时我们应当去遵循单一职责原则。
4.2.开放封闭原则(Open - ClosedPrinciple ,OCP)
定义：一个模块、类、函数应当是对修改关闭，扩展开放。
修改原有的代码可能会导致原本正常的功能出现问题。
因此，当需求有变化时，最好是通过扩展来实现，增加新的方法满足需求，而不是去修改原有代码。
4.3.里氏代换原则( Liskov Substitution Principle ,LSP )
定义：使用父类的地方能够使用子类来替换，反过来，则不行。
使用子类对象去替换父类对象，程序将不会产生错误
因此在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。
需要注意的是：
子类的所有方法必须在父类中声明，或子类必须实现父类中声明的所有方法。如果一个方法只存在子类中，没有在父类中声明，则无法在以父类定义的对象中使用该方法。
父类应当被尽量设计为抽象类或者接口，让子类继承父类或实现父接口，并实现在父类中声明的方法，运行时，子类实例替换父类实例，我们可以很方便地扩展系统的功能，同时无须修改原有子类的代码，增加新的功能可以通过增加一个新的子类来实现
4.4.依赖倒转原则( Dependence Inversion Principle ,DIP )
定义：抽象不应该依赖于细节，细节应当依赖于抽象。
即要面向接口编程，而不是面向具体实现去编程。
高层模块不应该依赖低层模块，应该去依赖抽象。
4.5.接口隔离法则(Interface Segregation Principle，ISL）
定义：一个类对另一个类的依赖应该建立在最小的接口上。
一个类不应该依赖他不需要的接口。
接口的粒度要尽可能小，如果一个接口的方法过多，可以拆成多个接口。
4.6.迪米特法则(Law of Demeter, LoD)
定义：一个类尽量不要与其他类发生关系
一个类对其他类知道的越少，耦合越小。
当修改一个类时，其他类的影响就越小，发生错误的可能性就越小。
5.  附录
UML图规范
