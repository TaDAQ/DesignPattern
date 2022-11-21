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
