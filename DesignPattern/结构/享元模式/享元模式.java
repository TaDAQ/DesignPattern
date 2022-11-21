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
